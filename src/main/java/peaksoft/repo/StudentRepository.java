package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.response.StudentResponse;
import peaksoft.entities.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("select new peaksoft.dto.SimpleResponse(s.id,s.firstName,s.lastName,s.email,s.studyFormat,s.isBlocked) from  Student  s where  s.group.id=:groupId")
    List<StudentResponse> getAllStudents(Long groupId);

    Optional<Object> getStudentById(Long id);
}
