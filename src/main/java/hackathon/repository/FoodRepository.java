package hackathon.repository;

import hackathon.models.dao.Food;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food, String> {
    Food findFoodById(String id);
}
