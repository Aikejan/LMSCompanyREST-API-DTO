package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.response.GroupResponse;
import peaksoft.entities.Course;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Course,Long> {
    @Query("select  new peaksoft.dto.SimpleResponse GroupRespose(g.groupName,g.imageLink,g.description) from  Group  g")
    List<GroupResponse> getAllGroups();
    @Query("select new peaksoft.dto.SimpleResponse GroupResponse(g.id,g.groupName,g.imageLink,g.description) from Group g where g.id=:id")
   GroupResponse getGroupById(Long groupId);
    @Query("select new peaksoft.dto.SimpleResponse GroupStudentCountResponse(g.id, count (s)) from Group  g join g.students s where g.id=:groupId")
    GroupStudentCountResponse getStudentCountByGroup(Long groupId);
}
