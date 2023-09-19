package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.query.NotIndexedCollectionException;
import org.springframework.stereotype.Service;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.request.LessonRequest;
import peaksoft.dto.response.LessonResponse;
import peaksoft.entities.Course;
import peaksoft.entities.Lesson;
import peaksoft.exception.NotFoundException;
import peaksoft.repo.CourseRepository;
import peaksoft.repo.LessonRepository;
import peaksoft.service.LessonService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;


    @Override
    public List<LessonResponse> getAllLessons(Long courseId) {
        return lessonRepository.getAllInstructors();
    }

    @Override
    public SimpleResponse saveLesson(Long courseId, LessonRequest lessonRequest) {
        try {
            Course course = courseRepository.findById(courseId).orElseThrow(() ->
                    new NoSuchElementException("Course with id: " + courseId + " is not found!"));

            Lesson lesson = new Lesson();
            lesson.setLessonName(lessonRequest.lessonName());
            List<Lesson> courses = new ArrayList();
            List<Course> lessons = new ArrayList();
            courses.add(lesson);
            lessons.add(course);

            lessonRepository.save(lesson);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY SAVED")
                    .message("Lesson with id: " + lesson.getLessonName() + " is saved")
                    .build();

        } catch (Exception e) {
            return SimpleResponse.builder()
                    .status("ERROR")
                    .message("Failed to save lesson: " + e.getMessage())
                    .build();
        }

    }

    @Override
    public LessonResponse getById(Long id) {
        try {
//        Lesson lessonResponse =  lessonRepository.getLessonById(id).orElseThrow(() ->
//                    new  NoSuchElementException("Lesson with id: " + id + " is not found!"));
            lessonRepository.findById(id).orElseThrow(() ->
                    new NotFoundException("Lesson with id:" + id));
        } catch (Exception e) {
            throw new RuntimeException("Failed to get lesson: " + e.getMessage());

        }
        return  new LessonResponse();
    }

    @Override
    public SimpleResponse updateLesson(Long id, LessonRequest lessonRequest) {

        try {
            Lesson lesson = lessonRepository.findById(id).orElseThrow(() ->
                    new NotIndexedCollectionException("Lesson with id: " + id + " is not found!"));

            lesson.setLessonName(lessonRequest.lessonName());
            lessonRepository.save(lesson);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY UPDATE")
                    .message("Lesson with id: " + lesson.getLessonName() + " is updated")
                    .build();

        } catch (Exception e) {
            return SimpleResponse.builder()
                    .status("ERROR")
                    .message("Failed to update lesson: " + e.getMessage())
                    .build();
        }


    }

    @Override
    public SimpleResponse deleteById(Long id) {
        try {
            lessonRepository.deleteById(id);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY DELETE")
                    .message("Lesson with id: " + id + " is deleted")
                    .build();

        } catch (Exception e) {
            throw new RuntimeException("Failed to get lesson: " + e.getMessage());

        }
    }


    @Override
    public SimpleResponse upLoadLessonToCourse(String LessonName, Long courseId) {
        try {
            Course course = courseRepository.findById(courseId).orElseThrow(() ->
                    new NoSuchElementException("Course with id: " + courseId + " is not found!"));

            Lesson lesson = new Lesson();
            lesson.setLessonName(lesson.getLessonName());
            List<Course> lesson1 = new ArrayList<>();
            lesson1.add(course);
            lessonRepository.save(lesson);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY LOADED")
                    .message("Lesson with id: " + LessonName + " is loaded")
                    .build();

        } catch (Exception e) {
            return SimpleResponse.builder()
                    .status("ERROR")
                    .message("Failed to upload lesson: " + e.getMessage())
                    .build();
        }
    }

}
