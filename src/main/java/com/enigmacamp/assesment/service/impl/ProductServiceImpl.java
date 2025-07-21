package com.enigmacamp.assesment.service.impl;

import com.enigmacamp.assesment.dto.request.ProductRequest;
import com.enigmacamp.assesment.dto.respose.ProductResponse;
import com.enigmacamp.assesment.entity.Product;
import com.enigmacamp.assesment.entity.Tax;
import com.enigmacamp.assesment.mapper.ProductMapper;
import com.enigmacamp.assesment.repository.ProductRepository;
import com.enigmacamp.assesment.service.ProductService;
import com.enigmacamp.assesment.service.TaxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final TaxService taxService;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        Set<Tax> taxes = taxService.getOrCreateTax(productRequest);

        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setTaxes(taxes);

        for (Tax tax : taxes) {
            tax.getProducts().add(product);
        }

        productRepository.save(product);
        return ProductMapper.toProductResponse(product);
    }

    @Override
    public ProductResponse updateProduct(ProductRequest productRequest) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> listProducts() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
