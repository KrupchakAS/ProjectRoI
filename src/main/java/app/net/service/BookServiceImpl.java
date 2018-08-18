package app.net.service;

import app.net.CannotFindObject;
import app.net.dao.BookDAO;
import app.net.dto.BookDto;
import app.net.entity.Book;
import app.net.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.Set;

import static app.net.mapper.BookMapper.GENRE_MAPPER;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    private static final BookMapper BOOK_MAPPER = new BookMapper();

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateBook(BookDto dto) {
        Book book = bookDAO.getBookById(dto.getId());
        if (book == null) {
            throw new CannotFindObject(String.format("Cannot find book with name \"%s\" and id \"%d\"", dto.getName(), dto.getId()));
        }
        book.setGenre(GENRE_MAPPER.mapListDto(dto.getGenres()));
        book.setPageCount(dto.getPages());
        book.setBookDescription(dto.getDescription());
        book.setBookName(dto.getName());
        bookDAO.update(book);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public BookDto createBook(BookDto book) {
        Book entity = BOOK_MAPPER.mapDto(book);
        bookDAO.createBook(entity);
        return BOOK_MAPPER.mapEntity(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void delete(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("Book's ID is null.");
        }
        Book book = bookDAO.getBookById(id);
        if (book == null) {
            throw new CannotFindObject(String.format("Cannot find book with id \"%d\"!", id));
        }
        bookDAO.delete(book);
    }


    public BookDto getBookById(Integer id) {
        return BOOK_MAPPER.mapEntity(bookDAO.getBookById(id));
    }

    @Transactional(readOnly = true)
    @Override
    public Set<BookDto> findBooks(String name, String genre) {
        return BOOK_MAPPER.mapSetEntity(bookDAO.findBooks(name, genre));
    }


}
