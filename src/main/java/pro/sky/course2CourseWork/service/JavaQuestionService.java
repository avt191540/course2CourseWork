package pro.sky.course2CourseWork.service;

import org.springframework.stereotype.Service;
import pro.sky.course2CourseWork.EmptyCollectionException;
import pro.sky.course2CourseWork.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questions = new HashSet<>();

    @Override
    public String add(String question, String answer) {
        Question question1 = new Question(question, answer);
        questions.add(question1);
        return question1.toString();
    }

    public String add(Question question) {
        questions.add(question);
        return question.toString();
    }
    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public String remove(String question, String answer) {
        Question question1 = new Question(question, answer);
        questions.remove(question1);
        return question1.toString();
    }

    @Override
    public Question getRandomQuestion() {
        Random objGenerator = new Random();
        int iCount = 0;
        int iRandom = objGenerator.nextInt(questions.size() - 1);
        for (Question question: questions) {
            if (iCount == iRandom) {
                return question;
            }
            iCount++;
        }
        throw new EmptyCollectionException();
    }
}
