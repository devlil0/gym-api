package br.com.gym.api.controller;

import br.com.gym.api.database.model.PhysicalAssessmentEntity;
import br.com.gym.api.dto.StudentDTO;
import br.com.gym.api.exception.NotFoundException;
import br.com.gym.api.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/assessment/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PhysicalAssessmentEntity findAssessment(@PathVariable Long id) throws NotFoundException {
        return studentService.getStudentAssessment(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody StudentDTO dto) {
        studentService.save(dto);
    }

    @PostMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody StudentDTO dto) {
        studentService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws NotFoundException {
        studentService.deleteStudent(id);
    }
}
