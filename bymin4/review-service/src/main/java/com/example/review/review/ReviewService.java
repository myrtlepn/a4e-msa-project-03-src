package com.example.review.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewService {
	private final ReviewRepository reviewRepository;

	public Review create(Long productId, Review review) {
		review.setProductId(productId);
		reviewRepository.save(review);
		return review;
	}

	public void delete(Long id) {
		reviewRepository.deleteById(id);
	}
	
	public List<Review> getReviews() {
		return Optional.of(reviewRepository.findAll()).orElse(Collections.emptyList());
	}

	public List<Review> getReviews(Long productId) {
		return Optional.of(reviewRepository.findByProductId(productId)).orElse(Collections.emptyList());
	}
}
