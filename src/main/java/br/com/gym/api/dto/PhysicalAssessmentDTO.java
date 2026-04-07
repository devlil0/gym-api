package br.com.gym.api.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PhysicalAssessmentDTO {

    @NotNull
    private Long id;

    @NotNull
    private Double weight;

    @NotNull
    private Double height;

    @NotNull
    private Double bodyFatPercentage;


}
