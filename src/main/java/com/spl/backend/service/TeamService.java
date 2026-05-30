package com.spl.backend.service;

import com.spl.backend.dto.TeamRequest;
import com.spl.backend.entity.Team;
import com.spl.backend.repo.TeamRepository;
import com.spl.backend.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {
    private TeamRepository teamRepository;
    private UserRepository userRepository;

    public Team createTeam(TeamRequest request, Authentication authentication){
        var user=userRepository.findByEmailId(authentication.getName()).orElseThrow();
        Team team=Team.builder()
                .teamName(request.getTeamName())
                .createdBy(user).build();
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }
}
