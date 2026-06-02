package com.spl.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BowlerStatsResponse {

    private Long playerId;
    private String playerName;
    private Integer matchesPlayed;
    private Integer ballsBowled;
    private Integer runsConceded;
    private Integer wicketsTaken;
}
