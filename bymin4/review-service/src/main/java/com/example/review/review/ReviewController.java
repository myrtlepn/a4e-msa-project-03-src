package com.example.review.review;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static bymin4.share.utils.DtoConverter.convertObject;

@RestController
@RequestMapping("/products/{productId}/reviews")
public class ReviewController {
	private final ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@GetMapping("")
	public List<ReviewDto> getReviews(@PathVariable("productId") Long productId) throws IllegalAccessException {
		List<Review> reviews = reviewService.getReviews(productId);
		return converReviewsToReviewDtos(reviews);
	}

	@PostMapping("")
	public ReviewDto createReview(@PathVariable("productId") Long productId,
		@RequestBody Review review) throws IllegalAccessException {
		Review result = reviewService.create(productId, review);
		ReviewDto reviewDto = new ReviewDto();
		return convertObject(reviewDto, result);
	}

	@DeleteMapping("/{id}")
	public void createReview(@PathVariable("productId") Long productId,
		@PathVariable("id") Long id) {
		reviewService.delete(id);
	}

	static List<ReviewDto> converReviewsToReviewDtos(List<Review> reviews) {
		return reviews.stream().map(review -> {
			ReviewDto reviewDto;
			try {
				reviewDto = convertObject(new ReviewDto(), review);
			} catch (IllegalAccessException e) {
				reviewDto = new ReviewDto();
				e.printStackTrace();
			}
			return reviewDto;
		}).collect(Collectors.toList());
	}


}
