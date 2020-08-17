package com.gidimobile.librarymanagement.services;

import com.gidimobile.librarymanagement.models.Book;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


public interface BookService {
     void updateBook(String bookName, Book book);

     String addBook(Book book );
}
