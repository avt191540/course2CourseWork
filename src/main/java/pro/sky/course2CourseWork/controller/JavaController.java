package pro.sky.course2CourseWork.controller;

import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2CourseWork.service.QuestionService;

@RestController
public class JavaController {
    private QuestionService service;


    public JavaController(QuestionService service) {
        this.service = service;
    }
}
