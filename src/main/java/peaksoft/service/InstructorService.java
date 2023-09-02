package peaksoft.service;

import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.InstructorRequest;
import peaksoft.dto.response.InstructorResponse;

import java.util.List;

public interface InstructorService {
    SimpleResponse saveInstructor(InstructorRequest instructorRequest);
    List<InstructorResponse> getAllInstructors();

    InstructorResponse getInstructorById(Long id);

    SimpleResponse updateInstructor(Long id, InstructorRequest instructorRequest);

    SimpleResponse deleteInstructorById(Long id);

    SimpleResponse assignInstructor(Long companyId, Long instructorId);

}
