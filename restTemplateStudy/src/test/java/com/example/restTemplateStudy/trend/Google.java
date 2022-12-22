package com.example.restTemplateStudy.trend;

import com.apptasticsoftware.rssreader.Item;
import com.apptasticsoftware.rssreader.RssReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Google {

    @Test
    public void getTrend() throws IOException {
        RssReader rssReader = new RssReader();
        rssReader.addItemExtension("ht:news_item_url", Item::setDescription);
        String url = "https://trends.google.co.kr/trends/trendingsearches/daily/rss?geo=KR";
        List<Item> collect = rssReader.read(url)
                .filter(item -> {
                    String pubDate = item.getPubDate().orElse(LocalDateTime.now().minusDays(1L).toString());
                    LocalDate parse = LocalDate.parse(pubDate, DateTimeFormatter.RFC_1123_DATE_TIME);
                    return parse.equals(LocalDate.now());
                })
                .collect(Collectors.toList());
        for (Item item : collect) {
            System.out.println(item.getDescription());
        }
    }

    @Test
    public void getTrendSimple() throws IOException {
        String url = "https://trends.google.co.kr/trends/trendingsearches/daily/rss?geo=KR";
        List<Item> items = new RssReader()
                .addItemExtension("ht:news_item_url", Item::setDescription)
                .read(url)
                .filter(item -> LocalDate.now().minusDays(1).equals(LocalDate.parse(item.getPubDate().get(), DateTimeFormatter.RFC_1123_DATE_TIME)))
                .collect(Collectors.toList());
        for (Item item : items) {
            System.out.println(item.getDescription());
        }
    }

}
