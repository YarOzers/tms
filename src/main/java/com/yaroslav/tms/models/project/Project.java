package com.yaroslav.tms.models.project;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yaroslav.tms.models.section.Section;
import com.yaroslav.tms.models.testcase.TestCase;
import com.yaroslav.tms.models.testplan.TestPlan;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestCase> testCases = new ArrayList<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Section> sections = new ArrayList<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<TestPlan> testPlans = new ArrayList<>();

}
