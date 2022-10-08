package pl.niepracuj.model.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "advertisements")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime publishDate;

    private LocalDateTime expireDate;

    private Long salaryFrom;

    private Long salaryTo;

    private String description;

    @ManyToOne
    private Technology technology;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Seniority seniority;

    @ManyToOne
    private City city;

    @ManyToMany
    @JoinTable(
            name = "adv_skills",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "adv_id")
    )
    private Set<Skill> skills;
}
