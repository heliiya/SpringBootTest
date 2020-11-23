package ir.bpj.testspringboot.dto;

import ir.bpj.testspringboot.entity.StudentEntity;

public class StudentDto {
    private long id;
    private String name;
    private String family;
    private Integer age;

    public StudentDto() {
    }

    public StudentDto(StudentEntity studentEntity) {
        this.id = studentEntity.getId();
        this.name = studentEntity.getName();
        this.family = studentEntity.getFamily();
        this.age = studentEntity.getAge();
    }

    public StudentEntity getEntity(){
        StudentEntity entity = new StudentEntity();
        entity.setId(id);
        entity.setName(name);
        entity.setFamily(family);
        entity.setAge(age);
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

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                '}';
    }
}