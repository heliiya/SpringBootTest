package ir.bpj.testspringboot.service;

import ir.bpj.testspringboot.dto.ProductDto;
import ir.bpj.testspringboot.entity.ProductEntity;
import ir.bpj.testspringboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public void save(ProductDto dto){
        ProductEntity entity = dto.getEntity();
        repository.saveAndFlush(entity);
    }

    public List<ProductDto> findAll(){
        List<ProductDto> dtos = new ArrayList<>();
        try {
            List<ProductEntity> entities = repository.findAll();
            if(!entities.isEmpty()){
                entities.forEach(entity -> {
                    ProductDto dto = new ProductDto(entity);
                    dtos.add(dto);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return dtos;
    }

    public List<ProductDto> findByProductName(String productName){
        List<ProductDto> dtos = new ArrayList<>();
        try {
            List<ProductEntity> entities = repository.findByProductNameContaining(productName);
            if(entities != null && !entities.isEmpty()){
                entities.forEach(entity -> {
                    ProductDto dto = new ProductDto(entity);
                    dtos.add(dto);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return dtos;
    }

    public List<ProductDto> findByProductNameAndCategoriesName(String productName, List<String> categoriesName, Integer rowNo){
        List<ProductDto> dtos = new ArrayList<>();
        try {
            Pageable pageable = PageRequest.of(0, rowNo);
            Page<ProductEntity> entitiesPage = repository.findByProductNameAndCategoryNameNamedParams(productName, categoriesName, pageable);
            List<ProductEntity> entities = entitiesPage.getContent();
            if(!entities.isEmpty()){
                entities.forEach(entity -> {
                    ProductDto dto = new ProductDto(entity);
                    dtos.add(dto);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return dtos;
    }

}