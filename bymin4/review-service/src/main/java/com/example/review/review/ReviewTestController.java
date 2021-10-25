package com.example.review.review;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static bymin4.share.utils.DtoConverter.convertObject;

@RestController
@RequestMapping("/reviews")
public class ReviewTestController {
	private final ReviewService reviewService;

	public ReviewTestController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@GetMapping("")
	public List<ReviewDto> getReviews() throws IllegalAccessException {
		List<Review> reviews = reviewService.getReviews();
		return converReviewsToReviewDtos(reviews);
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
