package com.example.bookCartz.repository;

import com.example.bookCartz.model.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCartRepository extends JpaRepository<UserCart, Long> {

}
