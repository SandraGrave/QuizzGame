package de.bs14.lf8;

import de.bs14.lf8.Service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties
@RequiredArgsConstructor
public class Lf8Application implements CommandLineRunner {

  private final DatabaseInsertCheckerService databaseInsertCheckerService;
  private final MainMenu mainMenu;


  public static void main(String[] args) {
    new SpringApplicationBuilder().sources(Lf8Application.class).run(args);
  }

  @Override
  public void run(String... args) {
    databaseInsertCheckerService.preProcessDatabase();
    mainMenu.showMainMenu();
  }
}
