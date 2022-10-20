package pl.niepracuj.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.niepracuj.model.dto.CompanyDto;
import pl.niepracuj.model.dto.LogDto;
import pl.niepracuj.service.company.CompanyService;
import pl.niepracuj.service.log.LogService;

import java.io.IOException;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/company/")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    private final LogService logService;

    @GetMapping("all")
    public List<CompanyDto> getCompanies(){
        return companyService.getAllCompanies();
    }
    @PostMapping("create")
    public CompanyDto createCompany(@RequestBody CompanyDto companyDto) throws IOException, InterruptedException {
        var response = companyService.createCompany(companyDto);
        logService.sendLog(LogDto.getLogDto("Dodano nową firmę"));
        return response;
    }
}
