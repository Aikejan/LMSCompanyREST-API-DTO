package peaksoft.dto.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import peaksoft.enums.Role;
@Getter
@Setter
@Builder
public class UserResponse {
    Long id;
    String firstName;
    String lastName;
    String email;
    String password;
     Role role;

    public UserResponse(Long id, String firstName, String lastName, String email, String password, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
