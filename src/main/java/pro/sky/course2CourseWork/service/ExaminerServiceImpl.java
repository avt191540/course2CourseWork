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

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size()) {
            throw new IncorrectNumberOfQuestionsException();
        }
        Set<Question> questionsForJavaExam = new HashSet<>();
        int i = 0;
        while (i < amount) {
            Question question = questionService.getRandomQuestion();
            if (i == 0) {
                questionsForJavaExam.add(question);
                i++;
                continue;
            }
            if (questionsForJavaExam.contains(question)) {
                continue;
            }
            questionsForJavaExam.add(question);
            i++;
        }
        return questionsForJavaExam;
    }
}
