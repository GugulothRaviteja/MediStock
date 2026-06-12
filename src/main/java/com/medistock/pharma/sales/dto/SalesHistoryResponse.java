package com.medistock.pharma.sales.dto;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class SalesHistoryResponse {
    private String transactionId;
    private String medicineName;
    private Integer quantitySold;
    private String customerName;
    private String phoneNumber;
}
