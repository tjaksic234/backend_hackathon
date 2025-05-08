package hackathon.converters.impl;

import hackathon.converters.ConverterService;
import hackathon.models.dao.Cafeteria;
import hackathon.models.dao.Food;
import hackathon.models.dao.Menu;
import hackathon.models.dao.User;
import hackathon.models.dto.CafeteriaDTO;
import hackathon.models.dto.FoodDTO;
import hackathon.models.dto.MenuDTO;
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

    @Override
    public MenuDTO convertMenuToMenuDTO(Menu menu) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setCafeteriaId(menu.getCafeteriaId());
        menuDTO.setName(menu.getName());
        menuDTO.setMenuType(menu.getMenuType());
        menuDTO.setDate(menu.getDate());
        menuDTO.setFoodIds(menu.getFoodIds());
        return menuDTO;
    }

    @Override
    public CafeteriaDTO convertCafeteriaToCafeteriaDTO(Cafeteria cafe) {
        CafeteriaDTO cafeteriaDTO = new CafeteriaDTO();
        cafeteriaDTO.setCafeteriaId(cafe.getId());
        cafeteriaDTO.setName(cafe.getName());
        cafeteriaDTO.setWorkingTime(cafe.getWorkingTime());
        cafeteriaDTO.setAddress(cafe.getAddress());
        cafeteriaDTO.setStreetNumber(cafe.getStreetNumber());
        cafeteriaDTO.setCity(cafe.getCity());
        return cafeteriaDTO;
    }
}
