package pro.sky.course2CourseWork.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course2CourseWork.IncorrectNumberOfQuestionsException;
import pro.sky.course2CourseWork.domain.Question;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static pro.sky.course2CourseWork.constants.JavaQuestionServiceConstants.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    private Set<Question> questionsToExam;
    private final QuestionService questionServiceMock = mock(QuestionService.class);
    @InjectMocks
    private ExaminerServiceImpl out;

    @BeforeEach
    public void startSetupJavaQuestionService() {
        Question question1 = new Question("Какой размер памяти для переменной int", "4 байта");
        questionsToExam = new HashSet<Question>(Set.of(question1));
    }

    @Test
    public void shouldCallQuestionServiceMethodWhenGetQuestionsToExamWithCorrectAmount() {
        when(questionServiceMock.getAll()).thenReturn(questionsToExam);
        when(questionServiceMock.getRandomQuestion()).thenReturn(QUESTION_RETURN_GET_RANDOM);
        Assertions.assertEquals(questionsToExam,
                out.getQuestions(AMOUNT_CORRECT));
        verify(questionServiceMock, times(1)).getRandomQuestion();
        verify(questionServiceMock, times(1)).getAll();
    }
    @Test
    public void shouldThrowIncorrectNumberOfQuestionsExceptionWhenGetQuestionsToExamWithBadAmount() {
        when(questionServiceMock.getAll()).thenReturn(questionsToExam);
        Assertions.assertThrows(IncorrectNumberOfQuestionsException.class, ()->
                out.getQuestions(AMOUNT_BAD));
        verify(questionServiceMock, never()).getRandomQuestion();
    }
}
