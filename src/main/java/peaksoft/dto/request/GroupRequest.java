package peaksoft.dto.request;

import lombok.Getter;
import lombok.Setter;
import peaksoft.entities.Course;

import java.util.List;

@Getter
@Setter
public class GroupRequest {
    private String groupName;
    private String imageLink;
    private String description;
    private List<Course> courses;

}
