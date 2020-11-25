package ir.bpj.testspringboot.service;

import ir.bpj.testspringboot.dto.StudentDto;
import ir.bpj.testspringboot.entity.StudentEntity;
import ir.bpj.testspringboot.helper.validation.FieldValueExists;
import ir.bpj.testspringboot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements FieldValueExists {

    @Autowired
    private StudentRepository repository;

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

    public boolean delete(String nationalId){
        try {
            repository.deleteByNationalId(nationalId);
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
            return new StudentDto(entity.get());
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<StudentDto> find(String name){
        List<StudentDto> dtos = new ArrayList<>();
        try {
            List<StudentEntity> entities = repository.findAllByName(name);
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

    @Override
    public boolean fieldValueExists(Object value, String fieldName) throws UnsupportedOperationException {
        Assert.notNull(fieldName);

        if (value == null)
            return false;

        if (fieldName.equals("id"))
            return existsId((long) value);

        if(fieldName.equals("nationalId"))
            return existsNationalId(value.toString());

        throw new UnsupportedOperationException("Field name not supported");
    }

    private boolean existsId(long id) {
        try {
            return repository.existsById(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            return true;
        }
    }

    private boolean existsNationalId(String nationalId) {
        try {
            StudentEntity entity = repository.findByNationalId(nationalId);
            return entity != null;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            return true;
        }
    }
}