package DAO;

import Config.ConnectDatabase;
import Model.Book;

import javax.swing.*;
import java.io.FileWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    ConnectDatabase cnn = new ConnectDatabase();
    public List<Book> findAll() throws SQLException {
        Statement stmt = cnn.getConnectionDB().createStatement();
        ResultSet rs = stmt.executeQuery("select * from Book");
        // show data
        ArrayList<Book> list = new ArrayList<>();

        while (rs.next()) {
            Book book = new Book();
            book.setID(rs.getInt(1));
            book.setTitle(rs.getString(2));
            book.setAuthor(rs.getString(3));
            book.setReleaseDate(rs.getDate(4));
            book.setContent(rs.getString(5));
            list.add(book);
        }
        // close connection
        return list;
    }

    public Book findByName(String title) throws SQLException {
        Statement stmt = cnn.getConnectionDB().createStatement();
        ResultSet rs = stmt.executeQuery("select * from Book WHERE  Title = '" + title + "'");
        // show data
        Book book = new Book();

        while (rs.next()) {
            book.setID(rs.getInt(1));
            book.setTitle(rs.getString(2));
            book.setAuthor(rs.getString(3));
            book.setReleaseDate(rs.getDate(4));
            book.setContent(rs.getString(5));
        }
        // close connection
        return book;
    }

    public Book findById(int id) throws SQLException {
        Statement stmt = cnn.getConnectionDB().createStatement();
        ResultSet rs = stmt.executeQuery("select * from Book WHERE  ID = " + id);
        // show data
        Book book = new Book();

        while (rs.next()) {
            book.setID(rs.getInt(1));
            book.setTitle(rs.getString(2));
            book.setAuthor(rs.getString(3));
            book.setReleaseDate(rs.getDate(4));
            book.setContent(rs.getString(5));
        }
        // close connection
        return book;
    }

    //type = 1: Insert, type = 2:Update
    public Book save(Book book, int type) throws SQLException {
        if (type == 1) {
            String sql = "INSERT INTO Book(Title,Author,ReleaseDate,Content) VALUES(?,?,?,?)";
            PreparedStatement ps = cnn.getConnectionDB().prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setDate(3, (Date) book.getReleaseDate());
            ps.setString(4, book.getContent());
            if (ps.executeUpdate() > 0) {
                return book;
            }
            else {
                return null;
            }
        }
        else {
            String sql = "UPDATE Book SET Title = ?,Author = ?,ReleaseDate = ?,Content = ?  WHERE ID = ?";
            PreparedStatement ps = cnn.getConnectionDB().prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setDate(3, (Date) book.getReleaseDate());
            ps.setString(4, book.getContent());
            ps.setInt(5, book.getID());
            if (ps.executeUpdate() > 0) {
                return book;
            }
            else {
                return null;
            }
        }
    }

    public boolean deleteOne(int id) throws SQLException {
        String sql = "DELETE FROM Book WHERE ID = ?";
        PreparedStatement ps = cnn.getConnectionDB().prepareStatement(sql);
        ps.setInt(1, id);
        if (ps.executeUpdate() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean exportToTxt() throws SQLException {
        try {
            ArrayList<Book> list = (ArrayList<Book>) findAll();
            FileWriter myWriter = new FileWriter("listBook.txt");
            String content = "List Book \n";
            for (Book b : list)
            {
                String line = String.format("\nBookID: %d - Title %s - Author %s - Content %s"
                        ,b.getID(),b.getTitle(),b.getAuthor(),b.getContent());
                content = content.concat(line);
            }
            myWriter.write(content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public boolean exportToTxtById(int id) throws SQLException {
        try {
            Book b = findById(id);
            String line = String.format("\nBookID: %d - Title %s - Author %s - Content %s"
                    ,b.getID(),b.getTitle(),b.getAuthor(),b.getContent());
            FileWriter myWriter = new FileWriter("book.txt");
            myWriter.write(line);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            return true;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public JTextArea autoScroll() {
        try {
            JTextArea texta = new JTextArea("", 5, 20);
            texta.setText("Some example text");
            texta.setCaretPosition(texta.getDocument().getLength() - 1);
            return texta;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
