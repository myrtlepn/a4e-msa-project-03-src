package com.example.review.product;

import bymin4.share.domains.ProductDto;
import bymin4.share.domains.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductAdaptor productAdapter;

	public Optional<ProductDto> findById(Long productId) {
		return Optional.empty();
	}
}
