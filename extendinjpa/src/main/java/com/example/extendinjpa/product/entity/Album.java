package com.example.extendinjpa.product.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Album extends Product {
    String artist;

    public Album(String name, long price, String artist) {
        super(name, price);
        this.artist = artist;
    }


}
