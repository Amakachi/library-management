package com.gidimobile.librarymanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue
    Long id;
    @NotEmpty(message = "Please provide a name")
    String bookName;
    @NotEmpty(message = "Please provide a author")
    String author;
    @NotNull(message = "Please provide a price")
    String publisher;
    Long price;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(nullable=false,name="user_id")
    @JsonIgnore
    ApplicationUser applicationUser;
}
