package peaksoft.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import peaksoft.entities.Course;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class GroupResponse {
    private Long id;
    private String groupName;
    private String imageLink;
    private String description;
    private List<Course> courses;

    public GroupResponse(String groupName, String imageLink, String description, List<Course> courses) {
        this.groupName = groupName;
        this.imageLink = imageLink;
        this.description = description;
        this.courses = courses;
    }
}
