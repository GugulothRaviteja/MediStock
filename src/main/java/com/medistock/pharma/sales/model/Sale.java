package com.medistock.pharma.sales.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sale {

    @Id
    private String id;

    private String transactionId;

    private String medicineId;

    private String medicineName;

    private String customerName;

    private  String phoneNumber;

    private Integer quantitySold;

    private Double totalPrice;

    private LocalDateTime soldAt;
}