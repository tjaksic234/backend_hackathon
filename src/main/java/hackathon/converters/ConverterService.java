package hackathon.converters;

import hackathon.models.dao.User;
import hackathon.models.dto.UserDTO;

public interface ConverterService {
    UserDTO convertUserToUserDTO(User user);
}
