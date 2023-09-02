package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;
import peaksoft.entities.Company;
import peaksoft.entities.Course;
import peaksoft.entities.Instructor;
import peaksoft.repo.CompanyRepository;
import peaksoft.repo.CourseRepository;
import peaksoft.repo.InstructorRepository;
import peaksoft.service.CourseService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private  final CourseRepository courseRepository;
    private  final CompanyRepository companyRepository;
    private final InstructorRepository instructorRepository;


    @Override
    public CourseResponse saveCourse(Long instructorId, Long companyId, CourseRequest courseRequest) {

        try {
            Company company = companyRepository.findById(companyId).orElseThrow(() ->
                    new NoSuchElementException("Company with id: " + companyId + " is not found!"));

            Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(() ->
                    new NoSuchElementException("Instructor with id: " + instructorId + " is not found!"));

            Course course = new Course();
            course.setName(courseRequest.getName());
            course.setDataOfStart(courseRequest.getDataOfStart());
            course.setDescription(courseRequest.getDescription());
            List<Course>courses=new ArrayList<>();
            courses.add(course);
            company.setCourses(courses);
            course.setCompanies(company);
            instructor.getCourses().add(course);
            course.setInstructors(instructor);

            courseRepository.save(course);

            return new CourseResponse(course.getId(),
                    course.getName(), course.getDataOfStart(), course.getDescription());

        } catch (Exception e) {
            throw new RuntimeException("Failed to save course: " + e.getMessage());
        }



    }

    @Override
    public List<CourseResponse> getAllCourse() {
        return  courseRepository.getAllCourse();

    }



    @Override
    public CourseResponse getById(Long id) {
        try {
            return courseRepository.getCourseById(id).orElseThrow(() ->
                    new NoSuchElementException("Course with id: " + id + " is not found!"));
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve course: " + e.getMessage());
        }



    }


    @Override
    public SimpleResponse updateCourse(Long id, CourseRequest courseRequest) { try {
        Course course = courseRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Course with id: " + id + " is not found!"));

        course.setName(courseRequest.getName());
        course.setDataOfStart(courseRequest.getDataOfStart());
        course.setDescription(courseRequest.getDescription());
        courseRepository.save(course);

        return SimpleResponse.builder()
                .status("SUCCESSFULLY UPDATE!")
                .message("Course with id: " + course.getName() + " is updated!")
                .build();

    } catch (Exception e) {
        return SimpleResponse.builder()
                .status("ERROR")
                .message("Failed to update course: " + e.getMessage())
                .build();
    }




    }

    @Override
    public SimpleResponse deleteById(Long id) {
        try {
            courseRepository.deleteById(id);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY DELETED!")
                    .message("Course with id: " + id + " is deleted!")
                    .build();

        } catch (Exception e) {
            throw new RuntimeException("Failed to delete company: " + e.getMessage());
        }
    }



    @Override
    public List<CourseResponse> findAllSorted() {

        try {
            return courseRepository.findAllSortedByDate();

        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve sorted courses: " + e.getMessage());
        }
    }
    }



