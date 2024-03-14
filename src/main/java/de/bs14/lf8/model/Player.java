package de.bs14.lf8.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
  @Column(name = "PlayerID")
  private int playerId;

  @Column(name = "PlayerName")
  private String playerName;

  @Column(name = "PlayerPassword")
  private String playerPassword;

  @Column(name = "RankingPoints")
  private int rankingPoints;

  @Column(name = "RankingTitle")
  private String rankingTitle;

  public Player(int playerId, String playerName, String playerPassword, int rankingPoints, String rankingTitle) {
    this.playerId = playerId;
    this.playerName = playerName;
    this.playerPassword = playerPassword;
    this.rankingPoints = rankingPoints;
    this.rankingTitle = rankingTitle;
  }
}

