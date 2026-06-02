package com.spl.backend.controller;

import com.spl.backend.stats.PlayerStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
@RequiredArgsConstructor
public class PlayerStatsController {

    private PlayerStatsService playerStatsService;
    @GetMapping("/players/{playerId}")
    public Object getPlayerStats(@PathVariable Long playerId){
        return playerStatsService.getPlayerStats(playerId);
    }

}
