package com.yaroslav.tms.models.testplan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestPlanService {
    @Autowired
    private TestPlanRepository testPlanRepository;

    public List<TestPlan> getAllTestPlans() {
        return testPlanRepository.findAll();
    }

    public TestPlan getTestPlanById(Long id) {
        return testPlanRepository.findById(id).orElse(null);
    }

    public TestPlan saveTestPlan(TestPlan testPlan) {
        return testPlanRepository.save(testPlan);
    }

    public void deleteTestPlan(Long id) {
        testPlanRepository.deleteById(id);
    }

    public List<TestPlan> getTestPlansByProjectId(Long projectId) {
        return testPlanRepository.findByProjectId(projectId);
    }
}
