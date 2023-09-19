package peaksoft.service;


import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.AuthenticationResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponse;

import java.security.Principal;

public interface UserService {
    void init();
    AuthenticationResponse signIn(UserRequest signInRequest);

    UserResponse update(Principal principal, Long userId, UserRequest userRequest);

    SimpleResponse signUp(UserRequest userRequest);
}
