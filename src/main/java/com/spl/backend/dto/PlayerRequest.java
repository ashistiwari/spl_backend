package com.spl.backend.dto;

import lombok.Data;

@Data
public class PlayerRequest {
    private String playerName;
    private String role;
    private Long teamId;
}
