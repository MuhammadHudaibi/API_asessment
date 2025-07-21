package com.enigmacamp.assesment.dto.respose;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaxResponse {
    private String id;
    private String name;
    private BigDecimal percentageTax;
}
