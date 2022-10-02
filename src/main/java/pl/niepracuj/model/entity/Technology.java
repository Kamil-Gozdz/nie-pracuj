package pl.niepracuj.model.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.niepracuj.model.enums.TechnologyEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="technologies")
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TechnologyEnum name;
}
