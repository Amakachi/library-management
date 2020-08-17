package com.gidimobile.librarymanagement.controller;

import com.gidimobile.librarymanagement.models.Book;
import com.gidimobile.librarymanagement.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/update")
    public void updateBook(@PathVariable String bookName, Book book){
        bookService.updateBook(bookName, book);
    }

    @PostMapping("/add")
    public String addBook(@RequestBody Book book){
        bookService.addBook(book);
        return "Book added successfully";
    }
    @GetMapping("/list")
    public List<Book> getAllBooks(){
      return bookService.getAllBooks();

    }
}
