package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.response.LessonResponse;
import peaksoft.entities.Lesson;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson,Long> {


    Optional<LessonResponse> getLessonById(Long id);
    @Query("select new peaksoft.dto.response.LessonResponse(l.id,l.lessonName) from Lesson l where l..id=:courseId")
    List<LessonResponse> getAllInstructors();
}
