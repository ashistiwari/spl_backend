package com.spl.backend.service;

import com.spl.backend.dto.MatchRequestDto;
import com.spl.backend.entity.CricketMatches;
import com.spl.backend.entity.Team;
import com.spl.backend.repo.MatchRepository;
import com.spl.backend.repo.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    private MatchRepository matchRepository;
    private TeamRepository teamRepository;

    public CricketMatches createMatches(MatchRequestDto matchRequestDto){
        Team teamA=teamRepository.findById(matchRequestDto.getTeamAId()).orElseThrow(()->new RuntimeException("Team A not found"));
        Team teamB=teamRepository.findById(matchRequestDto.getTeamBId()).orElseThrow(()-> new RuntimeException("Team B not found"));
        Team tossWinner =teamRepository.findById(matchRequestDto.getTossWinnerId()).orElseThrow(()-> new RuntimeException("Toss Winner not found"));
        Team battingTeam;
        Team bowlingTeam;
        if ("BAT".equalsIgnoreCase(matchRequestDto.getTossDecision())){
            battingTeam = tossWinner;
            bowlingTeam = tossWinner.getId().equals(teamA.getId()) ? teamB : teamA;
        } else {
            bowlingTeam = tossWinner;
            battingTeam = tossWinner.getId().equals(teamA.getId()) ? teamB : teamA;
        }

        CricketMatches match = new CricketMatches();
        match.setTeamA(teamA);
        match.setTeamB(teamB);
        match.setTossWinner(tossWinner);
        match.setTossDecision(matchRequestDto.getTossDecision());
        match.setOvers(matchRequestDto.getOvers());
        match.setStatus("CREATED");
        match.setBattingTeam(battingTeam);
        match.setBowlingTeam(bowlingTeam);

        return matchRepository.save(match);
    }

    public CricketMatches getMatch(Long matchId) {
        return matchRepository.findById(matchId)
                .orElseThrow(() -> new RuntimeException("Match not found"));
    }

    public List<CricketMatches> getAllMatches() {
        return matchRepository.findAll();
    }
    }

