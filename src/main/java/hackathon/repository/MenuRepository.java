package hackathon.repository;

import hackathon.models.dao.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends MongoRepository<Menu, String> {
    List<Menu> findAllByCafeteriaId(String cafeteriaId);
}
