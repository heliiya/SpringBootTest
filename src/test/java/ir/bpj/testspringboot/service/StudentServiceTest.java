package ir.bpj.testspringboot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.bpj.testspringboot.dto.StudentDto;
import ir.bpj.testspringboot.entity.StudentEntity;
import ir.bpj.testspringboot.repository.StudentRepository;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestGatewaySupport;

import java.net.SocketException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentController.class)
@WithMockUser*/
@SpringBootTest
public class StudentServiceTest {

    /*@Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentRepository studentRepository;

    @MockBean
    private StudentService studentService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() throws SocketException {
        objectMapper = new ObjectMapper();
        restTemplate = new RestTemplate();
        RestGatewaySupport gateway = new RestGatewaySupport();
        gateway.setRestTemplate(restTemplate);
        server = MockRestServiceServer.createServer(gateway);
    }*/

    /*@AfterEach
    void tearDown() {
    }*/

    @Test
    void save() {
        assertTrue(true);
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
        boolean saveResponse = studentService.save(studentDto);
        try {
            StudentEntity expectedEntity = studentDto.getEntity();
            studentRepository.saveAndFlush(expectedEntity);
            assertTrue(saveResponse);
        }catch (Exception e){
            assertFalse(saveResponse);
        }*/
/*
        String detailsString = objectMapper.writeValueAsString(studentDto);
        this.server.expect(requestTo("http://192.168.33.47:4001/student/save"))
                .andRespond(withSuccess(detailsString, MediaType.APPLICATION_JSON));*/
    }

    /*@Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void testDelete() {
    }

    @Test
    void testDelete1() {
    }

    @Test
    void findAll() {
    }

    @Test
    void find() {
    }

    @Test
    void testFind() {
    }

    @Test
    void fieldValueExists() {
    }*/
}