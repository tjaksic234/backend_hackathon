package hackathon.services.impl;

import hackathon.converters.ConverterService;
import hackathon.exceptions.NotFoundException;
import hackathon.models.dao.Cafeteria;
import hackathon.models.dao.Menu;
import hackathon.models.dto.CafeteriaDTO;
import hackathon.models.dto.CreateCafeteriaRequest;
import hackathon.models.dto.MenuDTO;
import hackathon.repository.CafeteriaRepository;
import hackathon.repository.MenuRepository;
import hackathon.services.CafeteriaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class CafeteriaServiceImpl implements CafeteriaService {

    private final CafeteriaRepository cafeteriaRepository;

    private final MenuRepository menuRepository;

    private final ConverterService converterService;

    @Override
    public CafeteriaDTO createCafeteria(CreateCafeteriaRequest request) {
        Cafeteria cafeteria = new Cafeteria();
        cafeteria.setName(request.getName());
        cafeteria.setWorkingTime(request.getWorkingTime());
        cafeteria.setAddress(request.getAddress());
        cafeteria.setStreetNumber(request.getStreetNumber());
        cafeteria.setCity(request.getCity());

        cafeteriaRepository.save(cafeteria);

        log.info("Successfully created a cafeteria");
        return converterService.convertCafeteriaToCafeteriaDTO(cafeteria);
    }

    @Override
    public List<CafeteriaDTO> getAllCafeterias() {
        List<Cafeteria> cafeterias = cafeteriaRepository.findAll();
        return cafeterias.stream()
                .map(converterService::convertCafeteriaToCafeteriaDTO)
                .toList();
    }

    @Override
    public List<MenuDTO> getMenusForCafeteria(String cafeteriaId) {
        cafeteriaRepository.findById(cafeteriaId)
                .orElseThrow(() -> new NotFoundException("Cafeteria not found"));

        List<Menu> menus = menuRepository.findAllByCafeteriaId(cafeteriaId);

        return menus.stream()
                .map(converterService::convertMenuToMenuDTO)
                .toList();
    }
}
