package com.enigmacamp.assesment.mapper;

import com.enigmacamp.assesment.dto.respose.TaxResponse;
import com.enigmacamp.assesment.entity.Tax;

public class TaxMapper {
    public static TaxResponse toTaxResponse(Tax tax){
        return TaxResponse.builder()
                .id(tax.getId())
                .name(tax.getName())
                .percentageTax(tax.getPercentageTax())
                .build();
    }
}
