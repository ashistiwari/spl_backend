package com.spl.backend.service;

import com.spl.backend.dto.PlayerRequest;
import com.spl.backend.entity.Player;
import com.spl.backend.entity.Team;
import com.spl.backend.repo.PlayerRepository;
import com.spl.backend.repo.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private PlayerRepository playerRepository;
    private TeamRepository teamRepository;

    public Player createPlayer(PlayerRequest request){
        Team team=teamRepository.findById(request.getTeamId()).orElseThrow(()-> new RuntimeException("Team not found"));
        Player player=new Player();;
        player.setPlayerName(request.getPlayerName());
        player.setRole(request.getRole());
        player.setTeam(team);
        return playerRepository.save(player);

    }

    public List<Player> getPlayersByTeam(Long teamId) {
        return playerRepository.findByTeamId(teamId);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}