package com.medistock.pharma.sales.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SellMedicineRequest {

    @Min(1)
    private Integer quantitySold;

    @NotBlank
    private String customerName;

    @NotBlank
    @Pattern(
            regexp = "^[0-9]{10}$",
            message = "Phone number must contains exactly 10 digits"
    )
    private String phoneNumber;
}