package pl.niepracuj.model.entity;


import lombok.*;
import pl.niepracuj.model.enums.TechnologyEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="technologies")
@Builder
@AllArgsConstructor
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TechnologyEnum name;
}
