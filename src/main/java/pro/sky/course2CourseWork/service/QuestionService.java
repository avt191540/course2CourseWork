package pro.sky.course2CourseWork.service;

import pro.sky.course2CourseWork.domain.Question;

import java.util.Collection;

public interface QuestionService {

    String add(String question, String answer);

    String add(Question question);

    Collection<Question> getAll();

    String remove(String question, String answer);

    Question getRandomQuestion();

}
