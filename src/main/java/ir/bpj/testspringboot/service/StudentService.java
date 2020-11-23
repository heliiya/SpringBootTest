package ir.bpj.testspringboot.service;

import ir.bpj.testspringboot.entity.StudentEntity;
import ir.bpj.testspringboot.dto.StudentDto;
import ir.bpj.testspringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public boolean save(StudentDto dto){
        StudentEntity entity = dto.getEntity();
        try {
            repository.save(entity);
            return true;
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    public boolean update(StudentDto dto){
        StudentEntity entity = dto.getEntity();
        try {
            repository.saveAndFlush(entity);
            return true;
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    public boolean delete(StudentDto dto){
        StudentEntity entity = dto.getEntity();
        try {
            repository.delete(entity);
            return true;
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    public boolean delete(Long id){
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    public List<StudentDto> findAll(){
        List<StudentDto> dtos = new ArrayList<>();
        try {
            List<StudentEntity> entities = repository.findAll();
            if(!entities.isEmpty()){
                entities.forEach(entity -> {
                    StudentDto dto = new StudentDto(entity);
                    dtos.add(dto);
                });
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return dtos;
    }

    public StudentDto find(Long id){
        try {
            Optional<StudentEntity> entity = repository.findById(id);
            StudentDto dto = new StudentDto(entity.get());
            return dto;
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<StudentDto> find(String name){
        List<StudentDto> dtos = new ArrayList<>();
        try {
            List<StudentEntity> entities = repository.findByName(name);
            if(!entities.isEmpty()){
                entities.forEach(entity -> {
                    StudentDto dto = new StudentDto(entity);
                    dtos.add(dto);
                });
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return dtos;
    }
}