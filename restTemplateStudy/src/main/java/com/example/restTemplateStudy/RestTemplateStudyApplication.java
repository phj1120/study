package com.example.restTemplateStudy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestTemplateStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateStudyApplication.class, args);

        RestTemplateStudyApplication restTemplateStudyApplication = new RestTemplateStudyApplication();
    }

}
