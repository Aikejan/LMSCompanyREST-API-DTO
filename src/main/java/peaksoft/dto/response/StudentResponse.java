package peaksoft.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import peaksoft.entities.Group;

@Getter
@Setter
@Builder
public class StudentResponse {
    private  Long id;
    private String firstName;
    private  String lastName;
    private  String email;
    private String studyFormat;
    private boolean isBlocked;
    private Group group;


    public StudentResponse(Long id, String firstName, String lastName, String email, String studyFormat, boolean isBlocked, Group group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studyFormat = studyFormat;
        this.isBlocked = isBlocked;
        this.group = group;
    }
}
