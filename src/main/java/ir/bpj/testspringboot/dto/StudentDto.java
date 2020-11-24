package ir.bpj.testspringboot.dto;

import com.sun.istack.NotNull;
import ir.bpj.testspringboot.entity.StudentEntity;
import ir.bpj.testspringboot.helper.ImageHelper;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Arrays;

public class StudentDto {
    private long id;
    private String name;
    private String family;
    private Integer age;
    private String image;

    public StudentDto(String data, MultipartFile image) throws IOException {
        JSONObject jsonObject = new JSONObject(data);
        this.id = jsonObject.getLong("id");
        this.name = jsonObject.getString("name");
        this.family = jsonObject.getString("family");
        this.age = jsonObject.getInt("age");
        this.image = ImageHelper.convertImageByteArrayToBase64String(image.getBytes());
    }

    public StudentDto(@NotNull StudentEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.family = entity.getFamily();
        this.age = entity.getAge();
        this.image = ImageHelper.convertImageByteArrayToBase64String(entity.getImage());
    }

    public StudentEntity getEntity(){
        StudentEntity entity = new StudentEntity();
        entity.setId(id);
        entity.setName(name);
        entity.setFamily(family);
        entity.setAge(age);
        entity.setImage(ImageHelper.convertBase64StringToImageByteArray(image));
        return entity;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", image=" + image +
                '}';
    }
}