package model;

public record Question(int id,
                       String category,
                       String difficulty,
                       String questionStatement,
                       String answerOptionA,
                       String answerOptionB,
                       String answerOptionC,
                       String answerOptionD) {
}
