package de.bs14.lf8.model;

public record Question(int questionId,
                       String category,
                       String difficulty,
                       String questionStatement,
                       String answerOptionA,
                       String answerOptionB,
                       String answerOptionC,
                       String answerOptionD,
                       String rightAnswer) {
}
