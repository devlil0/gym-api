package br.com.gym.api.service;

import br.com.gym.api.database.model.PhysicalAssessmentEntity;
import br.com.gym.api.database.model.StudentEntity;
import br.com.gym.api.database.repository.IPhysicalAssessmentRepository;
import br.com.gym.api.database.repository.IStudentRepository;
import br.com.gym.api.dto.PhysicalAssessmentDTO;
import br.com.gym.api.dto.PhysicalAssessmentProjection;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class PhysicalAssessmentService {

    private final IPhysicalAssessmentRepository physicalAssessmentRepository;
    private final IStudentRepository studentRepository;

    public List<PhysicalAssessmentEntity> findAll(){
        return physicalAssessmentRepository.findAll();
    }

    public void save(PhysicalAssessmentDTO dto) throws BadRequestException {

        StudentEntity student = studentRepository.findById(dto.getId()).orElseThrow(() -> new BadRequestException("STUDENT NOT FOUND"));

        if(student.getPhysicalAssessment() != null){
            throw new BadRequestException("STUDENT ALREADY HAS A PHYSICAL ASSESSMENT");
        }

        PhysicalAssessmentEntity assessment = PhysicalAssessmentEntity.builder()
                .weight(dto.getWeight())
                .height(dto.getHeight())
                .bodyFatPercentage(dto.getBodyFatPercentage())
                .build();

        student.setPhysicalAssessment(assessment);
        studentRepository.save(student);

    }


    public List<PhysicalAssessmentEntity> findByBodyFatPercentage(Double bodyFatPercentage){

        return physicalAssessmentRepository.findByBodyFatPercentage(bodyFatPercentage);
    }

    public PhysicalAssessmentEntity findById(Long id){

        return physicalAssessmentRepository.findById(id).orElseThrow(() -> new RuntimeException("NOT FOUND"));
    }

    public void delete(Long id){

        PhysicalAssessmentEntity physicalAssessment = physicalAssessmentRepository.findById(id).orElseThrow(() -> new RuntimeException("NOT FOUND"));
        physicalAssessmentRepository.delete(physicalAssessment);
    }

    public PhysicalAssessmentEntity update(PhysicalAssessmentDTO dto, Long id){

        PhysicalAssessmentEntity physicalAssessment = physicalAssessmentRepository.findById(id).orElseThrow(() -> new RuntimeException("NOT FOUND"));

        physicalAssessment.setWeight(dto.getWeight());
        physicalAssessment.setHeight(dto.getHeight());

        return physicalAssessmentRepository.save(physicalAssessment);
    }

    public List<PhysicalAssessmentProjection> getAllAssessment(){
        return physicalAssessmentRepository.getAllAssessment();
    }


}
