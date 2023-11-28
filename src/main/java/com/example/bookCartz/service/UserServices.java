package com.example.bookCartz.service;

import com.example.bookCartz.model.User;
import com.example.bookCartz.model.UserCart;
import com.example.bookCartz.repository.BookRepository;
import com.example.bookCartz.repository.UserCartRepository;
import com.example.bookCartz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServices {
    private User user;
    private UserRepository userRepository;
    private BookRepository bookRepository;
    private UserCartRepository userCartRepository;
    public UserCart addBookToCart(UserCart userCart){
        return userCartRepository.save(userCart);
    }
    public Optional<UserCart>findBookById(Long id){
        return userCartRepository.findById(id);
    }
    public User updateUser(User userToUpdate){
        return userRepository.save(userToUpdate);
    }
    public Optional<User>findById(Long id){
        return userRepository.findById(id);
    }
    public List<UserCart>findAllItems(){
        List<UserCart>userCarts = new ArrayList<>();
        userCartRepository.findAll().forEach(userCarts::add);
        return userCarts;
    }
}
