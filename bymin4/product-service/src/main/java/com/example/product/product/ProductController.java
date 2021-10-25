package com.example.product.product;

import bymin4.share.domains.ProductDto;
import bymin4.share.domains.ReviewDto;
import com.example.product.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static bymin4.share.utils.DtoConverter.convertObject;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

	private final ReviewService reviewService;
	private final ProductService productService;

	@GetMapping("")
	public List<ProductDto> productList() {
		List<ProductDto> products = productService.findAll()
			.stream()
			.map(this::getConvertedProductDto)
			.peek(this::setReviews)
			.collect(Collectors.toList());

		return products;
	}

	private void setReviews(ProductDto productDto) {
		List<ReviewDto> reviews = getReviews(productDto);
		productDto.setReviews(Optional.of(reviews)
			.orElse(Collections.emptyList()));
	}

	private List<ReviewDto> getReviews(ProductDto productDto) {
		return Optional.of(reviewService.findByProductId(productDto.getId()))
			.orElse(Collections.emptyList());
	}

	private ProductDto getConvertedProductDto(Product product) {
		ProductDto productDto = new ProductDto();
		try {
			convertObject(productDto, product);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return productDto;
	}

	@PostMapping("")
	public Product productCreate(@RequestBody Product product) {
		return productService.create(product);
	}

	@GetMapping("/{id}")
	public Product productDetail(@PathVariable("id") Long id) {
		return productService.findById(id);
	}

	@PutMapping("/{id}")
	public Product productUpdate(@PathVariable("id") Long id, @RequestBody Product product) {
		return productService.update(id, product);
	}

	@DeleteMapping("/{id}")
	public void productDelete(@PathVariable("id") Long id) {
		productService.deleteById(id);
	}

}
