package br.com.gym.api.service;

import br.com.gym.api.database.model.PhysicalAssessmentEntity;
import br.com.gym.api.database.model.StudentEntity;
import br.com.gym.api.database.model.WorkoutEntity;
import br.com.gym.api.database.repository.IPhysicalAssessmentRepository;
import br.com.gym.api.database.repository.IStudentRepository;
import br.com.gym.api.database.repository.IWorkoutExerciseRepository;
import br.com.gym.api.database.repository.IWorkoutRepository;
import br.com.gym.api.dto.StudentDTO;
import br.com.gym.api.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class StudentService {

    private final IStudentRepository studentRepository;
    private final IPhysicalAssessmentRepository assessmentRepository;
    private final IWorkoutRepository workoutRepository;
    private final IWorkoutExerciseRepository workoutExerciseRepository;

    public void save(StudentDTO dto) {
        studentRepository.save(StudentEntity.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build());
    }

    public StudentEntity findByEmail(String email) throws NotFoundException {
        return studentRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("NOT FOUND"));
    }

    public StudentEntity findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NOT FOUND"));
    }

    public StudentEntity update(StudentDTO dto, Long id) {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NOT FOUND"));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        return studentRepository.save(student);
    }

    public PhysicalAssessmentEntity getStudentAssessment(Long id) throws NotFoundException {
        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("STUDENT NOT FOUND"));

        PhysicalAssessmentEntity assessment = student.getPhysicalAssessment();

        if (assessment == null) {
            throw new NotFoundException("STUDENT DOES NOT HAVE A PHYSICAL ASSESSMENT");
        }

        return assessment;
    }

    @Transactional
    public void deleteStudent(Long id) {

        StudentEntity student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("STUDENT NOT FOUND"));

        // remove relacionamentos primeiro
        if (student.getWorkoutList() != null) {
            workoutRepository.deleteAll(student.getWorkoutList());
        }

        // remove assessment se existir
        if (student.getPhysicalAssessment() != null) {
            assessmentRepository.delete(student.getPhysicalAssessment());
        }

        // 🔥 AGORA SIM remove o student
        studentRepository.delete(student);
    }
}
