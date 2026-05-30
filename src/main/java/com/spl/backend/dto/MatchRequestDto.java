package com.spl.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchRequestDto {
    private Long teamAId;
    private Long teamBId;
    private Long tossWinnerId;
    private String tossDecision;
    private Integer overs;
}
