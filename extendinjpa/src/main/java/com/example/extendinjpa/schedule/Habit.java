package com.example.extendinjpa.schedule;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Habit extends Schedule {
    public Habit(String title) {
        super(title);
    }
}
