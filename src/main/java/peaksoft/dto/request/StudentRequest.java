package peaksoft.dto.request;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import peaksoft.valdation.PhoneNumberValidation;

@Getter
@Setter
public class StudentRequest {
    private String firstName;
    private  String lastName;
    @PhoneNumberValidation
    private  String phoneNumber;
    @Email
    private  String email;
    private String studyFormat;
    private boolean isBlocked;


}
