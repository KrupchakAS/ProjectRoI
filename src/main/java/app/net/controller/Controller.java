package app.net.controller;

import app.net.dto.BookDto;
import app.net.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

@RestController
@RequestMapping(value = "/book")
public class Controller {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/get")
    public BookDto get(@RequestParam("id") Integer id) {
        return bookService.getBookById(id);
    }

    @PostMapping(value = "/create")
    public BookDto create(@Valid @RequestBody @NotNull(message = "Cannot create book. The object equals NULL.") BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @PostMapping(value = "/update")
    public Boolean update(@Valid @RequestBody @NotNull(message = "Cannot create book. The object equals NULL.") BookDto bookDto) {
        bookService.updateBook(bookDto);
        return true;
    }

    @DeleteMapping(value = "/delete")
    public Boolean delete(@Valid @RequestParam("id") Integer id) {
        bookService.delete(id);
        return true;
    }

    @GetMapping(value = "/find")
    public Set<BookDto> find(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "genre", required = false) String genre) {
        return bookService.findBooks(name, genre);
    }
}
