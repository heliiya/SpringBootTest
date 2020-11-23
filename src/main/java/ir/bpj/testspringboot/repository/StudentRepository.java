package ir.bpj.testspringboot.repository;

import ir.bpj.testspringboot.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    List<StudentEntity> findByName(String name) throws Exception;

}