package pl.niepracuj.model.dto;

import lombok.*;
import pl.niepracuj.model.entity.State;

import javax.persistence.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CityDto {

    private Long id;

    private String name;

    private StateDto state;
}
