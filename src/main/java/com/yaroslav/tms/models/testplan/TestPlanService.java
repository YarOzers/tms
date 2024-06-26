package com.yaroslav.tms.models.testplan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestPlanService {
    private final TestPlanRepository testPlanRepository;

    public TestPlanService(TestPlanRepository testPlanRepository) {
        this.testPlanRepository = testPlanRepository;
    }

    public List<TestPlan> getAllTestPlans() {
        return testPlanRepository.findAll();
    }

    public Optional<TestPlan> getTestPlanById(Long id) {
        return testPlanRepository.findById(id);
    }

    public TestPlan createTestPlan(TestPlan testPlan) {
        return testPlanRepository.save(testPlan);
    }

    public TestPlan updateTestPlan(Long id, TestPlan testPlan) {
        testPlan.setId(id);
        return testPlanRepository.save(testPlan);
    }

    public void deleteTestPlan(Long id) {
        testPlanRepository.deleteById(id);
    }
}
