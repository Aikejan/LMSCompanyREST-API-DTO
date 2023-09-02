package peaksoft.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tasks")
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "task_gen")
    @SequenceGenerator(name = "task_gen",sequenceName ="task_seq", allocationSize = 1)
    private  Long id;
    private String taskName;
    private String taskText;
    private LocalDateTime deadLine;
}
