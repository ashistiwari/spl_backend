package com.spl.backend.stats;

import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PlayerStatsRepository {

        Optional<PlayerStats> findByPlayerId(Long playerId);
    }

