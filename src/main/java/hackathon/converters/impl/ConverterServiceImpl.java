package hackathon.converters.impl;

import hackathon.converters.ConverterService;
import hackathon.models.dao.Food;
import hackathon.models.dao.User;
import hackathon.models.dto.FoodDTO;
import hackathon.models.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ConverterServiceImpl implements ConverterService {

    @Override
    public UserDTO convertUserToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setRoles(user.getRoles());
        return userDTO;
    }

    @Override
    public FoodDTO convertFoodToFoodDTO(Food food) {
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setId(food.getId());
        foodDTO.setName(food.getName());
        foodDTO.setFoodType(food.getFoodType());
        foodDTO.setAllergies(food.getAllergies());
        return foodDTO;
    }
}
