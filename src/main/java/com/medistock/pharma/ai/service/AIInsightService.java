package com.medistock.pharma.ai.service;



import com.medistock.pharma.ai.dto.AIInsightResponse;
import com.medistock.pharma.medicine.model.Medicine;
import com.medistock.pharma.medicine.repository.MedicineRepository;
import com.medistock.pharma.sales.model.Sale;
import com.medistock.pharma.sales.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AIInsightService {

    private final MedicineRepository medicineRepository;
    private final SaleRepository saleRepository;

    public List<AIInsightResponse> generateInsights() {

        List<Medicine> medicines = medicineRepository.findAll();

        List<AIInsightResponse> insights = new ArrayList<>();

        for (Medicine medicine : medicines) {

            List<Sale> sales =
                    saleRepository.findByMedicineId(
                            medicine.getId()
                    );

            int totalSold = sales.stream()
                    .mapToInt(Sale::getQuantitySold)
                    .sum();

            int estimatedMonthlySales =
                    Math.max(totalSold, 1);

            int runOutDays =
                    (medicine.getQuantity() * 30)
                            / estimatedMonthlySales;

            String recommendation;

            if (runOutDays <= 10) {

                recommendation =
                        "Stock may run out soon. Consider restocking.";
            }

            else if (runOutDays <= 30) {

                recommendation =
                        "Stock level is moderate.";
            }

            else {

                recommendation =
                        "Stock level is sufficient.";
            }

            insights.add(
                    AIInsightResponse.builder()
                            .medicineName(
                                    medicine.getMedicineName()
                            )
                            .currentStock(
                                    medicine.getQuantity()
                            )
                            .estimatedMonthlySales(
                                    estimatedMonthlySales
                            )
                            .estimatedRunOutDays(
                                    runOutDays
                            )
                            .recommendation(
                                    recommendation
                            )
                            .build()
            );
        }

        return insights;
    }
}