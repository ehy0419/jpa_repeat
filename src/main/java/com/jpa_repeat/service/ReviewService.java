package com.jpa_repeat.service;

import com.jpa_repeat.dto.reviewdto.ReviewRequest;
import com.jpa_repeat.dto.reviewdto.ReviewResponse;
import com.jpa_repeat.entity.Movie;
import com.jpa_repeat.entity.Review;
import com.jpa_repeat.repository.MovieRepository;
import com.jpa_repeat.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    @Transactional
    public ReviewResponse save(ReviewRequest reviewRequest, Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("그런 movieId의 movie는 없어요")
        );
        Review review = new Review(
                reviewRequest.getContent(),
                movie
        );
        Review savedReview = reviewRepository.save(review);
        return new ReviewResponse(
                savedReview.getId(),
                savedReview.getContent()
        );
    }

    @Transactional(readOnly = true)
    public List<ReviewResponse> findAll(Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new IllegalArgumentException("그런 movieId의 movie는 없어요")
        );

        List<Review> movies = reviewRepository.findAllByMovie(movie);
        List<ReviewResponse> reviewResponses = new ArrayList<>();

        for (Review review : movies) {
            reviewResponses.add(new ReviewResponse(
                    review.getId(),
                    review.getContent()
            ));
        }
        return reviewResponses;
    }
}

