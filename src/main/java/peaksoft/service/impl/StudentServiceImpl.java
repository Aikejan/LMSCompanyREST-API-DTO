package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.StudentRequest;
import peaksoft.dto.response.StudentResponse;
import peaksoft.entities.Course;
import peaksoft.entities.Group;
import peaksoft.entities.Student;
import peaksoft.repo.CourseRepository;
import peaksoft.repo.GroupRepository;
import peaksoft.repo.StudentRepository;
import peaksoft.service.StudentService;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private  final StudentRepository studentRepository;
    private  final GroupRepository groupRepository;
    private final CourseRepository courseRepository;

    @Override
    public List<StudentResponse> getAllStudents(Long groupId) {
        return studentRepository.getAllStudents(groupId);
    }

    @Override
    public SimpleResponse saveStudent(Long groupId, StudentRequest studentRequest) {

        try {
            Group group = groupRepository.findById(groupId).orElseThrow(() ->
                    new NoSuchElementException("Group with id: " + groupId + " is not found!"));
            Student student = new Student();
            student.setFirstName(studentRequest.getFirstName());
            student.setLastName(studentRequest.getLastName());
            student.setPhoneNumber(studentRequest.getPhoneNumber);
            student.setEmail(studentRequest.email());
            student.setStudyFormat(studentRequest.getStudyFormat());
            group.addStudent(student);
            student.setGroup(group);

            studentRepository.save(student);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY SAVED")
                    .message("Student with id: " + student.getFirstName() + " is saved")
                    .build();

        } catch (Exception e) {
            return SimpleResponse.builder()
                    .status("ERROR")
                    .message("Failed to save student: " + e.getMessage())
                    .build();
        }
        }

    @Override
    public StudentResponse getById(Long id) {
        try {
            return studentRepository.getStudentById(id).orElseThrow(() ->
                    new NoSuchElementException("Student with id: " + id + " is not found!"));

        } catch (Exception e) {
            throw new RuntimeException("Failed to get student: " + e.getMessage());

        }
    }

    @Override
    public SimpleResponse updateStudent(Long id, StudentRequest studentRequest) {
        try {
            Student student = studentRepository.findById(id).orElseThrow(() ->
                    new NoSuchElementException("Student with id: " + id + " is not found!"));

            student.setFirstName(studentRequest.getFirstName());
            student.setLastName(studentRequest.getLastName());
            student.setPhoneNumber(studentRequest.getPhoneNumber);
            student.setEmail(studentRequest.getEmail());
            student.setStudyFormat(studentRequest.getStudyFormat());
            studentRepository.save(student);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY UPDATE")
                    .message("Student with id: " + student.getFirstName() + " is updated")
                    .build();

        } catch (Exception e) {
            return SimpleResponse.builder()
                    .status("ERROR")
                    .message("Failed to update student: " + e.getMessage())
                    .build();
        }
    }

    @Override
    public SimpleResponse deleteById(Long id) {

        try {
            studentRepository.deleteById(id);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY DELETE")
                    .message("Student with id: " + id + " is deleted")
                    .build();

        } catch (Exception e) {
            throw new RuntimeException("Failed to get student: " + e.getMessage());

        }

    }

    @Override
    public SimpleResponse createGroups(String groupName, List<Long> courseId) {
        try {
            List<Course> courses = courseRepository.findAllById(courseId);
            Group group = new Group();
            group.setGroupName(groupName);
            group.setCourses(courses);
            groupRepository.save(group);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY CREATED")
                    .message("Group with id: " + group.getGroupName() + " is created")
                    .build();

        } catch (Exception e) {
            return SimpleResponse.builder()
                    .status("ERROR")
                    .message("Failed to created student: " + e.getMessage())
                    .build();

        }
    }

    @Override
    public SimpleResponse blockUnblockStudent(Long studentId, Boolean block) {
        return null;
    }

    @Override
    public List<StudentResponse> filter(String studyFormat) {
        try {
            Student student = new Student();
            if (studyFormat.equals("ONLINE")) {
                return studentRepository.getFilterOnLine();

            } else if (studyFormat.equals("OFFLINE")) {
                return studentRepository.getFilterOffLine();

            }
            return Collections.singletonList(StudentResponse.builder().
                    id(student.getId())
                    .firstName(student.getFirstName())
                    .lastName(student.getLastName())
                    .email(student.getEmail())
                    .phoneNumber(student.getPhoneNumber())
                    .isBlocked(student.getIsBlocked())
                    .studyFormat(student.getStudyFormat())
                    .build());

        } catch (Exception e) {
            throw new RuntimeException("Failed to filter student: " + e.getMessage());

        }
    }
    }

