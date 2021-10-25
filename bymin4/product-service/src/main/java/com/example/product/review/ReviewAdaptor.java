package com.example.product.review;

import bymin4.share.domains.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewAdaptor {

	public static final String REVIEW_PREFIX = "lb://review";
	public static final String REVIEW_URI = "products/{productId}/reviews";

	private final WebClient.Builder webClientBuilder;

	public List<ReviewDto> findByProductId(Long productId) {
		ParameterizedTypeReference<List<ReviewDto>> returnTypeReference =
			new ParameterizedTypeReference<List<ReviewDto>>() {};

		List<ReviewDto> reviewDtos = webClientBuilder.build()
			.get().uri(generateUri(REVIEW_URI), productId)
			.retrieve()
			.bodyToMono(returnTypeReference)
			.blockOptional()
			.orElse(Collections.emptyList());

		return reviewDtos;
	}

	private String generateUri(String path) {
		return REVIEW_PREFIX + "/" + path;
	}
}
