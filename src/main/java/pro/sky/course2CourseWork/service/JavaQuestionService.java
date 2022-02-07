package pro.sky.course2CourseWork.service;

import org.springframework.stereotype.Service;
import pro.sky.course2CourseWork.domain.Question;

import java.util.HashSet;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questions = new HashSet<>();

    @Override
    public String add(String question, String answer) {
        Question question1 = new Question("Что таке java?",
                "Объектно-ориентированный язык программирования");
        questions.add(question1);
        return question1.toString();
    }
}
