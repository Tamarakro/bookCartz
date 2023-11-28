package com.example.bookCartz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCart {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User user;
    @Column(name = "book_name")
    private String bookName;
    private Long quantity;
    private BigDecimal price;

}
