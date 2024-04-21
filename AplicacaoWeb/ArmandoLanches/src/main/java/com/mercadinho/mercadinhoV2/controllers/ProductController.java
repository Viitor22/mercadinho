package com.mercadinho.mercadinhoV2.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import com.mercadinho.mercadinhoV2.models.ProductModel;
import com.mercadinho.mercadinhoV2.repositories.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@PostMapping("/products")
	public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductModel product) {
		if (product == null) {

			throw new IllegalArgumentException("Produto inválido");
		} else {
			ProductModel productModel = new ProductModel();
			BeanUtils.copyProperties(product, productModel);
			productRepository.save(productModel);
			return ResponseEntity.status(HttpStatus.CREATED).body(productModel);

		}
	}

	@GetMapping("/getProducts")
	public ResponseEntity<List<ProductModel>> getAllProducts() {
		List<ProductModel> products = productRepository.findAll();
		if (products.isEmpty()) {

			throw new IllegalArgumentException("Lista vazia");

		} else {

			return ResponseEntity.status(HttpStatus.OK).body(products);

		}
	}

	@PostMapping("/products/update")
	public ResponseEntity<ProductModel> updateProduct(@RequestBody @Valid ProductModel productModel) {
		Optional<ProductModel> productOptional = productRepository.findById(productModel.getId());
		try {
			ProductModel existingProduct = productOptional.get();
			BeanUtils.copyProperties(productModel, existingProduct);
			productRepository.save(existingProduct);
			return ResponseEntity.ok().body(existingProduct);
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
