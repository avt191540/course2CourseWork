package pro.sky.course2CourseWork.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2CourseWork.domain.Question;
import pro.sky.course2CourseWork.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/java/get")
    public Collection<Question> getExamQuestions(@RequestParam int amount) {
        return examinerService.getQuestions(amount);
    }
}
