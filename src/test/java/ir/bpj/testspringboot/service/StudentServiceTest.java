package ir.bpj.testspringboot.service;

import ir.bpj.testspringboot.dto.StudentDto;
import ir.bpj.testspringboot.entity.StudentEntity;
import ir.bpj.testspringboot.repository.StudentRepository;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Before;
import org.junit.Test;
/*
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
*/
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save() {
        StudentEntity expectedEntity = new StudentEntity();
        expectedEntity.setId(1L);
        expectedEntity.setName("Heliya");
        expectedEntity.setFamily("Darvish");
        expectedEntity.setNationalId("1111111111");
        expectedEntity.setAge(23);
        expectedEntity.setEmail("heliya.darvish@gmail.com");
        expectedEntity.setMobile("09365569852");
        expectedEntity.setBirthDate(DateUtil.yesterday());
        expectedEntity.setImage(null); //todo get base64 image
        //when(studentRepository.saveAndFlush(expectedEntity)).thenReturn(expectedEntity);
        boolean saveResponse = studentService.save(expectedEntity);
        assertTrue(saveResponse);
        verify(studentRepository, times(1)).saveAndFlush(expectedEntity);
    }

    @Test
    public void update() {
        /*StudentEntity expectedEntity = new StudentEntity();
        expectedEntity.setId(7L);
        expectedEntity.setName("Heliya");
        expectedEntity.setFamily("Darvish");
        expectedEntity.setNationalId("9999999999");
        expectedEntity.setAge(23);
        expectedEntity.setEmail("heliya.darvish@gmail.com");
        expectedEntity.setMobile("09365569852");
        expectedEntity.setBirthDate(DateUtil.yesterday());
        expectedEntity.setImage(null); //todo get base64 image
        //when(studentRepository.saveAndFlush(expectedEntity)).thenReturn(expectedEntity);
        boolean updateResponse = studentService.update(expectedEntity);
        assertTrue(updateResponse);
        verify(studentRepository, times(1)).saveAndFlush(expectedEntity);*/
    }

    @Test
    public void delete() {
        /*StudentDto studentDto = new StudentDto();
        studentDto.setId(1L);
        studentDto.setName("Heliya");
        studentDto.setFamily("Darvish");
        studentDto.setNationalId("1111111111");
        studentDto.setAge(23);
        studentDto.setEmail("heliya.darvish@gmail.com");
        studentDto.setMobile("09365569852");
        studentDto.setBirthDate(DateUtil.yesterday());
        studentDto.setImage(null); //todo get base64 image
        StudentEntity expectedEntity = studentDto.getEntity();
        boolean saveResponse = studentService.delete(studentDto);
        assertTrue(saveResponse);*/
    }

    @Test
    public void testDelete() {
    }

    @Test
    public void testDelete1() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findAllByName() {
    }

    @Test
    public void fieldValueExists() {
    }
}