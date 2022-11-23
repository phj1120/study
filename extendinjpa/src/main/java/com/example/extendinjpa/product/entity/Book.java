package com.example.extendinjpa.product.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book extends Product {
    String isbn;

    public Book(String name, long price, String isbn) {
        super(name, price);
        this.isbn = isbn;
    }
}
