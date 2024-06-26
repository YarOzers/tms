package com.yaroslav.tms.models.testplan;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/testplans")
@AllArgsConstructor
@NoArgsConstructor
//@PreAuthorize("hasAnyAuthority('ROLE_user')")
public class TestPlanController {

    @Autowired
    private TestPlanService testPlanService;

    @GetMapping
    public List<TestPlan> getAllTestPlans() {
        return testPlanService.getAllTestPlans();
    }

    @GetMapping("/{id}")
    public Optional<TestPlan> getTestPlanById(@PathVariable Long id) {
        return testPlanService.getTestPlanById(id);
    }

    @PostMapping
    public TestPlan createTestPlan(@RequestBody TestPlan testPlan) {
        return testPlanService.createTestPlan(testPlan);
    }

    @PutMapping("/{id}")
    public TestPlan updateTestPlan(@PathVariable Long id, @RequestBody TestPlan testPlan) {
        return testPlanService.updateTestPlan(id, testPlan);
    }

    @DeleteMapping("/{id}")
    public void deleteTestPlan(@PathVariable Long id) {
        testPlanService.deleteTestPlan(id);
    }
}
