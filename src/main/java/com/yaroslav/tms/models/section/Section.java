package com.yaroslav.tms.models.section;

import com.yaroslav.tms.models.project.Project;
import com.yaroslav.tms.models.testcase.TestCase;
import com.yaroslav.tms.models.testplan.TestPlan;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_section_id")
    private Section parentSection;

    @OneToMany(mappedBy = "parentSection", cascade = CascadeType.ALL)
    private List<Section> childSections = new ArrayList<>();

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private List<TestCase> testCases = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
