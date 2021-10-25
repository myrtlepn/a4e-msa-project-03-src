package com.example.product.review;

import bymin4.share.domains.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

	private final ReviewAdaptor reviewAdaptor;
	public List<ReviewDto> findByProductId(Long productId) {
		return reviewAdaptor.findByProductId(productId);
	}
}
