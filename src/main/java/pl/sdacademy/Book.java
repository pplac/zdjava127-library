package pl.sdacademy;
import javax.persistence.*;
import java.sql.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "book_title")
    private String title;

    @Column(name = "isbn_number")
    private String isbn;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "author")
    private String author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    List<BookRegistration> bookRegistrationList;

    public List<BookRegistration> getBookRegistrationList() {
        return bookRegistrationList;
    }

    public void setBookRegistrationList(List<BookRegistration> bookRegistrationList) {
        this.bookRegistrationList = bookRegistrationList;
    }

    public void addBookRegistration(BookRegistration bookRegistartion){
        if (bookRegistrationList == null){
            bookRegistrationList = new ArrayList<>();
        }
        bookRegistrationList.add(bookRegistartion);
        bookRegistartion.setBook(this);
    }

    public Book() {
    }

    public Book(String title, String isbn, String publisher, String author) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}


