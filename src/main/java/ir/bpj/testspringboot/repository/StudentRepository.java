package ir.bpj.testspringboot.repository;

import ir.bpj.testspringboot.entity.StudentEntity;
import ir.bpj.testspringboot.util.Constants;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    @Override
    <S extends StudentEntity> S saveAndFlush(S entity);

    @Override
    void delete(StudentEntity entity) throws IllegalArgumentException;

    @Override
    void deleteById(Long id) throws IllegalArgumentException;

    void deleteByNationalId(String nationalId) throws Exception;

    @Override
    List<StudentEntity> findAll();

    @Override
    Optional<StudentEntity> findById(Long id) throws IllegalArgumentException;

    List<StudentEntity> findAllByName(String name) throws Exception;

    @Cacheable(value = Constants.STUDENTS_CACHE_VALUE)
    StudentEntity findByNationalId(String nationalId) throws Exception;

    @Override
    boolean existsById(Long id) throws IllegalArgumentException;
}