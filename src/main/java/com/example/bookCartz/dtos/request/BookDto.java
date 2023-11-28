package com.example.bookCartz.dtos.request;

import com.example.bookCartz.enums.Genre;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookDto {
    private String name;
    private Genre genre;
    private Integer quantity;
    private BigDecimal price;
}
