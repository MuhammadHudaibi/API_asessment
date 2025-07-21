package com.enigmacamp.assesment.service;

import com.enigmacamp.assesment.dto.request.ProductRequest;
import com.enigmacamp.assesment.dto.respose.TaxResponse;
import com.enigmacamp.assesment.entity.Tax;

import java.util.Set;

public interface TaxService {
    Set<Tax> getOrCreateTax(ProductRequest productRequest);
}
