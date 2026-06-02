package com.spl.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class BatsmanStatsReponse {
    private Long playerId;
    private String playerName;
    private Integer matchesPlayed;
    private Integer totalRuns;
    private Integer ballsfaced;
    private Integer timesOut;
}
