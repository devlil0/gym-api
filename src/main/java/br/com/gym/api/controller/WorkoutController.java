package br.com.gym.api.controller;

import br.com.gym.api.dto.WorkoutDTO;
import br.com.gym.api.exception.NotFoundException;
import br.com.gym.api.service.WorkoutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/workout")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutService workoutService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody WorkoutDTO dto) throws NotFoundException, BadRequestException {
        workoutService.save(dto);
    }
}
