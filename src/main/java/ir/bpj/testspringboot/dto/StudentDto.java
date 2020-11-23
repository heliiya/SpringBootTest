package ir.bpj.testspringboot.dto;

import com.sun.istack.NotNull;
import ir.bpj.testspringboot.entity.StudentEntity;

import java.util.Arrays;

public class StudentDto {
    private long id;
    private String name;
    private String family;
    private Integer age;
    private byte[] image;

    public StudentDto() {
    }

    public StudentDto(@NotNull StudentEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.family = entity.getFamily();
        this.age = entity.getAge();
        this.image = entity.getImage();
    }

    public StudentEntity getEntity(){
        StudentEntity entity = new StudentEntity();
        entity.setId(id);
        entity.setName(name);
        entity.setFamily(family);
        entity.setAge(age);
        entity.setImage(image);
        return entity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}