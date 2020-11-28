package com.example.startup.mapper;

import com.example.startup.dto.NewsDto;
import com.example.startup.entity.NewsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsMapper {

    NewsDto toNewsDto(NewsEntity newsEntity);

    NewsEntity toNewsEntity(NewsDto newsDto);
}
