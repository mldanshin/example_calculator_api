package com.danshin.calculatorLaw.controllers.police;

import com.danshin.calculatorLaw.models.dto.police.PostDto;
import com.danshin.calculatorLaw.services.interfaces.police.PostService;
import com.danshin.calculatorLaw.util.DateOptional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/police/posts")
public record PostController(PostService service) {
    @GetMapping
    public ResponseEntity<List<PostDto>> getAll(
            @RequestParam(name = "government", required = false) Integer government,
            @RequestParam(name = "type", required = false) Integer type,
            @RequestParam(name = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return ResponseEntity.ok(service.getAll(government, type, DateOptional.orDefault(date)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getById(@PathVariable int id) {
        PostDto dto = service.getById(id);
        if (dto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(dto);
    }
}
