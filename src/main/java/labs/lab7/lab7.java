package labs.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private String status; // e.g., "Available", "Checked Out", "Reserved"

    // Constructor
    public Book(String title, String author, String ISBN, String status) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.status = status;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getISBN() { return ISBN; }
    public String getStatus() { return status; }

    // Setters
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

class Library {
    private List<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    public Library(List<Book> books) {
        books = new ArrayList<>(books);
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Find a book by ISBN
    public Optional<Book> findBookByISBN(String ISBN) {
        for(Book book: books){
            if(book.getISBN().equals(ISBN))
                    return Optional.of(book);
        }
        return Optional.empty();
    }
}


public class lab7 {
    public static void main(String[] args) {
        Book book = new Book("title", "author", "ISBN1", "available");
        Book book2 = new Book("title2", "autho2r", "ISBN2", "available");
        Book book3 = new Book("title3", "autho3r", "ISBN3", "available");
        Library library = new Library();
        library.addBook(book);
        library.addBook(book2);
        library.addBook(book3);
        Book foundBook = library.findBookByISBN("ISBN6").orElseThrow(() -> new IllegalArgumentException("No book with provided ISBN was found"));
        System.out.println(foundBook.getTitle());


    }
}
