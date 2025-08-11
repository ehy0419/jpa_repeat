package com.jpa_repeat.repository;

import com.jpa_repeat.entity.Movie;
import com.jpa_repeat.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByMovieId(Movie movie);
}
