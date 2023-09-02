package peaksoft.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import peaksoft.entities.Company;
import peaksoft.entities.Group;
import peaksoft.entities.Instructor;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CourseResponse {
    private Long id;
    private String name;
    private ZonedDateTime dataOfStart;
    private String description;
    private Company company;
    private List<Group> groups;
    private List<Instructor> instructors;

    public CourseResponse(ZonedDateTime dataOfStart, String description, Company company, List<Group> groups, List<Instructor> instructors) {
        this.dataOfStart = dataOfStart;
        this.description = description;
        this.company = company;
        this.groups = groups;
        this.instructors = instructors;
    }

    public CourseResponse(Long id, String name, ZonedDateTime dataOfStart, String description) {
    }
}
