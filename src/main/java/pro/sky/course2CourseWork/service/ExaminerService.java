package pro.sky.course2CourseWork.service;

import pro.sky.course2CourseWork.domain.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
