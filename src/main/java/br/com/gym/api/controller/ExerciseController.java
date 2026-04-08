package br.com.gym.api.controller;

import br.com.gym.api.database.model.ExerciseEntity;
import br.com.gym.api.dto.ExerciseDTO;
import br.com.gym.api.service.ExerciseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/exercises")
@RequiredArgsConstructor
public class ExerciseController {

    private final ExerciseService exerciseService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciseEntity> findAll() {
        return exerciseService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody ExerciseDTO dto) {
        exerciseService.save(dto);
    }

    @GetMapping("/group/{muscleGroup}")
    @ResponseStatus(HttpStatus.OK)
    public List<ExerciseEntity> findByMuscleGroup(@PathVariable String muscleGroup) {
        return exerciseService.findByMuscleGroup(muscleGroup);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ExerciseEntity findById(@PathVariable Long id) {
        return exerciseService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ExerciseEntity update(@PathVariable Long id, @RequestBody ExerciseDTO dto) {
        return exerciseService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        exerciseService.delete(id);
    }
}
