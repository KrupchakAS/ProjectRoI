package app.net.service;

import app.net.dto.BookDto;

import java.util.Set;

public interface BookService {

    BookDto createBook(BookDto book);
    void updateBook(BookDto book);
    void delete(Integer id);
    BookDto getBookById(Integer id);
    Set<BookDto> findBooks(String name, String genre);
}
