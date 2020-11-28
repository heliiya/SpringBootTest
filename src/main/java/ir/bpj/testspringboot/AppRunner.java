package ir.bpj.testspringboot;

import ir.bpj.testspringboot.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final StudentService studentService;

    public AppRunner(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {
        /*logger.info(".... Fetching students");
        logger.info("nationalId-hhhhhhhhhh -->" + studentService.find("hhhhhhhhhh"));
        logger.info("nationalId-hhhhhhhhhh -->" + studentService.find("hhhhhhhhhh"));
        logger.info("nationalId-hhhhhhhhhh -->" + studentService.find("hhhhhhhhhh"));
        logger.info("nationalId-hhhhhhhhhh -->" + studentService.find("hhhhhhhhhh"));*/
    }

}