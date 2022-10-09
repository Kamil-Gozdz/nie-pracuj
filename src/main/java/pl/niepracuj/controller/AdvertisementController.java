package pl.niepracuj.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.niepracuj.model.dto.advertisement.AdvertisementCreateDto;
import pl.niepracuj.model.dto.advertisement.AdvertisementDto;
import pl.niepracuj.model.dto.advertisement.AdvertisementSearchCriteriaDto;
import pl.niepracuj.service.advertisement.AdvertisementService;

import java.util.List;

@RestController
@RequestMapping("/adv/")
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @GetMapping("all")
    public List<AdvertisementDto> getCompanies(){
        return advertisementService.getAllAdvertisements();
    }
    @PostMapping("create")
    public AdvertisementDto createAdvertisement(@RequestBody AdvertisementCreateDto advertisementCreateDto){
        return advertisementService.createAdvertisement(advertisementCreateDto);
    }
    @PostMapping("search")
    public List<AdvertisementDto> searchAdvertisementByCriteria(@RequestBody AdvertisementSearchCriteriaDto criteriaDto,
                                                                Pageable pageable){
        return advertisementService.getAdvertisementsByCriteria(criteriaDto, pageable);
    }
}
