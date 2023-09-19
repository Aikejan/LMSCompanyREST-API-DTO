package peaksoft.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import peaksoft.enums.Role;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class SignInRequest {
   private String email;
   private String password;
   private Role role;
}
