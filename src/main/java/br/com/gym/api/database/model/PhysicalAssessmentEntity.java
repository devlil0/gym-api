
package br.com.gym.api.database.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "physical_assessment_id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PhysicalAssessmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private Double weight;
    private Double height;
    private Double bodyFatPercentage;
}
