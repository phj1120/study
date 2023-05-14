package com.example.studyapi.date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * Body 으로 받을 경우
 * <p>
 * Getter: 필수
 * Setter: 선택
 * 기본생성자: 선택
 * 전체생성자: 선택
 */
@Getter
public class BodyVO {
    private BodyVO() {
    }

    String id;

    /**
     * Http body 로 받을 경우
     * <p>
     * DateTimeFormat: X
     * JsonFormat: 요청, 응답
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime localDateTime;
}
