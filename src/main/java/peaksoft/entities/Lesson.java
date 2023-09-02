package peaksoft.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "lessons")
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "lesson_gen")
    @SequenceGenerator(name = "lesson_gen",sequenceName ="lesson_seq", allocationSize = 1)

    private  Long id;
    private String lessonName;
}
