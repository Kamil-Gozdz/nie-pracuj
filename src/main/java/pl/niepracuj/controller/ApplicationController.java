package pl.niepracuj.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.niepracuj.model.dto.ApplicationCreateDto;
import pl.niepracuj.model.dto.ApplicationDto;
import pl.niepracuj.service.application.ApplicationService;

import java.io.IOException;
@CrossOrigin
@RestController
@RequestMapping("/application/")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("create")
    public ApplicationDto createApplication(ApplicationCreateDto createDto) throws IOException {
        return applicationService.createApplication(createDto);
    }
    @DeleteMapping("delete/{id}")
    public void deleteAdvertisementById(@PathVariable Long id) {
        applicationService.deleteApplicationById(id);
    }
}
