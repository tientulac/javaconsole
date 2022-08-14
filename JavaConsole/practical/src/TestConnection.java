import DAO.BookDAO;
import Model.Book;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) throws SQLException {

        BookDAO bookDAO = new BookDAO();
        Book book = new Book();
        book.setTitle("New");
        book.setAuthor("Tester");
        book.setReleaseDate(null);
        book.setContent("Hello world !");
        var rsInsert = bookDAO.autoScroll();
        if (rsInsert != null) {
            System.out.println(rsInsert);
        }
    }
}
