package com.example.extendinjpa.schedule;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Todo extends Schedule {
    private boolean isCompleted;

    public Todo(String title, boolean isCompleted) {
        super(title);
        this.isCompleted = isCompleted;
    }
}


