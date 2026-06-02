package com.spl.backend.dto;

import com.spl.backend.enums.PlayerRole;
import com.spl.backend.stats.PlayerStats;
import com.spl.backend.stats.PlayerStatsRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AllRounderStatsResponse {
    private Long playerId;
    private String playerName;
    private Integer matchesPlayed;

    private Integer totalRuns;
    private Integer ballsFaced;

    private Integer ballsBowled;
    private Integer runsConceded;
    private Integer wicketsTaken;

}
