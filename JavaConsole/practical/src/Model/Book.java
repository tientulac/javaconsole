package Model;

import java.sql.Date;
import java.time.LocalDate;

public class Book {
    private int ID;
    private String Title;
    private String Author;
    private Date ReleaseDate;
    private String Content;

    public Book(int ID, String title, String author, Date releaseDate, String content) {
        this.ID = ID;
        Title = title;
        Author = author;
        ReleaseDate = releaseDate;
        Content = content;
    }

    public Book() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Date getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        ReleaseDate = releaseDate;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
