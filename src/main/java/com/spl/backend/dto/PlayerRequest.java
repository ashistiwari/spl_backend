package com.spl.backend.dto;

import com.spl.backend.enums.PlayerRole;
import lombok.Data;

@Data
public class PlayerRequest {
    private String playerName;
    private PlayerRole role;
    private Long teamId;
}
