package com.example.studyapi.date;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Slf4j
@WebMvcTest
public class DateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        String url = "/date/test";
        ResultActions perform = mockMvc.perform(get(url))
                .andExpect(content().string("ok"));
    }

    @Test
    public void requestTest() throws Exception {
        String url = "/date/get";

        ResultActions perform = mockMvc.perform(get(url)
                .param("id", "formTest")
                .param("localDateTime", "2022-01-22 11:22:00")
        );
        perform.andExpect(MockMvcResultMatchers.content().string("ok"));
        log.info("Fin");
    }

    @Test
    public void formTest() throws Exception {
        String url = "/date/form";

        ResultActions perform = mockMvc.perform(post(url)
                .param("id", "formTest")
                .param("localDateTime", "2022-01-22 11:22:00")
        );

        perform.andExpect(jsonPath("id").value("formTest"));
        perform.andExpect(jsonPath("localDateTime").value("2022-01-22 11:22:00"));
    }

    @Test
    public void bodyTest() throws Exception {
        String url = "/date/body";

        String content = "{\"id\":\"bodyTest\",\"localDateTime\":\"2023-05-14 11:53:00\"}";
        ResultActions perform = mockMvc.perform(post(url).content(content)
                .contentType(MediaType.APPLICATION_JSON));

        perform.andExpect(jsonPath("id").value("bodyTest"));
        perform.andExpect(jsonPath("localDateTime").value("2023-05-14 11:53:00"));
    }
}