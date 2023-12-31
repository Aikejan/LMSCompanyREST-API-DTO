package peaksoft.dto.request;

import lombok.Getter;
import lombok.Setter;
import peaksoft.entities.Company;
import peaksoft.entities.Group;
import peaksoft.entities.Instructor;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
public class CourseRequest {
    private String name;
    private ZonedDateTime dataOfStart;
    private String description;
    private Company company;
    private List<Group> groups;
    private List<Instructor> instructors;

    public CourseRequest(String name, ZonedDateTime dataOfStart, String description, Company company, List<Group> groups) {
        this.name = name;
        this.dataOfStart = dataOfStart;
        this.description = description;
        this.company = company;
        this.groups = groups;
    }
}
