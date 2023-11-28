package com.example.bookCartz.controller;

import com.example.bookCartz.dtos.request.BookDto;
import com.example.bookCartz.dtos.request.UserDto;
import com.example.bookCartz.model.Book;
import com.example.bookCartz.model.User;
import com.example.bookCartz.model.UserCart;
import com.example.bookCartz.service.GeneralServices;
import com.example.bookCartz.service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private UserServices userServices;
    private Book book;
    private GeneralServices generalServices;
    @PatchMapping("/book/{id}")
    public ResponseEntity<String>addBook(@RequestBody BookDto bookDto, @PathVariable Long id){
        Optional<Book> bookOptional = generalServices.findById(id);
        if (!bookOptional.isEmpty()){
            UserCart userCart = new UserCart();
            userCart.setBookName(bookDto.getName());
            userCart.setQuantity(bookDto.getQuantity());
            userCart.setPrice(bookDto.getPrice());
            userServices.addBookToCart(userCart);
            return new ResponseEntity<>("Book Successfully added", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("The item you searched for was not found",HttpStatus.NOT_FOUND);
    }
    @GetMapping("book/{id}")
    public ResponseEntity<UserCart>getById(@PathVariable Long id){
        Optional<UserCart>userCartOptional = userServices.findBookById(id);
        if (!userCartOptional.isEmpty()){
            return new ResponseEntity<>(userCartOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/book")
    public ResponseEntity<List<UserCart>>findAllItems() {
        List<UserCart> userCarts = userServices.findAllItems();
    return new ResponseEntity<>(userCarts, HttpStatus.OK);
    }

    @PatchMapping("details/{id}")
    public ResponseEntity<String>updateDetails(@RequestBody UserDto userToBeUpdated, @PathVariable Long id){
    Optional<User>optionalUser = userServices.findById(id);
    if (optionalUser.isEmpty()){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    User userUpdating = optionalUser.get();
    userUpdating.setLastName(userToBeUpdated.getLastName());
    userUpdating.setFirstName(userToBeUpdated.getFirstName());
    userServices.updateUser(userUpdating);
    return new ResponseEntity<>("Successfully updated your profile", HttpStatus.CREATED);
    }
}
