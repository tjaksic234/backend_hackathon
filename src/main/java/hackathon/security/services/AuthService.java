package hackathon.security.services;

import hackathon.models.dto.LoginRequest;
import hackathon.models.dto.LoginResponse;
import hackathon.models.dto.RegisterUserRequest;
import hackathon.models.dto.UserDTO;
import hackathon.models.enums.RoleType;

public interface AuthService {
    UserDTO register(RegisterUserRequest request);
    LoginResponse login(LoginRequest request);
    boolean hasRole(RoleType... requiredRoles);
    UserDTO fetchMe();
}
