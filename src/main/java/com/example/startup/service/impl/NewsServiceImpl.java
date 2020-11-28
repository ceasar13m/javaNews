package com.example.startup.service.impl;

import com.example.startup.dto.NewsDto;
import com.example.startup.entity.NewsEntity;
import com.example.startup.mapper.NewsMapper;
import com.example.startup.repository.NewsRepository;
import com.example.startup.service.NewsService;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository repository;
    private final NewsMapper mapper;

    @Override
    public NewsDto addNews(NewsDto newsDto) {
        if (repository.existsByTitle(newsDto.getTitle())) {
            log.error("News already exists by title = {}", newsDto.getTitle());
            throw new EntityExistsException("Entity already exists by title = '" + newsDto.getTitle() + "'");
        }
        log.debug("Adding news. Title = {}", newsDto.getTitle());

        return mapper.toNewsDto(repository.saveAndFlush(mapper.toNewsEntity(newsDto)));
    }

    @Override
    public NewsDto getNews(Long id) {
        if (!repository.existsById(id)) {
            log.error("News not found by id = {}", id);
            throw new EntityNotFoundException("Entity not found by id = " + id);
        }

        log.debug("Getting news by id = {}", id);

        return repository.findById(id)
                .map(mapper::toNewsDto)
                .orElse(null);
    }

    @Override
    public Set<NewsDto> getAllNews() {
        log.debug("Getting all news");

        return repository.findAll().stream()
                .map(mapper::toNewsDto)
                .collect(Collectors.toSet());
    }

    @Override
    public NewsDto updateNews(NewsDto newsDto) {
        log.debug("Update news. id = {}", newsDto.getId());
        return mapper.toNewsDto(repository.saveAndFlush(mapper.toNewsEntity(newsDto)));
    }

    @Override
    public void deleteNews(Long id) {
        if (!repository.existsById(id))
            throw new EntityNotFoundException("Entity not found by id = " + id);
        repository.deleteById(id);
    }
}
