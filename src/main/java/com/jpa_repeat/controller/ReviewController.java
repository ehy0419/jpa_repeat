package com.jpa_repeat.controller;

import com.jpa_repeat.dto.reviewdto.ReviewRequest;
import com.jpa_repeat.dto.reviewdto.ReviewResponse;
import com.jpa_repeat.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/movies/{movieId}/reviews")
    public ResponseEntity<ReviewResponse> saveReview(
            @RequestBody ReviewRequest reviewRequest,
            @PathVariable Long movieId
            ) {
        return ResponseEntity.ok(reviewService.save(reviewRequest, movieId));
    }
    @GetMapping("/movies/{movieId}/reviews")
    public ResponseEntity<List<ReviewResponse>> getAllReview(
            @PathVariable Long movieId
    ) {
        return ResponseEntity.ok(reviewService.findAll(movieId));
    }
}
