package com.gidimobile.librarymanagement.models;

import javax.persistence.*;
import java.util.Date;
@Entity

public class LendBook {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(nullable=false,name="user_id")
    ApplicationUser receiver;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(nullable=false,name="book_id")
    Book book;
    Date dateCreated;
    Date dateReturned;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ApplicationUser getReceiver() {
        return receiver;
    }

    public void setReceiver(ApplicationUser receiver) {
        this.receiver = receiver;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(Date dateReturned) {
        this.dateReturned = dateReturned;
    }
}
