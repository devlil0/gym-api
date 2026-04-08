package br.com.gym.api.database.repository;

import br.com.gym.api.database.model.WorkoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IWorkoutRepository extends JpaRepository<WorkoutEntity, Long> {

    Optional<WorkoutEntity> findByNameAndStudentId(String name, Long studentId);

    List<WorkoutEntity> findByName(String name);

    List<WorkoutEntity> findAllByStudentId(Long studentId);

    @Modifying
    @Query("DELETE FROM WorkoutEntity w WHERE w.student.id = :studentId")
    void deleteByStudentId(Long studentId);
}
