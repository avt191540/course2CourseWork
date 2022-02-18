package pro.sky.course2CourseWork.service;

import org.springframework.stereotype.Service;
import pro.sky.course2CourseWork.EmptyCollectionException;
import pro.sky.course2CourseWork.QuestionNotFoundException;
import pro.sky.course2CourseWork.domain.Question;

import java.util.*;

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
        if (!questions.contains(question1)) {
            throw new QuestionNotFoundException();
        }
        questions.remove(question1);
        return question1.toString();
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new EmptyCollectionException();
        }
        Random generator = new Random();
        int indexRandom = generator.nextInt(questions.size());
        List<Question> listQuestions = new ArrayList<Question>(questions);
        Question question = listQuestions.get(indexRandom);
        return question;
    }
}
