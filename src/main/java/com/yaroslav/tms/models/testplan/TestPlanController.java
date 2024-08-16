package com.yaroslav.tms.models.testplan;

import com.yaroslav.tms.models.project.Project;
import com.yaroslav.tms.models.project.ProjectService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects/{projectId}/testplans") // Изменен маршрут здесь
@AllArgsConstructor
public class TestPlanController {

    private final TestPlanService testPlanService;

    private final ProjectService projectService;



    @GetMapping()
    public List<TestPlan> getAllTestPlans(@PathVariable("projectId") Long projectId) {
        return testPlanService.getTestPlansByProjectId(projectId);
    }

    @GetMapping("/{id}")
    public TestPlan getTestPlanById(@PathVariable Long id) {
        return testPlanService.getTestPlanById(id);
    }

    @PostMapping("/create")
    public TestPlan createTestPlan(@PathVariable("projectId") Long projectId, @RequestBody TestPlan testPlan) {
        Project project = projectService.getProjectById(projectId);
        testPlan.setProject(project); // Установка проекта в тестплан
        return testPlanService.saveTestPlan(testPlan);
    }

    @PutMapping("/{id}")
    public TestPlan updateTestPlan(@PathVariable Long id, @RequestBody TestPlan testPlan) {
        testPlan.setId(id);
        return testPlanService.saveTestPlan(testPlan);
    }

    @DeleteMapping("/{id}")
    public void deleteTestPlan(@PathVariable Long id) {
        testPlanService.deleteTestPlan(id);
    }
}
