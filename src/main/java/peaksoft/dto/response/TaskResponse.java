package peaksoft.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TaskResponse {
    private  Long id;
    private String taskName;
    private String taskText;
    private LocalDateTime deadLine;

    public TaskResponse( String taskName, String taskText, LocalDateTime deadLine) {
        this.taskName = taskName;
        this.taskText = taskText;
        this.deadLine = deadLine;
    }
}
