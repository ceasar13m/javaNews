package com.example.startup.service;

import com.example.startup.dto.NewsDto;
import java.util.Set;


public interface NewsService {

    NewsDto addNews(NewsDto newsDto);

    NewsDto getNews(Long id);

    Set<NewsDto> getAllNews();

    NewsDto updateNews(NewsDto newsDto);

    void deleteNews(Long id);
}
