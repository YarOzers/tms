package com.yaroslav.tms.models.test;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tests")
@AllArgsConstructor
@NoArgsConstructor
//@PreAuthorize("hasAnyAuthority('ROLE_user')")
public class TestCaseController {

    private TestCaseService testCaseService;

    @GetMapping
    public List<TestCase> getAllTestCases() {
        return testCaseService.getAllTestCases();
    }

    @GetMapping("/{id}")
    public Optional<TestCase> getTestCaseById(@PathVariable Long id) {
        return testCaseService.getTestCaseById(id);
    }

    @PostMapping
    public TestCase createTestCase(@RequestBody TestCase testCase) {
        return testCaseService.createTestCase(testCase);
    }

    @PutMapping("/{id}")
    public TestCase updateTestCase(@PathVariable Long id, @RequestBody TestCase testCase) {
        return testCaseService.updateTestCase(id, testCase);
    }

    @DeleteMapping("/{id}")
    public void deleteTestCase(@PathVariable Long id) {
        testCaseService.deleteTestCase(id);
    }
}
