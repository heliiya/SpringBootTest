package ir.bpj.testspringboot.service;

import ir.bpj.testspringboot.dto.StudentDto;
import ir.bpj.testspringboot.entity.StudentEntity;
import ir.bpj.testspringboot.helper.customvalidation.unique.FieldValueExists;
import ir.bpj.testspringboot.repository.StudentRepository;
import ir.bpj.testspringboot.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements FieldValueExists {

    @Autowired
    private StudentRepository repository;

    public boolean save(StudentEntity entity) throws IllegalArgumentException {
        try {
            repository.saveAndFlush(entity);
            return true;
        } catch (Exception e){
            System.err.println(e.getMessage());
            throw new IllegalArgumentException();
        }
    }

    @CachePut(value = Constants.STUDENTS_CACHE_VALUE, key = "#dto.id")
    public boolean update(StudentEntity entity){
        try {
            long entityId = entity.getId();
            if(existsId(entityId)) {
                repository.saveAndFlush(entity);
                return true;
            }else {
                System.err.println("Not found student by id = " + entityId);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    @CacheEvict(value = Constants.STUDENTS_CACHE_VALUE, key = "#dto.id")
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

    @CacheEvict(value = Constants.STUDENTS_CACHE_VALUE, key = "#id")
    public boolean delete(Long id){
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    @CacheEvict(value = Constants.STUDENTS_CACHE_VALUE, key = "#nationalId")
    public boolean delete(String nationalId){
        try {
            repository.deleteByNationalId(nationalId);
            return true;
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return false;
    }

    @Cacheable(value = Constants.STUDENTS_CACHE_VALUE)
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

    @Cacheable(value = Constants.STUDENTS_CACHE_VALUE)
    public StudentDto findById(Long id){
        try {
            Optional<StudentEntity> entity = repository.findById(id);
            return new StudentDto(entity.get());
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Cacheable(value = Constants.STUDENTS_CACHE_VALUE)
    public List<StudentDto> findAllByName(String name){
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
        Assert.notNull(fieldName, "Field name is null");

        if (value == null)
            return false;

        if (fieldName.equals(Constants.ID_FIELD_NAME))
            return existsId((long) value);

        if(fieldName.equals(Constants.NATIONAL_ID_FIELD_NAME))
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