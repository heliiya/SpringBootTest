package ir.bpj.testspringboot.controller;

import ir.bpj.testspringboot.dto.StudentDto;
import ir.bpj.testspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping(value = "/save")
    public String save(@RequestBody @Validated StudentDto dto) {
        boolean save = service.save(dto);
        if(save)
            return "Saved" + " " + dto.getName() + " " + dto.getFamily();
        return "Failed to save!";
    }

    /*@PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String save(@RequestParam("image") MultipartFile image, @RequestParam("data") String data) {
        try {
            StudentDto dto = new StudentDto(data, image);
            boolean save = service.save(dto);
            if(save)
                return "Saved" + " " + dto.getName() + " " + dto.getFamily();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return "Failed to save!";
    }*/

    @GetMapping(value = "/show")
    public String findAll(){
        List<StudentDto> dtos = service.findAll();
        if(dtos != null && !dtos.isEmpty())
            return Arrays.toString(dtos.toArray());
        return "Not found any students!";
    }

    @GetMapping(value = "/showById/{id}")
    public String findById(@PathVariable Long id){
        StudentDto dto = service.find(id);
        if(dto != null)
            return dto.toString();
        return "Not found student by id = " + id;
    }

    @GetMapping(value = "/showByName/{name}")
    public String findAllByName(@PathVariable String name){
        List<StudentDto> dtos = service.find(name);
        if(dtos != null && !dtos.isEmpty())
            return Arrays.toString(dtos.toArray());
        return "Not found any students!";
    }

    @PostMapping(value = "/update")
    public String update(@RequestBody @Validated StudentDto dto) {
        boolean update = service.update(dto);
        if(update)
            return "Updated" + " " + dto.getName() + " " + dto.getFamily();
        return "Failed to update!";
    }

    @PostMapping(value = "/delete")
    public String delete(@RequestBody @Validated StudentDto dto) {
        boolean delete = service.delete(dto);
        if(delete)
            return "Deleted" + " " + dto.getName() + " " + dto.getFamily();
        return "Failed to delete!";
    }


    @GetMapping(value = "/deleteById/{id}")
    public String delete(@PathVariable Long id) {
        boolean delete = service.delete(id);
        if(delete)
            return "Deleted student by id = " + " " + id;
        return "Failed to delete!";
    }

    @GetMapping(value = "/deleteByNationalId/{nationalId}")
    public String delete(@PathVariable @Validated @Size(max = 10, min = 10)
                             @Digits(integer = 10, fraction = 0) String nationalId) {
        boolean delete = service.delete(nationalId);
        if(delete)
            return "Deleted student by national id = " + " " + nationalId;
        return "Failed to delete!";
    }

}