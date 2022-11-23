package com.example.extendinjpa.product.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    Long id;

    private String name;

    private long price;

    public Product(String name, long price) {
        this.name = name;
        this.price = price;
    }
}
