package br.com.gym.api.service;

import br.com.gym.api.database.model.ExerciseEntity;
import br.com.gym.api.database.model.StudentEntity;
import br.com.gym.api.database.repository.IExerciseRepository;
import br.com.gym.api.dto.ExerciseDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class ExerciseService {

    //I know two ways to turn this into a bean:
    // using @Autowired (a bit outdated) and using @RequiredArgsConstructor, keeping my attribute as final.

    private final IExerciseRepository exerciseRepository;

    public List<ExerciseEntity> findAll(){
        return exerciseRepository.findAll();
    }

    //im using DTO for security
    public void save(ExerciseDTO dto){

        exerciseRepository.save(ExerciseEntity.builder()
                .name(dto.getName())
                .equipment(dto.getEquipment())
                .muscleGroup(dto.getMuscleGroup())
                .difficultyLevel(dto.getDifficultyLevel())
                .build());
    }

    public List<ExerciseEntity> findByMuscleGroup(String muscleGroup){
        return exerciseRepository.findByMuscleGroup(muscleGroup);
    }

    public ExerciseEntity findById(Long id){
        return exerciseRepository.findById(id).orElseThrow(() -> new RuntimeException("NOT FOUND"));
    }

    public void delete(Long id){
        ExerciseEntity exercise = exerciseRepository.findById(id).orElseThrow(() -> new RuntimeException("NOT FOUND"));
        exerciseRepository.delete(exercise);
    }

    public ExerciseEntity update(ExerciseDTO dto, Long id){
        ExerciseEntity exercise = exerciseRepository.findById(id).orElseThrow(() -> new RuntimeException("NOT FOUND"));
        exercise.setName(dto.getName());
        exercise.setEquipment(dto.getEquipment());
        exercise.setDifficultyLevel(dto.getDifficultyLevel());
        exercise.setMuscleGroup(dto.getMuscleGroup());

        return exerciseRepository.save(exercise);
    }

}
