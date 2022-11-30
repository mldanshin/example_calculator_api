package com.danshin.calculatorLaw.controllers.police;

import com.danshin.calculatorLaw.models.dto.police.RankDto;
import com.danshin.calculatorLaw.services.interfaces.police.RankService;
import com.danshin.calculatorLaw.util.DateOptional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/police/ranks")
public record RankController(RankService service) {
    @GetMapping
    public ResponseEntity<List<RankDto>> getAll(
            @RequestParam(name = "post_type", required = false) Integer postType,
            @RequestParam(name = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return ResponseEntity.ok(service.getAll(postType, DateOptional.orDefault(date)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RankDto> getById(@PathVariable int id) {
        RankDto dto = service.getById(id);

        if (dto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(dto);
    }
}
