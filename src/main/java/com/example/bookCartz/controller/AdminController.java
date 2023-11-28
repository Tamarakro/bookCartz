package com.example.bookCartz.controller;

import com.example.bookCartz.dtos.request.BookDto;
import com.example.bookCartz.model.Book;
import com.example.bookCartz.model.User;
import com.example.bookCartz.service.AdminServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {
    private AdminServices adminServices;
    @GetMapping("/user/{id}")
    public ResponseEntity<User>getUser(@PathVariable Long id){
        Optional<User>optionalUser = adminServices.findById(id);
        if (!optionalUser.isEmpty()){
            return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
        }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/user")
    public ResponseEntity<List<User>>retrieveAll(){
        List<User>users = adminServices.retrieveAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String>deleteById(@PathVariable Long id){
        adminServices.deleteById(id);
        return new ResponseEntity<>("User successfully deleted",HttpStatus.OK);
    }
    @PostMapping("/book")
    public ResponseEntity<String>addBook(@RequestBody BookDto bookDto){
        Book book = new Book();
        book.setName(bookDto.getName());
        book.setGenre(bookDto.getGenre());
        book.setQuantity(bookDto.getQuantity());
        book.setPrice(bookDto.getPrice());
        adminServices.addBook(book);
        return new ResponseEntity<>("Book has been successfully added", HttpStatus.CREATED);
    }
}
