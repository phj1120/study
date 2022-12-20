package com.example.restTemplateStudy.insta;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.StringJoiner;

@SpringBootTest
public class PostImage {

    String instagramBaseUrl = "https://graph.facebook.com";
    String apiVersion = "v15.0";
    @Value("${igUserId}")
    String igUserId;

    @Value("${accessToken}")
    String accessToken;

    @Value("${clientId}")
    String clientId;

    @Value("${clientSecret}")
    String clientSecret;

    @DisplayName("GET 요청")
    @Test
    public void makeToken() {
        RestTemplate restTemplate = new RestTemplate();
        String url = instagramBaseUrl + "/oauth/access_token?client_id=" + clientId + "&client_secret=" + clientSecret + "&grant_type=client_credentials";
        ResponseEntity<MakeTokenDto> forEntity = restTemplate.getForEntity(url, MakeTokenDto.class);

        Assertions.assertThat(forEntity.getBody().getAccess_token()).isNotEmpty();
        Assertions.assertThat(forEntity.getBody().getToken_type()).isNotEmpty();
    }

    @DisplayName("POST 요청")
    @Test
    public void makeContainer() {
        String imageUrl = "https://img.freepik.com/free-vector/realistic-galaxy-background_52683-12122.jpg";
        String caption = "test";
        String url = instagramBaseUrl + "/" + apiVersion + "/" + igUserId + "/media?access_token=" + accessToken + "&image_url=" + imageUrl + "&caption=" + caption;
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, headers);
        ResponseEntity<Container> stringResponseEntity = restTemplate.postForEntity(url, request, Container.class);
        System.out.println(stringResponseEntity);
    }

    static class MakeTokenDto implements Serializable {
        String access_token;
        String token_type;

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public String getToken_type() {
            return token_type;
        }

        public void setToken_type(String token_type) {
            this.token_type = token_type;
        }
    }


    static class Container implements Serializable {
        String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Container.class.getSimpleName() + "[", "]")
                    .add("id='" + id + "'")
                    .toString();
        }
    }
}
