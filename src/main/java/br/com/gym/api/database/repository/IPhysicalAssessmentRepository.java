package br.com.gym.api.database.repository;

import br.com.gym.api.database.model.PhysicalAssessmentEntity;
import br.com.gym.api.dto.PhysicalAssessmentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPhysicalAssessmentRepository extends JpaRepository<PhysicalAssessmentEntity, Long> {

    List<PhysicalAssessmentEntity> findByBodyFatPercentage(Double bodyFatPercentage);

    @Query(value = """
    SELECT 
        s.id AS studentId,
        s.name AS studentName,
        pa.id AS assessmentId,
        pa.weight AS weight,
        pa.height AS height,
        pa.body_fat_percentage_id AS bodyFatPercentage
    FROM student_id s
    LEFT JOIN physical_assessment_id pa 
        ON s.physical_assessment_id = pa.id
""", nativeQuery = true)

    List<PhysicalAssessmentProjection> getAllAssessment();

}
