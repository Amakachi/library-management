package com.gidimobile.librarymanagement.services.serviceImpl;

import com.gidimobile.librarymanagement.models.ApplicationUser;
import com.gidimobile.librarymanagement.models.Book;
import com.gidimobile.librarymanagement.repository.BookRepository;
import com.gidimobile.librarymanagement.security.LoggedInUser;
import com.gidimobile.librarymanagement.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    LoggedInUser loggedInUser;

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public String addBook(Book book ){
        book.setApplicationUser(loggedInUser.getCurrentUser());
        bookRepository.save(book);
        return "Book added successfuly";
    }

    public void updateBook(String bookName, Book book){
        Book updateBook = bookRepository.findByBookName(bookName);
        if(Objects.nonNull(updateBook)){
            updateBook.setAuthor(book.getAuthor());
            updateBook.setPrice(book.getPrice());
            updateBook.setBookName(book.getBookName());
            updateBook.setPublisher(book.getPublisher());
        }
    }

    public void deleteBook(String bookName){
        Book deleteBook = bookRepository.findByBookName(bookName);
        if(Objects.nonNull(deleteBook)){
            bookRepository.delete(deleteBook);
        }
    }

    //New
    public List<Book> getAllBooks(){
       List<Book> bookLists = bookRepository.findAll();
       return bookLists;
    }
}
