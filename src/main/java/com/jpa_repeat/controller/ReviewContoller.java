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
public class ReviewContoller {

    private final ReviewService reviewService;

    @PostMapping("/movies/{movieId}/reviews")
    public ResponseEntity<ReviewResponse> saveReview(
            @RequestBody ReviewRequest request,
            @PathVariable Long movieId
    ) {
        return ResponseEntity.ok(reviewService.save(request,movieId));
    }

    @GetMapping("/movies/{movieId}/reviews")
    public ResponseEntity<List<ReviewResponse>> getAllReviews(
            @PathVariable Long movieId
    ) {
        return ResponseEntity.ok(reviewService.findAll(movieId));
    }
}
