package com.enigmacamp.assesment.mapper;

import com.enigmacamp.assesment.dto.respose.ProductResponse;
import com.enigmacamp.assesment.entity.Product;
import com.enigmacamp.assesment.entity.Tax;

import java.util.Collections;

public class ProductMapper {
    public static ProductResponse toProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .taxes(Collections.singleton(TaxMapper.toTaxResponse((Tax) product.getTaxes())))
                .build();
    }
}
