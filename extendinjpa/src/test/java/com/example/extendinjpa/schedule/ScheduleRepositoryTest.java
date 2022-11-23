package com.example.extendinjpa.schedule;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor
class ScheduleRepositoryTest {

    private final ScheduleRepository scheduleRepository;

    @Test
    public void addSchedule() {
//        Schedule schedule = new Schedule("schedule");
        Todo todo = new Todo("todo", true);
        Habit habit = new Habit("habit");

        scheduleRepository.save(todo);
        scheduleRepository.save(habit);

        Schedule todoSchedule = scheduleRepository.findById(todo.getId()).orElseThrow();
        Schedule habitSchedule = scheduleRepository.findById(habit.getId()).orElseThrow();


        Assertions.assertThat(todoSchedule instanceof Todo).isTrue();
        Assertions.assertThat(todoSchedule instanceof Schedule).isTrue();
        Assertions.assertThat(todoSchedule instanceof Habit).isFalse();

        Assertions.assertThat(habitSchedule instanceof Todo).isFalse();
        Assertions.assertThat(habitSchedule instanceof Schedule).isTrue();
        Assertions.assertThat(habitSchedule instanceof Habit).isTrue();
    }
}