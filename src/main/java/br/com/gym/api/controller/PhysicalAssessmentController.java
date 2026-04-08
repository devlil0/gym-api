package br.com.gym.api.controller;

import br.com.gym.api.database.model.PhysicalAssessmentEntity;
import br.com.gym.api.dto.PhysicalAssessmentDTO;
import br.com.gym.api.dto.PhysicalAssessmentProjection;
import br.com.gym.api.service.PhysicalAssessmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/physical")
@RequiredArgsConstructor
public class PhysicalAssessmentController {

    private final PhysicalAssessmentService physicalAssessmentService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PhysicalAssessmentEntity> findAll() {
        return physicalAssessmentService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody PhysicalAssessmentDTO dto) throws BadRequestException {
        physicalAssessmentService.save(dto);
    }

    @GetMapping("/group/percentage/{bodyFatPercentage}")
    @ResponseStatus(HttpStatus.OK)
    public List<PhysicalAssessmentEntity> findByBodyFatPercentage(@PathVariable Double bodyFatPercentage) {
        return physicalAssessmentService.findByBodyFatPercentage(bodyFatPercentage);
    }

    @GetMapping("/group/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PhysicalAssessmentEntity findById(@PathVariable Long id) {
        return physicalAssessmentService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PhysicalAssessmentEntity update(@PathVariable Long id, @RequestBody PhysicalAssessmentDTO dto) {
        return physicalAssessmentService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        physicalAssessmentService.delete(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<PhysicalAssessmentProjection> getAllAssessment() {
        return physicalAssessmentService.getAllAssessment();
    }
}
