package br.com.gym.api.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class WorkoutDTO {

    private Long id;

    @NotNull
    private Long studentId;

    @NotBlank
    private String name;

    @NotBlank
    private String objective;

    @NotEmpty
    private List<Long> exerciseIds = new ArrayList<>();


}

