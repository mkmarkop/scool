package com.hackakthon.education.scool.model.repository;

import com.hackakthon.education.scool.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
