package com.medistock.pharma.ai.controller;
import com.medistock.pharma.ai.dto.AIInsightResponse;
import com.medistock.pharma.ai.service.AIInsightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AIInsightController {

    private final AIInsightService aiInsightService;

    @GetMapping("/insights")
    public List<AIInsightResponse> getInsights() {

        return aiInsightService.generateInsights();
    }
}
