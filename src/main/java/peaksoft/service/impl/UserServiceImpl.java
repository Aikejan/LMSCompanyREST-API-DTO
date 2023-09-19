package peaksoft.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.UserRequest;
import peaksoft.dto.response.AuthenticationResponse;
import peaksoft.dto.response.SimpleResponse;
import peaksoft.dto.response.UserResponse;
import peaksoft.entities.User;
import peaksoft.enums.Role;
import peaksoft.repo.UserRepository;
import peaksoft.service.UserService;
import java.security.Principal;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService {

    private final PasswordEncoder passwordEncoder;
    private  final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @PostConstruct
    @Override
    public void init() {
        User user = new User();
        user.setRole(Role.ADMIN);
        user.setFirstName("Admin");
        user.setLastName("Admin");
        user.setEmail("admin@gmail.com");
        user.setPassword(passwordEncoder.encode("admin"));
        if (!userRepository.exsistByEmail("admin@gmail.com")) {
            userRepository.save(user);
        }
    }



    @Override
    public AuthenticationResponse signIn(UserRequest signInRequest) {
        return null;
    }

    @Override
    public UserResponse update(Principal principal, Long userId, UserRequest userRequest) {
        return null;
    }

    @Override
    public SimpleResponse signUp(UserRequest userRequest) {
        return null;
    }
}
