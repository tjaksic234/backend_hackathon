package hackathon.repository;

import hackathon.models.dao.Cafeteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeteriaRepository extends MongoRepository<Cafeteria, String> {
}
