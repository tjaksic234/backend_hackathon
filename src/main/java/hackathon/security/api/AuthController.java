package hackathon.security.api;

import hackathon.models.dto.LoginRequest;
import hackathon.models.dto.LoginResponse;
import hackathon.models.dto.RegisterUserRequest;
import hackathon.models.dto.UserDTO;
import hackathon.security.services.AuthService;
import hackathon.security.utils.JwtUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static hackathon.security.utils.Constants.API_ROUTE;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(API_ROUTE + "/auth")
public class AuthController {

    private final AuthService authService;

    private final JwtUtils jwtUtils;

    @PostMapping("register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody RegisterUserRequest request) {
        log.info("Attempting to register a user");
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest request) {
        log.info("Attempting to login");
        LoginResponse response = authService.login(request);
        ResponseCookie cookie = jwtUtils.createJwtCookie(response.getAccessToken());
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body(response);
    }
}
