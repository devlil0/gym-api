package br.com.gym.api.service;

import br.com.gym.api.database.model.ExerciseEntity;
import br.com.gym.api.database.model.StudentEntity;
import br.com.gym.api.database.model.WorkoutEntity;
import br.com.gym.api.database.repository.IExerciseRepository;
import br.com.gym.api.database.repository.IStudentRepository;
import br.com.gym.api.database.repository.IWorkoutRepository;
import br.com.gym.api.dto.WorkoutDTO;
import br.com.gym.api.exception.NotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Data
@RequiredArgsConstructor
public class WorkoutService {

    private final IWorkoutRepository workoutRepository;
    private final IExerciseRepository exerciseRepository;
    private final IStudentRepository studentRepository;


    //im using DTO for security
    public void save(WorkoutDTO dto) throws NotFoundException, BadRequestException {
        Set<ExerciseEntity> exerciseSet = new HashSet<>();
        StudentEntity student = studentRepository.findById(dto.getStudentId()).orElseThrow(() -> new NotFoundException("STUDENT NOT FOUND"));

        WorkoutEntity workout = workoutRepository.findByNameAndStudentId(dto.getName(), dto.getStudentId()).orElse(null);
        if (workout != null){
            throw new BadRequestException("ALREADY EXIST AN WORKOUT WITH THIS NAME");
        }

        for(Long exerciseId : dto.getExerciseIds()){
            ExerciseEntity exercise = exerciseRepository.findById(exerciseId).orElseThrow(() -> new BadRequestException(String.format("EXERCISE %s NOT FOUND", exerciseId)));

            exerciseSet.add(exercise);
        }

        workoutRepository.save(WorkoutEntity.builder()
                .name(dto.getName())
                .objective(dto.getObjective())
                .student(student)
                .workoutExerciseList(exerciseSet).build());
    }
}
