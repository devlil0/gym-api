package br.com.gym.api.database.repository;

import br.com.gym.api.database.model.WorkoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWorkoutExerciseRepository extends JpaRepository<WorkoutEntity, Long> {

    @Modifying
    @Query(value = "DELETE FROM workout_exercise WHERE workout_id IN (:ids)", nativeQuery = true)
    void deleteByWorkoutIds(List<Long> ids);
}
