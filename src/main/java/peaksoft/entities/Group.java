package peaksoft.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groups")
@NoArgsConstructor
@AllArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "group_gen")
    @SequenceGenerator(name = "group_gen", sequenceName = "group_seq", allocationSize = 1)

    private Long id;
    private String groupName;
    private String imageLink;
    private String description;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "groups")
    private List<Course> courses;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Group(String groupName, String imageLink, String description, List<Course> courses, Group group) {
        this.groupName = groupName;
        this.imageLink = imageLink;
        this.description = description;
        this.courses = courses;
        this.group = group;
    }
}
