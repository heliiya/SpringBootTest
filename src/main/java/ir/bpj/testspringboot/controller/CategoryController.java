package ir.bpj.testspringboot.controller;

import ir.bpj.testspringboot.dto.CategoryDto;
import ir.bpj.testspringboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService service;

    @PostMapping("/save")
    public String save(@RequestBody CategoryDto dto){
        service.save(dto);
        return "Save " + dto.getCategoryName();
    }

    @GetMapping("/show")
    public String show(){
        List<CategoryDto> dtos = service.findAll();
        if(dtos != null && !dtos.isEmpty())
            return Arrays.toString(dtos.toArray());
        return "Not found any products by this name!";
    }
}
