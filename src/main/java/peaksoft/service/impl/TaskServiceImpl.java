package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.request.TaskRequest;
import peaksoft.dto.response.TaskResponse;
import peaksoft.entities.Lesson;
import peaksoft.entities.Task;
import peaksoft.repo.LessonRepository;
import peaksoft.repo.TaskRepository;
import peaksoft.service.TaskService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final LessonRepository lessonRepository;


    @Override
    public SimpleResponse saveTask(Long lessonId, TaskRequest taskRequest) {

        try {
            Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(() ->
                    new NoSuchElementException("Lesson with id: " + lessonId + "  is not found!"));

            Task task = new Task();
            task.setTaskName(taskRequest.getTaskName());
            task.setTaskText(taskRequest.getTaskText());
            task.setDeadLine(taskRequest.getDeadLine());
            lesson.setLessonName(taskRequest.getTaskName());
            task.setTaskName("JS");

            taskRepository.save(task);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY SAVED")
                    .message("Task with id: " + task.getTaskName() + " is saved!")
                    .build();

        } catch (Exception e) {
            return SimpleResponse.builder()
                    .status("ERROR")
                    .message("Failed to save task: " + e.getMessage())
                    .build();
        }
    }

    @Override
    public TaskResponse getById(Long id) {
        try {
            return taskRepository.getTaskById(id).orElseThrow(() ->
                    new NoSuchElementException("Task with id: " + id + " is not found!"));

        } catch (Exception e) {
            throw new RuntimeException("Failed to get lesson: " + e.getMessage());

        }

    }

    @Override
    public SimpleResponse updateTask(Long id, TaskRequest taskRequest) {
        try {
            Task task = taskRepository.findById(id).orElseThrow(() ->
                    new NoSuchElementException("Task with id: " + id + " is not found!"));
            task.setTaskName(taskRequest.getTaskName());
            task.setTaskText(taskRequest.getTaskText());
            task.setDeadLine(taskRequest.getDeadLine());
            taskRepository.save(task);

            return SimpleResponse.builder()
                    .status("SUCCESSFULLY UPDATE")
                    .message("Task with id: " + task.getTaskName() + " is updated!")
                    .build();

        } catch (Exception e) {
            return SimpleResponse.builder()
                    .status("ERROR")
                    .message("Failed to update task: " + e.getMessage())
                    .build();
        }


    }

    @Override
    public SimpleResponse deleteById(Long id) {

        return taskRepository.getTaskById();
    }

    @Override
    public List<TaskResponse> getAllTasks(Long lessonId) {

        return taskRepository.getAllTasks(lessonId);
    }

}


