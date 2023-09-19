package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dto.response.GroupResponse;
import peaksoft.dto.response.GroupStudentCountResponse;
import peaksoft.entities.Group;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
  Optional<GroupResponse> getGroupById(Long gropId);
    @Query("select  new peaksoft.dto.SimpleResponse GroupRespose(g.groupName,g.imageLink,g.description) from  Group  g")
    List<GroupResponse> getAllGroups();

    GroupStudentCountResponse getStudentCountByGroup(Long groupId);
}
