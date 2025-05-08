package hackathon.services;

import hackathon.models.dto.CreateFoodRequest;
import hackathon.models.dto.FoodDTO;

public interface FoodService {
    FoodDTO createFood(CreateFoodRequest request);
}
