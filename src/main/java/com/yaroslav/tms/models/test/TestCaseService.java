package com.yaroslav.tms.models.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestCaseService {
    private final TestCaseRepository testCaseRepository;

    public TestCaseService(TestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    public List<TestCase> getAllTestCases() {
        return testCaseRepository.findAll();
    }

    public Optional<TestCase> getTestCaseById(Long id) {
        return testCaseRepository.findById(id);
    }

    public TestCase createTestCase(TestCase testCase) {
        return testCaseRepository.save(testCase);
    }

    public TestCase updateTestCase(Long id, TestCase testCase) {
        testCase.setId(id);
        return testCaseRepository.save(testCase);
    }

    public void deleteTestCase(Long id) {
        testCaseRepository.deleteById(id);
    }
}
