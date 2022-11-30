package com.danshin.calculatorLaw.controllers.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.LawDto;
import com.danshin.calculatorLaw.services.interfaces.police.salary.LawService;
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
@RequestMapping("/police/salary/laws")
public record LawController(LawService lawService) {
    @GetMapping
    public ResponseEntity<List<LawDto>> getAll(
            @RequestParam(name = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return ResponseEntity.ok(lawService.getAll(DateOptional.orDefault(date)));
    }
}
