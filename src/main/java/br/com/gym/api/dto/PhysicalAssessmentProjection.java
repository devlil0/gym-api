package br.com.gym.api.dto;

public interface PhysicalAssessmentProjection {

    Long getStudentId();
    String getStudentName();
    Long getAssessmentId();
    Double getWeight();
    Double getHeight();
    Double getBodyFatPercentage();
}
