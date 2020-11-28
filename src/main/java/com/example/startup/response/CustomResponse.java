package com.example.startup.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CustomResponse {

    @Schema(description = "Код ошибки")
    private int code;

    @Schema(description = "URL")
    private String path;

    @Schema(description = "Текст ошибки")
    private String message;

    @Schema(description = "Время ошибки")
    private LocalDateTime date;
}
