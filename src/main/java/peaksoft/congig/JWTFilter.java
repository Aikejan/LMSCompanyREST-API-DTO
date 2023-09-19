package peaksoft.congig;
import jakarta.servlet.FilterChain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.servlet.ServletException;import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;import lombok.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import peaksoft.entities.User;
import peaksoft.repo.UserRepository;

import java.io.IOException;
import java.util.NoSuchElementException;



@Component
@RequiredArgsConstructor
public class JWTFilter {
    private final JWTService jwtService;   
    private final UserRepository userRepository;
    


    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {


        String tokenHeader=request.getHeader("Authorization");
        if(tokenHeader!=null && tokenHeader.startsWith("Bearer ")){
            String token=tokenHeader.substring(7);
                try {
                    if(StringUtils.hasText(token)) {
                    String email = jwtService.validateToken(token);
                    User user = userRepository.getUserById(email) .orElseThrow(
                            () -> new NoSuchElementException( "Not exists user with email " + email));
                            SecurityContextHolder.getContext()
                            .setAuthentication(new UsernamePasswordAuthenticationToken(
                            user.getEmail(),(user.getAuthorities())));
                            }
                }catch (JWTVerificationException e){
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Token error");
                }

        filterChain.doFilter(request,response);
        }
}
}
