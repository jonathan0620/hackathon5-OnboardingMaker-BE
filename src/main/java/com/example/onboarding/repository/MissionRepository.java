package com.example.onboarding.repository;

import com.example.onboarding.dto.MissionListDto;
import com.example.onboarding.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Integer> {

    @Query("""
    SELECT new com.example.onboarding.dto.MissionListDto(
          m.title, m.description, m.deadline, m.missionId
        )
    FROM Mission m
    ORDER BY m.deadline ASC
  """)
    List<MissionListDto> findTitleAndDeadline();
}
