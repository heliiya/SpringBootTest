package ir.bpj.testspringboot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.bpj.testspringboot.dto.StudentDto;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestGatewaySupport;

import java.net.SocketException;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class StudentServiceTest {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private ObjectMapper objectMapper;

    private StudentDto studentDto;

    @BeforeEach
    void setUp() throws SocketException {
        studentDto = new StudentDto();
        objectMapper = new ObjectMapper();
        restTemplate = new RestTemplate();
        RestGatewaySupport gateway = new RestGatewaySupport();
        gateway.setRestTemplate(restTemplate);
        server = MockRestServiceServer.createServer(gateway);
    }

    /*@AfterEach
    void tearDown() {
    }*/

    @Test
    void save() throws JsonProcessingException {
        studentDto.setId(1L);
        studentDto.setName("Heliya");
        studentDto.setFamily("Darvish");
        studentDto.setNationalId("1111111111");
        studentDto.setAge(23);
        studentDto.setEmail("heliya.darvish@gmail.com");
        studentDto.setMobile("09365569852");
        studentDto.setBirthDate(DateUtil.yesterday());
        studentDto.setImage(null); //todo get base64 image
        String detailsString = objectMapper.writeValueAsString(studentDto);
        this.server.expect(requestTo("http://192.168.33.47:4001/student/save"))
                .andRespond(withSuccess(detailsString, MediaType.APPLICATION_JSON));
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