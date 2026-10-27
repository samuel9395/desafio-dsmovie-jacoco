package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.dto.MovieGenreDTO;
import com.devsuperior.dsmovie.services.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/movies")
@Tag(name = "Genres", description = "Controller for Genres")
public class MovieControllerV1 {

    @Autowired
    private MovieService service;

    @Operation(
            description = "Get all genres",
            summary = "List all genres",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200"),
            }
    )
    @GetMapping(produces = "application/json")
    public Page<MovieGenreDTO> findAll(Pageable pageable) {
        return service.findAllMovieGenre(pageable);
    }


    @Operation(
            description = "Get a genre by ID",
            summary = "Get a genre by ID",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200"),
                    @ApiResponse(description = "Not Found", responseCode = "404"),
            }
    )
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieGenreDTO findById(@PathVariable Long id) {
        return service.findByIdMovieGenre(id);
    }
}
