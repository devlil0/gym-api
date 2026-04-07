package br.com.gym.api.database.repository;

import br.com.gym.api.database.model.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IExerciseRepository extends JpaRepository<ExerciseEntity, Long> {

    List<ExerciseEntity> findByMuscleGroup(String muscleGroup);

}
