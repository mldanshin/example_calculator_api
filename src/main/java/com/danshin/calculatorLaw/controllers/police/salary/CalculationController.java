package com.danshin.calculatorLaw.controllers.police.salary;

import com.danshin.calculatorLaw.exceptions.BadRequestException;
import com.danshin.calculatorLaw.models.dto.police.salary.calculation.CalculationDto;
import com.danshin.calculatorLaw.requests.police.salary.CalculationRequestDto;
import com.danshin.calculatorLaw.services.interfaces.police.salary.CalculationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/police/salary/calculation")
public record CalculationController(CalculationService service) {
    @PostMapping

    public ResponseEntity<CalculationDto> getCalculation(@Valid @RequestBody CalculationRequestDto request) {
        try {
            return ResponseEntity.ok(service.getCalculation(request));
        } catch (BadRequestException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
