package com.example.restTemplateStudy.summary;

import com.apptasticsoftware.rssreader.Item;
import com.apptasticsoftware.rssreader.RssReader;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class News {
    @Test
    public void getBody() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.khgames.co.kr/news/articleView.html?idxno=207169";
        String forObject = restTemplate.getForObject(url, String.class);
        System.out.println(forObject);


    }

    @Test
    public void trendNewsGetBody() throws IOException {
        String url = "https://trends.google.co.kr/trends/trendingsearches/daily/rss?geo=KR";
        List<Item> items = new RssReader()
                .addItemExtension("ht:news_item_url", Item::setDescription)
                .read(url)
                .filter(item -> LocalDate.now().minusDays(1).equals(LocalDate.parse(item.getPubDate().get(), DateTimeFormatter.RFC_1123_DATE_TIME)))
                .collect(Collectors.toList());
        for (Item item : items) {

//            String forObject = new RestTemplate().getForObject(item.getDescription().get(), String.class);
//            System.out.println(forObject);
        }


    }
}
