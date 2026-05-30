package com.spl.backend.controller;

import com.spl.backend.dto.TeamRequest;
import com.spl.backend.entity.Team;
import com.spl.backend.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;
@PostMapping("/createTeam")
    public Team createTeam(@RequestBody TeamRequest request, Authentication authentication){
        return teamService.createTeam(request,authentication);
    }

}
