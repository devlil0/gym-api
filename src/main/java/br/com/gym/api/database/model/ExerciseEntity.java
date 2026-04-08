
package br.com.gym.api.database.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exercise_id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ExerciseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String name;
    private String muscleGroup;
    private String equipment;
    private String difficultyLevel;
}
