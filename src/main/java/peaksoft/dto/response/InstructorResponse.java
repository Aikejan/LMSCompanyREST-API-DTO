package peaksoft.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import peaksoft.entities.Company;
import peaksoft.entities.Course;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class InstructorResponse {
    private  Long id;
    private  String firstName;
    private String lastName;
    private  String phoneNumber;
    private List<Company> companies;
    private List<Course> courses;


    public InstructorResponse(String firstName, String lastName, String phoneNumber, List<Company> companies, List<Course> courses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.companies = companies;
        this.courses = courses;
    }
}
