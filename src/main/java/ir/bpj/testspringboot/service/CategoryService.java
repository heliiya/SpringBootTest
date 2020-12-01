package ir.bpj.testspringboot.service;

import ir.bpj.testspringboot.dto.CategoryDto;
import ir.bpj.testspringboot.entity.CategoryEntity;
import ir.bpj.testspringboot.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public void save(CategoryDto dto){
        CategoryEntity entity = dto.getEntity();
        try {
            repository.saveAndFlush(entity);
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public List<CategoryDto> findAll(){
        List<CategoryDto> dtos = new ArrayList<>();
        try {
            List<CategoryEntity> entities = repository.findAll();
            if(!entities.isEmpty()){
               entities.forEach(entity -> {
                   CategoryDto dto = new CategoryDto(entity);
                   dtos.add(dto);
               });
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        return dtos;
    }
}
