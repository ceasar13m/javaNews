package com.example.startup.controller;

import com.example.startup.dto.NewsDto;
import com.example.startup.response.CustomResponse;
import com.example.startup.service.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    @Operation(
            summary = "Добавление новости",
            method = "POST",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Новость добавлена",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = NewsDto.class)
                            )),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Не правильные данные",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "401",
                            description = "ПОльзователь не авторизован",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Данные не найдены",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Ошибка сервера",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
            }
    )
    @PostMapping("/add-news")
    public NewsDto addNews(@RequestBody NewsDto newsDto) {
        log.info("/add-news");
        return newsService
                .addNews(newsDto);
    }

    @Operation(
            summary = "Добавление новости",
            method = "POST",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Новость получена",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = NewsDto.class)
                            )),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Не правильные данные",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Пользователь не авторизован",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Данные не найдены",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Ошибка сервера",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
            }
    )
    @GetMapping("/get/{id}")
    public NewsDto getNews(@PathVariable Long id) {
        log.info("/get/{}", id);
        return newsService
                .getNews(id);
    }

    @Operation(
            summary = "Добавление новости",
            method = "POST",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Все новости получены",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = NewsDto.class)
                            )),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Не правильные данные",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Пользователь не авторизован",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Данные не найдены",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Ошибка сервера",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
            }
    )
    @GetMapping("/get-all")
    public Set<NewsDto> getAllNews() {
        log.info("/get-all");
        return newsService
                .getAllNews();
    }

    @Operation(
            summary = "Добавление новости",
            method = "POST",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Новость обновлена",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = NewsDto.class)
                            )),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Не правильные данные",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Пользователь не авторизован",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Данные не найдены",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Ошибка сервера",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
            }
    )
    @PostMapping("/update")
    public NewsDto update(@RequestBody NewsDto newsDto) {
        log.info("/update");
        return newsService
                .updateNews(newsDto);
    }

    @Operation(
            summary = "Добавление новости",
            method = "POST",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Новость удалена"),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Не правильные данные",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Пользователь не авторизован",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Данные не найдены",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Ошибка сервера",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CustomResponse.class)
                            )),
            }
    )
    @PostMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        log.info("/delete");
        newsService
                .deleteNews(id);
    }
}
