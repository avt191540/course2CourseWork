package pro.sky.course2CourseWork.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.course2CourseWork.EmptyCollectionException;
import pro.sky.course2CourseWork.QuestionNotFoundException;
import pro.sky.course2CourseWork.domain.Question;

import java.util.*;

import static pro.sky.course2CourseWork.constants.JavaQuestionServiceConstants.*;

public class JavaQuestionServiceTest {

    private JavaQuestionService out = new JavaQuestionService();
    private Set<Question> allJavaQuestions;

    @BeforeEach
    public void startSetupJavaQuestionService() {
        Question question1 = new Question("Какой размер памяти для переменной short", "2 байта");
        Question question2 = new Question("Какой размер памяти для переменной byte", "1 байта");
        Question question3 = new Question("Какой размер памяти для переменной char", "2 байта");
        Question question4 = new Question("Какой размер памяти для переменной int", "4 байта");
        out.add(question1);
        out.add(question2);
        out.add(question3);
        out.add(question4);
        allJavaQuestions = new HashSet<Question>(Set.of(question1, question2, question3, question4));
    }
    @Test
    public void shouldAddQuestionWhenItNotExists() {
        String result = out.add(QUESTION_FROM_QUESTION_WHO_IS_NOT_EXIST,
                ANSWER_FROM_QUESTION_WHO_IS_NOT_EXIST);
        Assertions.assertEquals(RETURN_QUESTION_WHEN_IT_IS_NOT_EXIST, result);
    }
    @Test
    public void shouldAddQuestionWhenItAlreadyExists() {
        String result = out.add(QUESTION_FROM_QUESTION_ALREADY_EXIST,
                ANSWER_FROM_QUESTION_ALREADY_EXIST);
        Assertions.assertEquals(RETURN_QUESTION_WHEN_IT_ALREADY_EXIST, result);
    }
    @Test
    public void shouldAddOneQuestionWhenItNotExists() {
        String result = out.add(QUESTION_WHEN_IT_IS_NOT_EXIST);
        Assertions.assertEquals(RETURN_QUESTION_WHEN_IT_IS_NOT_EXIST, result);
    }
    @Test
    public void shouldAddOneQuestionWhenItAlreadyExists() {
        String result = out.add(QUESTION_ALREADY_EXIST);
        Assertions.assertEquals(RETURN_QUESTION_WHEN_IT_ALREADY_EXIST, result);
    }
    @Test
    public void shouldReturnAllQuestions() {
        Collection<Question> result = out.getAll();
        Assertions.assertEquals(allJavaQuestions, result);
    }
    @Test
    public void shouldRemoveQuestionWhenItAlreadyExists() {
        String result = out.remove(QUESTION_FROM_QUESTION_ALREADY_EXIST,
                ANSWER_FROM_QUESTION_ALREADY_EXIST);
        Assertions.assertEquals(RETURN_QUESTION_WHEN_IT_ALREADY_EXIST, result);
    }
    @Test
    public void shouldThrowQuestionNotFoundExceptionWhenRemoveQuestionThatNotExists() {
        Assertions.assertThrows(QuestionNotFoundException.class,
                () -> out.remove(QUESTION_FROM_QUESTION_WHO_IS_NOT_EXIST,
                        ANSWER_FROM_QUESTION_WHO_IS_NOT_EXIST));
    }
    @Test
    public void shouldThrowEmptyCollectionExceptionWhenGetRandomQuestionWhenNoQuestionsExist() {
        //Делаем общий список вопросов пустым
        out.remove("Какой размер памяти для переменной short", "2 байта");
        out.remove("Какой размер памяти для переменной byte", "1 байта");
        out.remove("Какой размер памяти для переменной char", "2 байта");
        out.remove("Какой размер памяти для переменной int", "4 байта");
        Assertions.assertThrows(EmptyCollectionException.class,
                () -> out.getRandomQuestion());
    }
    @Test
    public void shouldReturnQuestionWhenGetRandomQuestion() {
        //Делаем так, что бы общий список вопросов состоял из одного вопроса,
        // тогда случайный выбор вопроса из этого списка вернет этот один вопрос
        out.remove("Какой размер памяти для переменной short", "2 байта");
        out.remove("Какой размер памяти для переменной byte", "1 байта");
        out.remove("Какой размер памяти для переменной char", "2 байта");
//        out.remove("Какой размер памяти для переменной int", "4 байта");
        Question result = out.getRandomQuestion();
        Assertions.assertEquals(QUESTION_RETURN_GET_RANDOM, result);
    }

}
