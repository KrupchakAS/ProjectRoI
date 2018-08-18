package app.net.mapper;

import app.net.dto.BookDto;
import app.net.entity.Book;

public class BookMapper extends Mapper<Book, BookDto> {
    public static final GenreMapper GENRE_MAPPER = new GenreMapper();

    public BookDto mapEntity(Book book) {
        if (book == null) {
            return null;
        }
        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setDescription(book.getBookDescription());
        dto.setName(book.getBookName());
        dto.setPages(book.getPageCount());
        dto.setGenres(GENRE_MAPPER.mapListEntity(book.getGenre()));
        return dto;
    }

    @Override
    public Book mapDto(BookDto dto) {
        if (dto == null) {
            return null;
        }
        Book entity = new Book();
        entity.setId(dto.getId());
        entity.setBookName(dto.getName());
        entity.setBookDescription(dto.getName());
        entity.setPageCount(dto.getPages());
        entity.setGenre(GENRE_MAPPER.mapListDto(dto.getGenres()));
        return entity;
    }
}
