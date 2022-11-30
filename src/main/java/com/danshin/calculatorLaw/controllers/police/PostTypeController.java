package com.danshin.calculatorLaw.controllers.police;

import com.danshin.calculatorLaw.models.dto.police.PostTypeDto;
import com.danshin.calculatorLaw.services.interfaces.police.PostTypeService;
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
@RequestMapping("/police/post-types")
public record PostTypeController(PostTypeService postTypeService) {
    @GetMapping
    public ResponseEntity<List<PostTypeDto>> getAll(
            @RequestParam(name = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return ResponseEntity.ok(postTypeService.getAll(DateOptional.orDefault(date)));
    }
}
