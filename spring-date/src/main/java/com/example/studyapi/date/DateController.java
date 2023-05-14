package com.example.studyapi.date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/date")
public class DateController {

    @GetMapping("/test")
    private String test() {
        return "ok";
    }

    @GetMapping("/get")
    public String get(@RequestParam String id,
                      @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime localDateTime) {
        log.info(id);
        log.info("{}", localDateTime);

        return "ok";
    }

    @PostMapping("/form")
    public FormVO testForm(FormVO vo) {
        return vo;
    }

    @PostMapping("/body")
    public BodyVO testBody(@RequestBody BodyVO vo) {
        return vo;
    }
}