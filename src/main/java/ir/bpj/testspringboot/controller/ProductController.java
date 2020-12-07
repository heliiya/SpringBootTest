package ir.bpj.testspringboot.controller;

import ir.bpj.testspringboot.dto.ProductDto;
import ir.bpj.testspringboot.dto.ProductNameAndCategoriesNameRequestDto;
import ir.bpj.testspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping(value = "/save")
    public String save(@RequestBody ProductDto dto) {
        service.save(dto);
        return "Saved" + " " + dto.getProductName();
    }

    @GetMapping(value = "/show")
    public String findAll(){
        List<ProductDto> dtos = service.findAll();
        if(dtos != null && !dtos.isEmpty())
            return Arrays.toString(dtos.toArray());
        return "Not found any products!";
    }

   /* @GetMapping(value = "/showByName/{name}")
    public String findAllByName(@PathVariable String name){
        //List<ProductDto> dtos = service.findByProductName(name);
        List<ProductDto> dtos = service.findAll(name, null, 5);
        if(dtos != null && !dtos.isEmpty())
            return Arrays.toString(dtos.toArray());
        return "Not found any products by this name!";
    }
*/
    @PostMapping(value = "/showByProductNameAndCategoriesName")
    public String findAllByProductNameAndCategoriesName(@RequestBody ProductNameAndCategoriesNameRequestDto dto){
        List<ProductDto> dtos = service.findAllByProductNameAndCategoriesName(dto.getProductName(), dto.getCategoriesName(), dto.getRowNo());
        if(dtos != null && !dtos.isEmpty())
            return Arrays.toString(dtos.toArray());
        return "Not found any products by this name!";
    }

    @PostMapping(value = "/showByProductNameAndCategoriesNameUsingSpecification")
    public String findAllByProductNameAndCategoriesNameUsingSpecification(@RequestBody ProductNameAndCategoriesNameRequestDto dto){
        List<ProductDto> dtos = service.findAllByProductNameAndCategoriesNameUsingSpecification(dto.getProductName(), dto.getCategoriesName(), dto.getRowNo());
        if(dtos != null && !dtos.isEmpty())
            return Arrays.toString(dtos.toArray());
        return "Not found any products by this name!";
    }

}