package com.example.review.product;

import bymin4.share.domains.ReviewDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ProductAdaptor {
	public List<ReviewDto> findByProductId(Long productId) {
		return Collections.emptyList();
	}
}
