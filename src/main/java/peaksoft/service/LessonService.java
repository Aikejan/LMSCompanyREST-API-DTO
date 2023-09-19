package peaksoft.service;

import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.request.LessonRequest;
import peaksoft.dto.response.LessonResponse;

import java.util.List;

public interface LessonService {
  List<LessonResponse> getAllLessons(Long courseId);
 SimpleResponse saveLesson(Long courseId, LessonRequest lessonRequest);
  LessonResponse getById(Long id);
  SimpleResponse updateLesson(Long id, LessonRequest lessonRequest);
  SimpleResponse deleteById(Long id);
  SimpleResponse upLoadLessonToCourse( String LessonName,Long courseId);

}
