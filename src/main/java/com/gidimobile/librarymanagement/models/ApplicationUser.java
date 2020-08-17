package com.gidimobile.librarymanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String email;
    @OneToMany(mappedBy= "applicationUser", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonIgnore
    List<Book> books;
}
