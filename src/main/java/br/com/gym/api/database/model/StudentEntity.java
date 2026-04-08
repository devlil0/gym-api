
package br.com.gym.api.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student_id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "physical_assessment_id")
    private PhysicalAssessmentEntity physicalAssessment;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<WorkoutEntity> workoutList = new HashSet<>();
}
