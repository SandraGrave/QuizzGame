package de.bs14.lf8.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.stereotype.Service;

@Service
public class InputReaderService {

  public String readInput (){
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    try {
      return reader.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
