package hackathon.security.services.impl;

import hackathon.converters.ConverterService;
import hackathon.exceptions.BadRequestException;
import hackathon.exceptions.NotFoundException;
import hackathon.models.dao.User;
import hackathon.models.dto.LoginRequest;
import hackathon.models.dto.LoginResponse;
import hackathon.models.dto.RegisterUserRequest;
import hackathon.models.dto.UserDTO;
import hackathon.models.enums.RoleType;
import hackathon.repository.UserRepository;
import hackathon.security.services.AuthService;
import hackathon.security.utils.JwtUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ConverterService converterService;

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    @Override
    public UserDTO register(RegisterUserRequest request) {
        if (userRepository.existsByEmail(request.getEmail()) || request.getEmail() == null) {
            throw new BadRequestException("Email is already taken or it is not in the correct format");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(List.of(RoleType.STUDENT));

        userRepository.save(user);

        log.info("Registered a user with id: {} successfully", user.getId());
        return converterService.convertUserToUserDTO(user);
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new NotFoundException("Error: User not found"));


        LoginResponse response = new LoginResponse();

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.generateJwtToken(authentication);

        response.setAccessToken(accessToken);

        log.info("Successful login with: [{}]", user.getId());
        return response;
    }

    @Override
    public boolean hasRole(RoleType... requiredRoles) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof UserDetailsImpl) {
            String userId = ((UserDetailsImpl) authentication.getPrincipal()).getId();
            User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("Error: User not found"));

            List<RoleType> roles = user.getRoles();

            for (RoleType requiredRole : requiredRoles) {
                if (roles.contains(requiredRole)) {
                    return true;
                }
            }
        }
        return false;
    }
}
