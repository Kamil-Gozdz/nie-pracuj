package pl.niepracuj.model.mapper;


import org.springframework.stereotype.Component;
import pl.niepracuj.model.dto.CompanyDto;
import pl.niepracuj.model.entity.Company;

@Component
public class CompanyMapper {

   public  CompanyDto toDto(Company company){
        return CompanyDto.builder()
                .id(company.getId())
                .email(company.getEmail())
                .address(company.getAddress())
                .size(company.getSize())
                .name(company.getName())
                .build();
    }
    public Company toNewEntity(CompanyDto companyDto){
        return  Company.builder()
                .email(companyDto.getEmail())
                .address(companyDto.getAddress())
                .size(companyDto.getSize())
                .name(companyDto.getName())
                .build();
    }
}
