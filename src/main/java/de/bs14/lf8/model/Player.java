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
@Table(name = "Player")
@Getter
@ToString
@NoArgsConstructor
@Setter
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int playerId;

  @Column
  private String playerName;

  @Column
  private String playerPassword;

  @Column
  private int rankingPoints;

  @Column
  private String rankingTitle;

  public Player(String playerName, String playerPassword, int rankingPoints, String rankingTitle) {
    this.playerName = playerName;
    this.playerPassword = playerPassword;
    this.rankingPoints = rankingPoints;
    this.rankingTitle = rankingTitle;
  }
}

