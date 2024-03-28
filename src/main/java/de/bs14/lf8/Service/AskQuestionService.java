package de.bs14.lf8.Service;

import de.bs14.lf8.model.Question;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AskQuestionService {

  private final QuestionReaderService questionReaderService;
  private final CountdownService countdownService;
  private final InputReaderService inputReaderService;


  public void askQuestion(Question question) {
    String playerAnswer = "";
    questionReaderService.printQuestion(question);

    InputReaderThreadService inputReaderThreadService = new InputReaderThreadService(inputReaderService);
    inputReaderThreadService.start();
    countdownService.startCountdown();
    while (countdownService.isTimeUp() == false) {
      if (inputReaderThreadService.isAnswerGiven()) {
        countdownService.stopCountdown();
        playerAnswer = inputReaderThreadService.getPlayerAnswer();
      }
    }
    inputReaderThreadService.interrupt(); //fährt Thread runter
    if (playerAnswer.equals("")) {
      // Player did not give answer
    } else { // Player gave Answer}
      int remainingTime = countdownService.getRemainingTime();
    }


  }

}
