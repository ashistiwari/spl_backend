package com.spl.backend.stats;

import com.spl.backend.entity.Player;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerStats {
    private Long id;
    private Player player;
    private Integer matchesPlayed;
    private Integer totalRuns;
    private Integer ballsFaced;
    private Integer timesOut;
    private Integer ballsBowled;
    private Integer runsConceded;
    private Integer wicketsTaken;
}
