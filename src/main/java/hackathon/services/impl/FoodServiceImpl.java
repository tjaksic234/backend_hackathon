package hackathon.services.impl;

import hackathon.converters.ConverterService;
import hackathon.models.dao.Food;
import hackathon.models.dto.CreateFoodRequest;
import hackathon.models.dto.FoodDTO;
import hackathon.repository.FoodRepository;
import hackathon.services.FoodService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    private final ConverterService converterService;

    @Override
    public FoodDTO createFood(CreateFoodRequest request) {
        Food food = new Food();
        food.setName(request.getName());
        food.setFoodType(request.getFoodType());
        food.setAllergies(request.getAllergies());

        foodRepository.save(food);

        log.info("Successfully created food entry");
        return converterService.convertFoodToFoodDTO(food);
    }
}
