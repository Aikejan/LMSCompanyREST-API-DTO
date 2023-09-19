package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.response.CourseResponse;
import peaksoft.entities.Course;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    @Query("select  new peaksoft.dto.response.CourseResponse(c.id,c.name,c.dataOfStart,c.description) from  Course c")
    List<CourseResponse> getAllCourse();
    Optional <CourseResponse> getCourseById(Long id);
    @Query("select new peaksoft.dto.response.CourseResponse(c.id,c.name,c.dataOfStart,c.description) from Course  c order by  c.dataOfStart")
    List<CourseResponse> findAllSortedByDate();
}
