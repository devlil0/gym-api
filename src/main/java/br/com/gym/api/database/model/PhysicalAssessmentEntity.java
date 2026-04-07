package br.com.gym.api.database.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "physical_assessment_id")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

//this class represents a table in database
public class PhysicalAssessmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double weight;

    @NotNull
    private Double height;

    @NotNull
    @Column(name = "body_fat_percentage_id")
    private Double bodyFatPercentage;

}
