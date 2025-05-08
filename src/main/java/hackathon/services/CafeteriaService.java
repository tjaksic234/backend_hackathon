package hackathon.services;

import hackathon.models.dto.CafeteriaDTO;
import hackathon.models.dto.CreateCafeteriaRequest;
import hackathon.models.dto.MenuDTO;

import java.util.List;

public interface CafeteriaService {
    CafeteriaDTO createCafeteria(CreateCafeteriaRequest request);
    List<CafeteriaDTO> getAllCafeterias();
    List<MenuDTO> getMenusForCafeteria(String cafeteriaId);
}
