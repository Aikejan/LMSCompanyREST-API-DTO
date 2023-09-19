package peaksoft.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import peaksoft.entities.Group;
import peaksoft.valdation.PhoneNumberValidation;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class StudentResponse {
    private  Long id;
    private String firstName;
    private  String lastName;
    private String phoneNumber;
    private  String email;
    private String studyFormat;
    private boolean isBlocked;
    private Group group;


    public StudentResponse(Long id, String firstName, String lastName, String phoneNumber, String email, String studyFormat, boolean isBlocked, Group group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.studyFormat = studyFormat;
        this.isBlocked = isBlocked;
        this.group = group;
    }
}
