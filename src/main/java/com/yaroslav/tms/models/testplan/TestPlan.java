package com.yaroslav.tms.models.testplan;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.yaroslav.tms.models.project.Project;
import com.yaroslav.tms.models.testcase.TestCase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestPlan {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @NonNull
    @JsonBackReference
    private Project project;

    @ManyToMany
    @JoinTable(
            name = "testplan_testcases",
            joinColumns = @JoinColumn(name = "testplan_id"),
            inverseJoinColumns = @JoinColumn(name = "testcase_id")
    )
    private List<TestCase> testCases = new ArrayList<>();

}
