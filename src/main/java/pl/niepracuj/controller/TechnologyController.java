package pl.niepracuj.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.niepracuj.model.dto.TechnologyDto;
import pl.niepracuj.service.technology.TechnologyService;

import java.util.List;

@RestController
@RequestMapping("/technology/")
@RequiredArgsConstructor
public class TechnologyController {

    private final TechnologyService technologyService;

    @GetMapping("all")
    public List<TechnologyDto> getTechnologies(){
        return technologyService.getAllTechnologies();
    }
    @PostMapping("create")
    public TechnologyDto createTechnology(@RequestBody TechnologyDto technologyDto){
        return technologyService.createTechnology(technologyDto);
    }
}
