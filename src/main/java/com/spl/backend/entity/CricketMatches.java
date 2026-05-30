package com.spl.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cricket_matches")
public class CricketMatches {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer overs;
    private String status;
    @ManyToOne
    @JoinColumn(name="team_a_id")
    private Team teamA;
    @ManyToOne
    @JoinColumn(name = "team_b_id")
    private Team teamB;
    @ManyToOne
    @JoinColumn(name = "toss_winner")
    private Team tossWinner;
    private String tossDecision;
    @ManyToOne
    @JoinColumn(name = "batting_team_id")
    private Team battingTeam;
    @ManyToOne
    @JoinColumn(name = "bowling_team_id")
    private Team bowlingTeam;
}
