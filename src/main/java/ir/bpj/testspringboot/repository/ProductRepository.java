package ir.bpj.testspringboot.repository;

import ir.bpj.testspringboot.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Override
    <S extends ProductEntity> S saveAndFlush(S entity);

    List<ProductEntity> findByProductName(String productName) throws Exception;

    List<ProductEntity> findAll();

    List<ProductEntity> findByProductNameContaining(String productName) throws Exception;

}
