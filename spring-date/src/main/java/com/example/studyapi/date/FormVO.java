package com.example.studyapi.date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * Form 으로 받을 경우
 * <p>
 * Getter: 필수
 * Setter: 필수
 * 기본생성자: 선택
 * 전체생성자: 선택
 */
@Getter
@Setter
public class FormVO {

    private FormVO() {
    }

    String id;

    /**
     * Http Form, Query String 으로 받을 경우
     * <p>
     * DateTimeFormat: 요청, yyyy-MM-dd'T'HH:mm:ss 패턴은 항상 바인딩 가능.
     * JsonFormat: 응답
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime localDateTime;
}
