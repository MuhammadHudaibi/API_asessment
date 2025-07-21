package com.enigmacamp.assesment.mapper;

import com.enigmacamp.assesment.dto.respose.ProductResponse;
import com.enigmacamp.assesment.dto.respose.TaxResponse;
import com.enigmacamp.assesment.entity.Product;

import java.util.Set;
import java.util.stream.Collectors;

public class ProductMapper {
    public static ProductResponse toProductResponse(Product product) {
        Set<TaxResponse> taxResponses = product.getTaxes().stream()
                .map(TaxMapper::toTaxResponse)
                .collect(Collectors.toSet());

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .taxes(taxResponses)
                .build();
    }
}
