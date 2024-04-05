package de.bs14.lf8.repository;

import de.bs14.lf8.model.Player;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Integer> {


  Iterable<Player> findAll(Sort sort);
  List<Player> findByPlayerName(String playerName);
}
