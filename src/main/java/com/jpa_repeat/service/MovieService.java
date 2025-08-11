package com.jpa_repeat.service;

import com.jpa_repeat.dto.moviedto.MovieRequest;
import com.jpa_repeat.dto.moviedto.MovieResponse;
import com.jpa_repeat.entity.Movie;
import com.jpa_repeat.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    @Transactional
    public MovieResponse save(MovieRequest request) {
        Movie movie = new Movie(request.getTitle());
        Movie savedMovie = movieRepository.save(movie);
        return new MovieResponse(
                savedMovie.getId(),
                savedMovie.getTitle()
        );
    }

    @Transactional(readOnly = true)
    public List<MovieResponse> findAll() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(movie -> new MovieResponse(
                        movie.getId(),
                        movie.getTitle()
                )).toList();
    }

    @Transactional(readOnly = true)
    public MovieResponse findOne(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("이 moiveId는 없습니다")
        );
        return new MovieResponse(
                movie.getId(),
                movie.getTitle()
        );
    }

    @Transactional
    public MovieResponse update(Long id, MovieRequest movieRequest) {
        Movie movie = movieRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("이 moiveId는 없습니다")
        );
        return new MovieResponse(
                movie.getId(),
                movie.getTitle()
        );
    }
}
