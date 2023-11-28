package com.example.bookCartz.repository;

import com.example.bookCartz.enums.Genre;
import com.example.bookCartz.model.Book;
import com.example.bookCartz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book>findByGenre(Genre genre);
}
