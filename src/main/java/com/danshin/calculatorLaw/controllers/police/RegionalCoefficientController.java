package com.danshin.calculatorLaw.controllers.police;

import com.danshin.calculatorLaw.models.dto.police.RegionalCoefficientDto;
import com.danshin.calculatorLaw.services.interfaces.police.RegionalCoefficientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/police/regional-coefficients")
public record RegionalCoefficientController(RegionalCoefficientService service) {
    @GetMapping
    public ResponseEntity<RegionalCoefficientDto> get() {
        return ResponseEntity.ok(service.get());
    }
}
