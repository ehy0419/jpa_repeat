package com.jpa_repeat.controller;

import com.jpa_repeat.dto.moviedto.MovieRequest;
import com.jpa_repeat.dto.moviedto.MovieResponse;
import com.jpa_repeat.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/movies")
    public ResponseEntity<MovieResponse> saveMovie(
            @RequestBody MovieRequest movieRequest) {
        return ResponseEntity.ok(movieService.save(movieRequest));
    }

    @GetMapping("/movies")
    public ResponseEntity<List<MovieResponse>> getAllMovies() {
        return ResponseEntity.ok(movieService.findAll());
    }
}
