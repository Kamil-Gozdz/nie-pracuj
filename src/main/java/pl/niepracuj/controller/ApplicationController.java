package pl.niepracuj.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.niepracuj.model.dto.ApplicationCreateDto;
import pl.niepracuj.model.dto.ApplicationDto;
import pl.niepracuj.service.application.ApplicationService;

import java.io.IOException;

@RestController
@RequestMapping("/application/")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("create")
    public ApplicationDto createApplication(ApplicationCreateDto createDto) throws IOException {
        return applicationService.createApplication(createDto);
    }

}
