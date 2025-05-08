package hackathon.services;

import hackathon.models.dto.CafeteriaDTO;
import hackathon.models.dto.CreateCafeteriaRequest;

public interface CafeteriaService {
    CafeteriaDTO createCafeteria(CreateCafeteriaRequest request);
}
