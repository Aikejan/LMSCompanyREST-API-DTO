package peaksoft.service;

import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;

import java.util.List;

public interface CourseService {
    CourseResponse saveCourse(Long instructorId, Long companyId, CourseRequest courseRequest);
    List<CourseResponse> getAllCourse();
    CourseResponse getById(Long id);

    SimpleResponse updateCourse(Long id, CourseRequest courseRequest);

    SimpleResponse deleteById(Long id);

    List<CourseResponse> findAllSorted();


}
