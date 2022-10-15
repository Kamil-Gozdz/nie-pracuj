package pl.niepracuj.service.advertisement;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import pl.niepracuj.model.advertisement.AdvertisementSearchCriteriaDto;
import pl.niepracuj.model.entity.Advertisement;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import static java.util.Objects.nonNull;

@RequiredArgsConstructor
public class AdvertisementSpecification implements Specification<Advertisement> {

    private final AdvertisementSearchCriteriaDto criteriaDto;

    @Override
    public Predicate toPredicate(Root<Advertisement> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.and(advertisementNameLike(root, criteriaBuilder),
                seniorityNameEquals(root, criteriaBuilder),
                cityLike(root, criteriaBuilder),
                technologyNameEquals(root, criteriaBuilder),
                salaryFromLessThanOrEqualTo(root, criteriaBuilder),
                salaryToLessThanOrEqualTo(root, criteriaBuilder));
    }

    private Predicate advertisementNameLike(Root<Advertisement> root,CriteriaBuilder criteriaBuilder) {
        return nonNull(criteriaDto.getName()) ?
                criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
                        "%" + criteriaDto.getName().toLowerCase() + "%") :
                alwaysTruePredicate(criteriaBuilder);
    }

    private Predicate seniorityNameEquals(Root<Advertisement> root,CriteriaBuilder criteriaBuilder) {
        return nonNull(criteriaDto.getSeniorityName()) ?
                criteriaBuilder.equal(root.get("seniority").get("name"),
                         criteriaDto.getSeniorityName()) :
                alwaysTruePredicate(criteriaBuilder);
    }
    private Predicate cityLike(Root<Advertisement> root, CriteriaBuilder criteriaBuilder) {
        return nonNull(criteriaDto.getCityName()) ?
                criteriaBuilder.like(criteriaBuilder.lower(root.get("city").get("name")),
                        "%" + criteriaDto.getCityName().toLowerCase() + "%") :
                alwaysTruePredicate(criteriaBuilder);
    }
    private Predicate technologyNameEquals(Root<Advertisement> root,CriteriaBuilder criteriaBuilder) {
        return nonNull(criteriaDto.getTechnologyName()) ?
                criteriaBuilder.equal(root.get("technology").get("name"),
                        criteriaDto.getTechnologyName()) :
                alwaysTruePredicate(criteriaBuilder);
    }
    private Predicate salaryFromLessThanOrEqualTo(Root<Advertisement> root, CriteriaBuilder criteriaBuilder){
        return nonNull(criteriaDto.getSalaryTo()) ?
                criteriaBuilder.lessThanOrEqualTo(root.get("salaryFrom"),criteriaDto.getSalaryTo())
                : alwaysTruePredicate(criteriaBuilder);
    }
    private Predicate salaryToLessThanOrEqualTo(Root<Advertisement> root,CriteriaBuilder criteriaBuilder){
        return nonNull(criteriaDto.getSalaryFrom()) ?
                criteriaBuilder.greaterThanOrEqualTo(root.get("salaryTo"),criteriaDto.getSalaryFrom())
                : alwaysTruePredicate(criteriaBuilder);
    }

    private Predicate alwaysTruePredicate(CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
    }
}
