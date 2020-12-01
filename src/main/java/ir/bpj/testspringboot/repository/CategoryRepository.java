package ir.bpj.testspringboot.repository;

import ir.bpj.testspringboot.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    @Override
    <S extends CategoryEntity> S saveAndFlush(S entity);

    List<CategoryEntity> findAll();

}
