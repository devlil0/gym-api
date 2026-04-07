package br.com.gym.api.database.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student_id")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

//this class represents a table in database
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Column(unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "physical_assessment_id")
    private PhysicalAssessmentEntity physicalAssessment;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<WorkoutEntity> workoutList = new HashSet<>();

}

