package peaksoft.dto.request;

import lombok.Getter;
import lombok.Setter;
import peaksoft.entities.Company;
import peaksoft.entities.Course;

import java.util.List;

@Getter
@Setter
public class InstructorRequest {
    private  String firstName;
    private String lastName;
    private  String phoneNumber;
    private String specialization;
    private List<Company> companies;
    private List<Course> courses;

    public InstructorRequest(String firstName, String lastName, String phoneNumber, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
    }
}
