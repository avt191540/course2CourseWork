package pro.sky.course2CourseWork.constants;

import pro.sky.course2CourseWork.domain.Question;

public class JavaQuestionServiceConstants {

    public static final String QUESTION_FROM_QUESTION_WHO_IS_NOT_EXIST =
            "Какой размер памяти для переменной long";
    public static final String ANSWER_FROM_QUESTION_WHO_IS_NOT_EXIST = "8 байт";
    public static final Question QUESTION_WHEN_IT_IS_NOT_EXIST =
            new Question("Какой размер памяти для переменной long", "8 байт");
    public static final String RETURN_QUESTION_WHEN_IT_IS_NOT_EXIST =
            QUESTION_WHEN_IT_IS_NOT_EXIST.toString();
    public static final String QUESTION_FROM_QUESTION_ALREADY_EXIST =
            "Какой размер памяти для переменной short";
    public static final String ANSWER_FROM_QUESTION_ALREADY_EXIST = "2 байта";
    public static final Question QUESTION_ALREADY_EXIST =
            new Question("Какой размер памяти для переменной short", "2 байта");
    public static final String RETURN_QUESTION_WHEN_IT_ALREADY_EXIST =
            QUESTION_ALREADY_EXIST.toString();
    public static final Question QUESTION_RETURN_GET_RANDOM =
            new Question("Какой размер памяти для переменной int", "4 байта");
    public static final int AMOUNT_BAD = 5;
    public static final int AMOUNT_CORRECT = 1;
}
