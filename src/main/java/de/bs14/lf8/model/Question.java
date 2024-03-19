package de.bs14.lf8.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

  @Entity
  @Table(name = "Question")
  @Getter
  @ToString
  @NoArgsConstructor
  @Setter

  public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QuestionId")
    private int questionId;

    @Column(name = "Category")
    private int category;

    @Column(name = "Difficulty")
    private int difficulty;

    @Column(name = "QuestionStatement")
    private String questionStatement;

    @Column(name = "AnswerOptionA")
    private String answerOptionA;

    @Column(name = "AnswerOptionB")
    private String answerOptionB;

    @Column(name = "AnswerOptionC")
    private String answerOptionC;

    @Column(name = "AnswerOptionD")
    private String answerOptionD;

    @Column(name = "RightAnswer")
    private String rightAnswer;

    public Question(int category, int difficulty, String questionStatement, String answerOptionA,
        String answerOptionB, String answerOptionC, String answerOptionD, String rightAnswer) {
      this.category = category;
      this.difficulty = difficulty;
      this.questionStatement = questionStatement;
      this.answerOptionA = answerOptionA;
      this.answerOptionB = answerOptionB;
      this.answerOptionC = answerOptionC;
      this.answerOptionD = answerOptionD;
      this.rightAnswer= rightAnswer;

    }
  }
