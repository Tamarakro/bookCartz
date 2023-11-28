package com.example.bookCartz.dtos.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookDto {
    private String name;
    private String Genre;
    private Integer quantity;
    private BigDecimal price;
}
