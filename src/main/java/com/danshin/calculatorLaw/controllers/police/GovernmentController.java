package com.danshin.calculatorLaw.controllers.police;

import com.danshin.calculatorLaw.models.dto.police.GovernmentDto;
import com.danshin.calculatorLaw.services.interfaces.police.GovernmentService;
import com.danshin.calculatorLaw.util.DateOptional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/police/governments")
public record GovernmentController(GovernmentService governmentService) {
    @GetMapping
    public ResponseEntity<List<GovernmentDto>> getAll(
            @RequestParam(name = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return ResponseEntity.ok(governmentService.getAll(DateOptional.orDefault(date)));
    }
}
