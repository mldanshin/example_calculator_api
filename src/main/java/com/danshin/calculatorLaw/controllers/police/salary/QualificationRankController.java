package com.danshin.calculatorLaw.controllers.police.salary;

import com.danshin.calculatorLaw.models.dto.police.salary.QualificationRankDto;
import com.danshin.calculatorLaw.services.interfaces.police.salary.QualificationRankService;
import com.danshin.calculatorLaw.util.DateOptional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/police/salary/qualification-ranks")
public record QualificationRankController(QualificationRankService service) {
    @GetMapping
    public ResponseEntity<List<QualificationRankDto>> getAll(
            @RequestParam(name = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return ResponseEntity.ok(service.getAll(DateOptional.orDefault(date)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QualificationRankDto> getById(@PathVariable int id) {
        QualificationRankDto dto = service.getById(id);
        if (dto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(dto);
    }
}
