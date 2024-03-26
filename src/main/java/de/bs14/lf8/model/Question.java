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
    @Column
    private int questionId;

    @Column
    private int category;

    @Column
    private int difficulty;

    @Column
    private String questionStatement;

    @Column
    private String answerOptionA;

    @Column
    private String answerOptionB;

    @Column
    private String answerOptionC;

    @Column
    private String answerOptionD;

    @Column
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
