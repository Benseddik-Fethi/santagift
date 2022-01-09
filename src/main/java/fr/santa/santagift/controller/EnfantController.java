package fr.santa.santagift.controller;

import fr.santa.santagift.dto.EnfantDto;
import fr.santa.santagift.service.IEnfantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enfant")
@RequiredArgsConstructor
public class EnfantController {
    private final IEnfantService enfantService;

    @PostMapping("")
    public ResponseEntity<EnfantDto> addEnfant(@RequestBody EnfantDto enfantDto) {
        Optional<EnfantDto> optionalEnfantDto = enfantService.save(enfantDto);
        return optionalEnfantDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnfantDto> getEnfant(@PathVariable Long id) {
        Optional<EnfantDto> optionalEnfantDto = enfantService.findById(id);
        return optionalEnfantDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EnfantDto>> getAllEnfant() {
        return ResponseEntity.ok(enfantService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnfantDto> updateEnfant(@RequestBody EnfantDto enfantDto) {
        Optional<EnfantDto> optionalEnfantDto = enfantService.update(enfantDto);
        return optionalEnfantDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnfant(@PathVariable Long id) {
        enfantService.delete(id);
        return ResponseEntity.ok().build();
    }

}
