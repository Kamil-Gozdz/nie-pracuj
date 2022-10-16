package pl.niepracuj.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.niepracuj.model.dto.advertisement.AdvertisementCreateDto;
import pl.niepracuj.model.dto.advertisement.AdvertisementDto;
import pl.niepracuj.model.dto.advertisement.AdvertisementSearchCriteriaDto;
import pl.niepracuj.service.advertisement.AdvertisementService;
import pl.niepracuj.service.log.LogService;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/adv/")
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    private final LogService logService;

    @GetMapping("all")
    public List<AdvertisementDto> getAdvertisements(){
       var response =  advertisementService.getAllAdvertisements();
       //logService.sendLog(LogDto.getLogDto("Pobrano wszystkie ogłoszenia"));
       return response;
    }
    @GetMapping("all/company/{companyId}")
    public List<AdvertisementDto> getAdvertisementsForCompany(@PathVariable Long companyId){
        return advertisementService.getAdvertisementsForCompany(companyId);
    }
    @PostMapping("create")
    public AdvertisementDto createAdvertisement(@RequestBody @Valid AdvertisementCreateDto advertisementCreateDto){
        return advertisementService.createAdvertisement(advertisementCreateDto);
    }
    @PostMapping("search")
    public List<AdvertisementDto> searchAdvertisementByCriteria(@RequestBody AdvertisementSearchCriteriaDto criteriaDto,
                                                                Pageable pageable){
        return advertisementService.getAdvertisementsByCriteria(criteriaDto, pageable);
    }
}
