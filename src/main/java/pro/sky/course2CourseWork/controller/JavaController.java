package pro.sky.course2CourseWork.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.course2CourseWork.service.QuestionService;

@RestController
@RequestMapping("/exam")
public class JavaController {
    private QuestionService questionService;


    public JavaController(QuestionService service) {
        this.questionService = service;
    }

    @GetMapping("/java/add")
    public String addQuestion(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }
}
