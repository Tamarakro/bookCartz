package com.example.bookCartz.service;

import com.example.bookCartz.enums.Genre;
import com.example.bookCartz.model.Book;
import com.example.bookCartz.model.User;
import com.example.bookCartz.repository.BookRepository;
import com.example.bookCartz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GeneralServices {
    private Book book;

    private BookRepository bookRepository;

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }
    public Optional<Book> findByGenre(Genre genre) {
        return bookRepository.findByGenre(genre);
    }
    public List<Book>findAllBooks(){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;

    }
}
