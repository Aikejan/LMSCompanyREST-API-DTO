package peaksoft.service;

import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.StudentRequest;
import peaksoft.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {
    List<StudentResponse> getAllStudents(Long groupId);
    SimpleResponse saveStudent(Long groupId, StudentRequest studentRequest);
    StudentResponse getById(Long id);
    SimpleResponse updateStudent(Long id, StudentRequest studentRequest);
    SimpleResponse deleteById(Long id);
    SimpleResponse createGroups(String groupName,List<Long> courseId);

    SimpleResponse blockUnblockStudent(Long studentId, Boolean block);
    List<StudentResponse> filter(String studyFormat);
}
