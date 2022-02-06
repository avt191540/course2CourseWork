package pro.sky.course2CourseWork.controller;

import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2CourseWork.service.ExaminerService;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

}
