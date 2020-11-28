package com.example.startup.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class NewsDto {

    @Schema(description = "Id")
    private Long id;

    @Schema(description = "Заголовок новости")
    private String title;

    @Schema(description = "Текст новости")
    private String content;

    @Schema(description = "Время создания")
    private LocalDateTime date;

    @Schema(description = "Опубликован или нет(true/false)")
    private boolean published;

    @Schema(description = "Url фотографии")
    private String photo;
}
