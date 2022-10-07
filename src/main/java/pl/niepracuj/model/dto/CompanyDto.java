package pl.niepracuj.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CompanyDto {

    private Long id;

    private String name;

    private String address;

    private String email;

    private Integer size;

}
