package com.example.bookCartz.controller;

import com.example.bookCartz.enums.Genre;
import com.example.bookCartz.model.Book;
import com.example.bookCartz.model.User;
import com.example.bookCartz.service.GeneralServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class GeneralController {
    private GeneralServices generalServices;
    private Book book;
    @GetMapping("/{genre}")
    public ResponseEntity<List<Book>>findBookByGenre(@PathVariable Genre genre){
        List<Book>books = generalServices.findByGenre(genre);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @GetMapping("/book")
    public ResponseEntity<List<Book>>findAllBooks(){
        List<Book>books = generalServices.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    }

