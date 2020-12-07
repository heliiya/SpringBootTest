package specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface Specification<T> extends org.springframework.data.jpa.domain.Specification<T> {
    @Override
    Predicate toPredicate(Root<T> root, javax.persistence.criteria.CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder);
}
