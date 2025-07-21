package com.enigmacamp.assesment.service.impl;

import com.enigmacamp.assesment.dto.request.ProductRequest;
import com.enigmacamp.assesment.dto.respose.TaxResponse;
import com.enigmacamp.assesment.entity.Tax;
import com.enigmacamp.assesment.repository.TaxRepository;
import com.enigmacamp.assesment.service.TaxService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TaxServiceImpl implements TaxService {

    private final TaxRepository taxRepository;

    @Override
    public Set<Tax> getOrCreateTax(ProductRequest productRequest) {
        Set<Tax> taxes = new HashSet<>();

        for (String taxName : productRequest.getTaxName()){
            Tax tax = taxRepository.findByName(taxName)
                    .orElseGet(() -> {
                        Tax newTax = new Tax();
                        if (taxName.equalsIgnoreCase("ppn")){
                            newTax.setName(taxName);
                            newTax.setPercentageTax(BigDecimal.valueOf(0.11));
                        } else {
                            newTax.setName(taxName);
                            newTax.setPercentageTax(BigDecimal.valueOf(0.25));
                        }
                        return taxRepository.save(newTax);
                    });

            taxes.add(tax);
        }
        return taxes;
    }
}
