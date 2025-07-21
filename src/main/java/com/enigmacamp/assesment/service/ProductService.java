package com.enigmacamp.assesment.service;

import com.enigmacamp.assesment.dto.request.ProductRequest;
import com.enigmacamp.assesment.dto.respose.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);
    ProductResponse updateProduct(ProductRequest productRequest);
    List<ProductResponse> listProducts();
}
