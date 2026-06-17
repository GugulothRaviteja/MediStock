/*
package com.medistock.pharma.ai.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AIInsightResponse {

    private String medicineName;

    private Integer currentStock;

    private Integer estimatedMonthlySales;

    private Integer estimatedRunOutDays;

    private String recommendation;
}*/
package com.medistock.pharma.ai.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AIInsightResponse {

    private String medicineName;

    private Integer currentStock;

    private Integer salesQuantity;

    private Double price;

    private String expiryDate;

    private String category;

    private String recommendation;
}