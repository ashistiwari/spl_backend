package com.spl.backend.repo;

import com.spl.backend.entity.CricketMatches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<CricketMatches,Long> {
}
