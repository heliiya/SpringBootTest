package ir.bpj.testspringboot.repository;

import ir.bpj.testspringboot.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    List<StudentEntity> findAllByName(String name) throws Exception;

    void deleteByNationalId(String nationalId) throws Exception;

    StudentEntity findByNationalId(String nationalId) throws Exception;

}