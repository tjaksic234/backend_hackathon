package hackathon.security.utils;

import hackathon.models.dto.UserInfo;
import hackathon.security.services.impl.UserDetailsImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

@AllArgsConstructor
@Slf4j
@Configuration
public class Helper {

    public static UserInfo extractUserInfoFromEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalStateException("Invalid email format");
        }

        String localPart = email.split("@")[0];
        String[] nameParts = localPart.split("\\.");

        String firstName = nameParts.length > 0 ? StringUtils.capitalize(nameParts[0]) : "";
        String lastName = nameParts.length > 1 ? StringUtils.capitalize(nameParts[1]) : "";

        return new UserInfo(firstName, lastName);
    }

    public static String getLoggedInUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null && authentication.getPrincipal() instanceof UserDetailsImpl) {
            return ((UserDetailsImpl) authentication.getPrincipal()).getId();
        }
        throw new IllegalStateException("Error: Security Context is not authenticated");
    }
}
