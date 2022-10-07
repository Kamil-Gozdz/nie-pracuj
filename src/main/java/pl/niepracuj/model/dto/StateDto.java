package pl.niepracuj.model.dto;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StateDto {

    private Long id;

    private String name;
}
