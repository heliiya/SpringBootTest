package ir.bpj.testspringboot.dto;

import ir.bpj.testspringboot.entity.StudentEntity;
import ir.bpj.testspringboot.helper.imagebase64.ImageHelper;
import ir.bpj.testspringboot.helper.customvalidation.unique.Unique;
import ir.bpj.testspringboot.service.StudentService;
import ir.bpj.testspringboot.util.Constants;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.*;
import java.util.Date;

public class StudentDto {
    @NotNull
    @Unique(service = StudentService.class, fieldName = Constants.ID_FIELD_NAME, message = "{id.unique.violation}")
    private long id;
    @NotNull @Size(max = 10, min = 10) @Digits(integer = 10, fraction = 0)
    @NotBlank(message = "National Id is mandatory")
    @Unique(service = StudentService.class, fieldName = Constants.NATIONAL_ID_FIELD_NAME, message = "{nationalId.unique.violation}")
    private String nationalId;
    @Size(max = 30)
    private String name;
    @Size(max = 30)
    private String family;
    @Max(99)
    private Integer age;
    private String image;
    @Email
    private String email;
    @Pattern(regexp = "09[0-9]{9}")
    private String mobile;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthDate;

    public StudentDto() {
    }

    public StudentDto(@NotNull StudentEntity entity) {
        this.id = entity.getId();
        this.nationalId = entity.getNationalId();
        this.name = entity.getName();
        this.family = entity.getFamily();
        this.age = entity.getAge();
        this.image = ImageHelper.convertImageByteArrayToBase64String(entity.getImage());
        this.email = entity.getEmail();
        this.mobile = entity.getMobile();
        this.birthDate = entity.getBirthDate();
    }

    public StudentEntity getEntity(){
        StudentEntity entity = new StudentEntity();
        entity.setId(id);
        entity.setNationalId(nationalId);
        entity.setName(name);
        entity.setFamily(family);
        entity.setAge(age);
        entity.setImage(ImageHelper.convertBase64StringToImageByteArray(image));
        entity.setEmail(email);
        entity.setMobile(mobile);
        entity.setBirthDate(birthDate);
        return entity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", nationalId='" + nationalId + '\'' +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", image='" + image + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", birthDate='" + birthDate.toString() + '\'' +
                '}';
    }
}