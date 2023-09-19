package peaksoft.dto.request;

import lombok.Getter;
import lombok.Setter;
import peaksoft.enums.Role;
@Getter
@Setter
public class UserRequest {
   private String firstName;
  private String  lastName;
   private String email;
  private String password;
  private Role role;
}
