package peaksoft.service;

import peaksoft.dto.response.GroupStudentCountResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.request.GroupRequest;
import peaksoft.dto.response.GroupResponse;
import peaksoft.entities.Course;

import java.util.List;

public interface GroupService{
    List<GroupResponse> getAllGroups();
    SimpleResponse saveGroup(GroupRequest groupRequest);


    GroupResponse getGroupById(Long groupId);

    SimpleResponse updateGroup(Long id, GroupRequest groupRequest);

    SimpleResponse deleteGroupById(Long id);

    SimpleResponse assignGroup(Long courseId, Long groupId);

    SimpleResponse addStudentToGroup(Long groupId, Long studentId);

    GroupStudentCountResponse getStudentCountByGroup(Long groupId);

}
