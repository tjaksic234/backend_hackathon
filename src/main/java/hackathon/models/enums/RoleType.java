package hackathon.models.enums;

import lombok.Getter;

@Getter
public enum RoleType {
    STUDENT("STUDENT"),
    PROFESSOR("PROFESSOR"),
    CAFETERIA_EMPLOYEE("CAFETERIA_EMPLOYEE"),
    ADMIN("ADMIN");

    private final String value;

    RoleType(String value) {
        this.value = value;
    }
}
