package com.danshin.calculatorLaw.controllers.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.BonusAnnualDto;
import com.danshin.calculatorLaw.services.interfaces.police.salary.BonusAnnualService;
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
@RequestMapping("/police/salary/bonus-annuals")
public record BonusAnnualController(BonusAnnualService service) {
    @GetMapping
    public ResponseEntity<List<BonusAnnualDto>> getAll(
            @RequestParam(name = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return ResponseEntity.ok(service.getAll(DateOptional.orDefault(date)));
    }

    @GetMapping("/id")
    public ResponseEntity<List<BonusAnnualDto>> getById(
            @RequestParam(name = "id", required = false) List<Integer> id
    ) {
        return ResponseEntity.ok(service.getById(id));
    }
}
