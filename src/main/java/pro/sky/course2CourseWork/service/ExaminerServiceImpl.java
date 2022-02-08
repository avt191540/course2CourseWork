package pro.sky.course2CourseWork.service;

import org.springframework.stereotype.Service;
import pro.sky.course2CourseWork.IncorrectNumberOfQuestionsException;
import pro.sky.course2CourseWork.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    private Set<Question> questionsForJavaExam = new HashSet<>();

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount < questionService.getAll().size()) {
            throw new IncorrectNumberOfQuestionsException();
        }
        return null;
    }
}
