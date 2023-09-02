package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.request.GroupRequest;
import peaksoft.dto.response.GroupResponse;
import peaksoft.entities.Course;
import peaksoft.entities.Group;
import peaksoft.entities.Student;
import peaksoft.repo.CourseRepository;
import peaksoft.repo.GroupRepository;
import peaksoft.repo.StudentRepository;
import peaksoft.service.GroupService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private  final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Override
    public List<GroupResponse> getAllGroups() {
        return groupRepository.getAllGroups();
    }

    @Override
    public SimpleResponse saveGroup(GroupRequest groupRequest) {

        try {
            Group group = new Group();
            group.setGroupName(groupRequest.getGroupName());
            group.setImageLink(groupRequest.getImageLink());
            group.setDescription(groupRequest.getImageLink());
            groupRepository.save(group);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY SAVED")
                    .message("Group with id: " + group.getGroupName() + " is saved!")
                    .build();

        } catch (Exception e) {
            return SimpleResponse.builder()
                    .status("ERROR")
                    .message("Failed to save group: " + e.getMessage())
                    .build();
        }
    }

    @Override
    public GroupResponse getGroupById(Long gropId) {
        groupRepository.findById(gropId).orElseThrow(() ->
                new NoSuchElementException("Group with id: " + gropId+ " is not found"));

        return groupRepository.getGroupById(gropId);
    }


    @Override
    public SimpleResponse updateGroup(Long id, GroupRequest groupRequest) {

        try {
            Group group = groupRepository.findById(id).orElseThrow(() ->
                    new NoSuchElementException("Group with id: " + id + " is not found!")));

            group.setGroupName(groupRequest.getGroupName());
            group.setImageLink(groupRequest.getImageLink());
            group.setDescription(groupRequest.getDescription());
            groupRepository.save(group);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY UPDATED")
                    .message("Group with id: " + group.getGroupName() + " is updated ")
                    .build();

        } catch (Exception e) {
            return SimpleResponse.builder()
                    .status("ERROR")
                    .message("Failed to update group: " + e.getMessage())
                    .build();
        }
    }

    @Override
    public SimpleResponse deleteGroupById(Long id) {

        try {
            groupRepository.deleteById(id);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY DELETED")
                    .message("Group with id: " + id + " is deleted ")
                    .build();

        } catch (Exception e) {
            throw new RuntimeException("Failed to delete group: " + e.getMessage());
        }
    }
    @Override
    public Course assignGroup(Long courseId, Long groupId) {
        Optional<Course> courseOptional= courseRepository.findById(courseId);
        Optional<Group> groupOptional = groupRepository.findById(groupId);

        if (courseOptional.isPresent() && groupOptional.isPresent()){
            Course course = courseOptional.get();
            Group group = groupOptional.get();

            if (!course.getGroups().contains(group)){
                course.getGroups().add(group);
                return courseRepository.save(course);
            }
        }



//        try {
//            Group group = groupRepository.findById(groupId).orElseThrow(() ->
//                    new NoSuchElementException("Group with id: " + groupId + " is not found!"));
//
//
//            Course course = courseRepository.findById(courseId).orElseThrow(() ->
//                    new NoSuchElementException("Course with id: " + courseId + " is not found!"));
//
//            if (course.getGroups() != null) {
//                for (Group courseGroup : course.getGroups()) {
//                    if (courseGroup.getId().equals(groupId)) {
//                        throw new IOException("This group already exists!");
//                    }
//                }
//                group.getCourses().add(course);
//                course.getGroups().add(group);
//                courseRepository.save(course);
//            }
//            return SimpleResponse.builder()
//                    .status("SUCCESSFULLY ASSIGN")
//                    .message("Group with id : " + groupId + "  " + "Course with id: " + courseId + " successfully assign")
//                    .build();
//
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to assign group: " + e.getMessage());
//
//        }
        return null;
    }

    @Override
    public SimpleResponse addStudentToGroup(Long groupId, Long studentId) {

        try {
            Course group = groupRepository.findById(groupId).orElseThrow(() ->
                    new NoSuchElementException("Group with id: " + groupId + " is not found!"));

            Student student = studentRepository.findById(studentId).orElseThrow(() ->
                    new NoSuchElementException("Student with id: " + studentId + " is not found!"));

            if (student. != null && student.getGroup().equals(group.getId())) {
                throw new IllegalArgumentException("The student is already a member of this group!");
            }

            student.setGroup.add(group);
            group.getGroups().add(student);
            studentRepository.save(student);
            groupRepository.save(group);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY JOINED")
                    .message("Group with id : " + group.getId() + "  " + "Student with id: " + student.getId() + " successfully joined")
                    .build();

        } catch (Exception e) {
            throw new RuntimeException("Failed to add joined: " + e.getMessage());

        }
    }

    @Override
    public GroupStudentCountResponse getStudentCountByGroup(Long groupId) {

        try {
            return groupRepository.getStudentCountByGroup(groupId);

        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve student count for group: " + groupId + ". " + e.getMessage());
        }

    }
}
