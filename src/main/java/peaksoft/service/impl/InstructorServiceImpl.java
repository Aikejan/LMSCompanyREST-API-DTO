package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.request.InstructorRequest;
import peaksoft.dto.response.InstructorResponse;
import peaksoft.entities.Company;
import peaksoft.entities.Instructor;
import peaksoft.repo.CompanyRepository;
import peaksoft.repo.InstructorRepository;
import peaksoft.service.InstructorService;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final CompanyRepository companyRepository;


    @Override
    public SimpleResponse saveInstructor(InstructorRequest instructorRequest) {

        try {
            Instructor instructor = new Instructor();
            instructor.setFirstName(instructorRequest.getFirstName());
            instructor.setLastName(instructorRequest.getLastName());
            instructor.setPhoneNumber(instructorRequest.getPhoneNumber());
            instructor.setSpecialization(instructorRequest.getSpecialization());

            instructorRepository.save(instructor);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY SAVED")
                    .message("Instructor with id: " + instructor.getFirstName() + " is saved!")
                    .build();

        } catch (Exception e) {
            return SimpleResponse.builder()
                    .status("ERROR")
                    .message("Failed to save instructor: " + e.getMessage())
                    .build();
        }
    }

    @Override
    public List<InstructorResponse> getAllInstructors() {
//        return instructorRepository.getAllInstructors();
return null;

    }

    @Override
    public InstructorResponse getInstructorById(Long id) {
        try {
            instructorRepository.findById(id).orElseThrow(() ->
                    new NoSuchElementException("Instructor with id: " + id + " is not found!"));

//            return instructorRepository.getInstructorById(id);
return null;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get instructor: " + e.getMessage());

        }
    }

    @Override
    public SimpleResponse updateInstructor(Long id, InstructorRequest instructorRequest) {

        try {
            Instructor instructor = instructorRepository.findById(id).orElseThrow(() ->
                    new NoSuchElementException("Instructor with id: " + id + " is not found!"));

            instructor.setFirstName(instructorRequest.getFirstName());
            instructor.setLastName(instructorRequest.getLastName());
            instructor.setPhoneNumber(instructorRequest.getPhoneNumber());
            instructor.setSpecialization(instructorRequest.getSpecialization());
            instructorRepository.save(instructor);


            return SimpleResponse.builder()
                    .status("SUCCESSFULLY UPDATED")
                    .message("Instructor with id: " + instructor.getFirstName() + " is updated ")
                    .build();
        } catch (Exception e) {
            return SimpleResponse.builder()
                    .status("ERROR")
                    .message("Failed to update instructor: " + e.getMessage())
                    .build();
        }
    }




    @Override
    public SimpleResponse deleteInstructorById(Long id) {
        try {
            instructorRepository.deleteById(id);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY DELETED")
                    .message("Instructor with id: " + id + " is deleted ")
                    .build();

        } catch (Exception e) {
            throw new RuntimeException("Failed to get instructor: " + e.getMessage());

        }





    }

    @Override
    public SimpleResponse assignInstructor(Long companyId, Long instructorId) {
        try {
            Company company = companyRepository.findById(companyId).orElseThrow(() -> new
                    NoSuchElementException("Company with id: " + companyId + "is not found"));


            Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(() -> new
                    NoSuchElementException("Instructor with id:" + instructorId + "is not found"));

            if (instructor.getCompanies() != null) {
                for (Company id : instructor.getCompanies()) {
                    if (id.getId().equals(companyId)) {
                        throw new IOException("This group already exists!");
                    }

                    company.getInstructor().add(instructor);
                    instructor.getCompanies().add(company);
                    instructorRepository.save(instructor);
                    companyRepository.save(company);

                }
            }
        } catch (Exception e) {
            return SimpleResponse.builder()
                    .status("ERROR")
                    .message("Failed to assign instructor: " + e.getMessage())
                    .build();

        }

        return SimpleResponse.builder().status("SUCCESSFULLY ASSIGN").
                message("COMPANY WITH ID: " + instructorId + "SUCCESSFULLY ASSIGN"
                ).build();

    }
}







