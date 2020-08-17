package com.gidimobile.librarymanagement.repository;

import com.gidimobile.librarymanagement.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByBookName(String bookName);
}
