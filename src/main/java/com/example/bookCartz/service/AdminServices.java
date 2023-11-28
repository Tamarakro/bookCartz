package com.example.bookCartz.service;

import com.example.bookCartz.model.Book;
import com.example.bookCartz.model.User;
import com.example.bookCartz.repository.BookRepository;
import com.example.bookCartz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServices {
    private User user;
    private UserRepository userRepository;
    private BookRepository bookRepository;
    public Optional<User>findById(Long id){
        return userRepository.findById(id);
    }
    public List<User>retrieveAll(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
    public Book addBook(Book book){
    return bookRepository.save(book);
    }
}
