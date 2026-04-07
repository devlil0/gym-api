package br.com.gym.api.database.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercise_id")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

//this class represents a table in database
public class ExerciseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Column(name = "muscle_group_id")
    private String muscleGroup;

    @NotBlank
    private String equipment;

    @NotBlank
    @Column(name = "difficulty_level_id")
    private String difficultyLevel;

}

