package com.spl.backend.stats;

import com.spl.backend.dto.AllRounderStatsResponse;
import com.spl.backend.dto.BatsmanStatsReponse;
import com.spl.backend.dto.BowlerStatsResponse;
import com.spl.backend.enums.PlayerRole;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlayerStatsService {

    private final PlayerStatsRepository playerStatsRepository;

    public Object getPlayerStats(Long playerId) {
        PlayerStats player = playerStatsRepository.findByPlayerId(playerId).orElseThrow(() -> new RuntimeException("Player not found"));
        PlayerRole role = player.getPlayer().getRole();
        if (role == PlayerRole.BATSMAN) {
            return new BatsmanStatsReponse(player.getPlayer().getId(),
                    player.getPlayer().getPlayerName(),
                    player.getMatchesPlayed(),
                    player.getBallsFaced(),
                    player.getTimesOut(),
                    player.getTotalRuns());
        }
        if (role == PlayerRole.BOWLER) {
            return new BowlerStatsResponse(player.getPlayer().getId(),
                    player.getPlayer().getPlayerName(),
                    player.getMatchesPlayed(),
                    player.getBallsBowled(),
                    player.getRunsConceded(),
                    player.getWicketsTaken());
        }

            return new AllRounderStatsResponse(player.getPlayer().getId(),
                    player.getPlayer().getPlayerName(),
                    player.getTotalRuns(),
                    player.getWicketsTaken(),
                    player.getRunsConceded(),
                    player.getBallsBowled(),
                    player.getMatchesPlayed(),
                    player.getBallsFaced());
        }


    }


