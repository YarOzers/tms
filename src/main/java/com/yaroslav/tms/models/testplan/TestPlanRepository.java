package com.yaroslav.tms.models.testplan;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestPlanRepository extends JpaRepository<TestPlan, Long> {
    List<TestPlan> findByProjectId(Long projectId);
}
