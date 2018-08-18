package app.net.dao;

import app.net.entity.Book;
import app.net.entity.Genre;

import java.util.List;
import java.util.Set;

public interface BookDAO {
    void createBook(Book book);
    void update(Book book);
    void delete(Book book);

    public Book getBookById(Integer id);


    public Set<Book> findBooks(String name, String genre);
}
