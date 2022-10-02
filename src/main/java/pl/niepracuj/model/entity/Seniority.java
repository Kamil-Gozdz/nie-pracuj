package pl.niepracuj.model.entity;


import lombok.*;
import pl.niepracuj.model.enums.SeniorityEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "seniorities")
@Builder
@AllArgsConstructor
public class Seniority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SeniorityEnum name;
}
