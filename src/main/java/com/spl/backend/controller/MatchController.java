package com.spl.backend.controller;

import com.spl.backend.dto.MatchRequestDto;
import com.spl.backend.entity.CricketMatches;
import com.spl.backend.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/matches")
public class MatchController {

    private MatchService matchService;
    @PostMapping
    public CricketMatches createMatch(@RequestBody MatchRequestDto request) {
        return matchService.createMatches(request);
    }

    @GetMapping
    public List<CricketMatches> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("/{matchId}")
    public CricketMatches getMatch(@PathVariable Long matchId) {
        return matchService.getMatch(matchId);
    }

}

