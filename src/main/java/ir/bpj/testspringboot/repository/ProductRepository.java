package ir.bpj.testspringboot.repository;

import ir.bpj.testspringboot.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>, JpaSpecificationExecutor {

    @Override
    <S extends ProductEntity> S saveAndFlush(S entity);

    List<ProductEntity> findAll();

    List<ProductEntity> findByProductNameContaining(String productName) throws Exception;

    @Query("select p from ProductEntity p, CategoryEntity c where p.productName = :productName and c.categoryName in :categoriesName")
    Page<ProductEntity> findByProductNameAndCategoryNameNamedParams(@Param("productName") String productName,
                                                                    @Param("categoriesName") List<String> categoriesName,
                                                                    Pageable pageable);

    @Override
    Page<ProductEntity> findAll(@Nullable Specification spec, Pageable pageable);

}
