package peaksoft.service.impl;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityExistsException;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.congig.JWTService;
import peaksoft.dto.request.SignInRequest;
import peaksoft.dto.request.SignUpRequest;
import peaksoft.dto.response.AuthenticationResponse;
import peaksoft.entities.User;
import peaksoft.enums.Role;
import peaksoft.exception.BadCredentialException;
import peaksoft.exception.NotFoundException;
import peaksoft.repo.UserRepository;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
@Builder
public class AuthenticationServiceImpl {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService  jwtService;

    @Override
    public AuthenticationResponse signUp(SignUpRequest signUpRequest) {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new EntityExistsException("BUl EMAIDAGY USER: " + signUpRequest.getEmail() + "bar");
        }
        User user = User.builder()
                .firstname(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        String token = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(token)
                .email(user.getEmail())
                .role(user.getRole())
                .build();


    }

    @Override
    public AuthenticationResponse signIn(SignInRequest signInRequest) {
        User user = userRepository.getUserByEmail(signInRequest.getEmail()).orElseThrow(() ->
                new NotFoundException("User with email:" + signInRequest.getEmail()));
        if (signInRequest.getEmail().isBlank()) {
            throw new BadCredentialException("Email isBlank");
        }
        if (!passwordEncoder.matches(signInRequest.getPassword(), user.getPassword())) {
            throw new BadCredentialException("Wrong PASSWORD");
        }
        String token = jwtService.generateToken(user);
        return AuthenticationResponse.bilder()
                .token(token)
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    @PostConstruct
    @Override
    public void init() {
        User admin = new User();
        admin.setFirstName("Admin");
        admin.setLastName("Adminova");
        admin.setEmail("admin@gmail.com");
        admin.setRole(Role.ADMIN );
        admin.setPassword(passwordEncoder.encode("admin00"));
        if (!userRepository.existsByEmail("admin@gmail.com")){
            userRepository.save(admin);
        }

    }
}
