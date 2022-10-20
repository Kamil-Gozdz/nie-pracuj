package pl.niepracuj.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.niepracuj.model.dto.advertisement.AdvertisementCreateDto;
import pl.niepracuj.model.dto.advertisement.AdvertisementDto;
import pl.niepracuj.model.dto.advertisement.AdvertisementSearchCriteriaDto;
import pl.niepracuj.service.advertisement.AdvertisementService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/adv/")
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;


    @GetMapping("all")
    public List<AdvertisementDto> getAdvertisements() {
        return advertisementService.getAllAdvertisements();
    }

    @GetMapping("all/company/{companyId}")
    public List<AdvertisementDto> getAdvertisementsForCompany(@PathVariable Long companyId) {
        return advertisementService.getAdvertisementsForCompany(companyId);
    }

    @PostMapping("create")
    public AdvertisementDto createAdvertisement(@RequestBody @Valid AdvertisementCreateDto advertisementCreateDto) {
        return advertisementService.createAdvertisement(advertisementCreateDto);
    }

    @PostMapping("search")
    public List<AdvertisementDto> searchAdvertisementByCriteria(@RequestBody AdvertisementSearchCriteriaDto criteriaDto,
                                                                Pageable pageable) {
        return advertisementService.getAdvertisementsByCriteria(criteriaDto, pageable);
    }

    @DeleteMapping("delete/{id}")
    public void deleteAdvertisementById(@PathVariable Long id) {
        advertisementService.deleteAdvertisementById(id);
    }
}
