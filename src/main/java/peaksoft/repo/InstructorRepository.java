package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.response.InstructorResponse;
import peaksoft.entities.Instructor;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long> {
    @Query("select new peaksoft.dto.SimpleResponse(i.firstName,i.lastName,i.phoneNumber,i.specialization) from Instructor i")
    List<InstructorResponse> getAllInstructors();
    @Query("select new peaksoft.dto.SimpleResponse(i.id,i.firstName,i.lastName,i.phoneNumber,i.specialization) from Instructor  i")
    InstructorResponse getInstructorById(Long id);
}
