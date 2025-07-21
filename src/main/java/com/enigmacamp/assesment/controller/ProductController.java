package com.enigmacamp.assesment.controller;

import com.enigmacamp.assesment.dto.request.ProductRequest;
import com.enigmacamp.assesment.dto.respose.ProductResponse;
import com.enigmacamp.assesment.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping
    public List<ProductResponse> listProducts() {
        return productService.listProducts();
    }
}
