package peaksoft.service;

import org.apache.coyote.Response;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;

import java.util.List;

public interface CourseService {

    List<CourseResponse> getAllCourse();

    CourseResponse getById(Long id);

    SimpleResponse updateCourse(Long id, CourseRequest courseRequest);

    SimpleResponse deleteById(Long id);

    List<CourseResponse> findAllSorted();


    SimpleResponse saveCourseToCompany(Long companyId, CourseRequest courseRequest);
}
