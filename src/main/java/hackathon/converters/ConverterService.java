package hackathon.converters;

import hackathon.models.dao.Food;
import hackathon.models.dao.Menu;
import hackathon.models.dao.User;
import hackathon.models.dto.FoodDTO;
import hackathon.models.dto.MenuDTO;
import hackathon.models.dto.UserDTO;

public interface ConverterService {
    UserDTO convertUserToUserDTO(User user);
    FoodDTO convertFoodToFoodDTO(Food food);
    MenuDTO convertMenuToMenuDTO(Menu menu);
}
