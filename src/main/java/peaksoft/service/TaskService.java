package peaksoft.service;

import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.request.TaskRequest;
import peaksoft.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {

    SimpleResponse saveTask(Long lessonId, TaskRequest taskRequest);
    TaskResponse getById(Long id);
    SimpleResponse updateTask(Long id, TaskRequest taskRequest);

     SimpleResponse deleteById(Long id);

    List<TaskResponse> getAllTasks(Long lessonId);
}
