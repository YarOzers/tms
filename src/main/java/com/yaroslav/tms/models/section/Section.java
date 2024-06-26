package com.yaroslav.tms.models.section;

import com.yaroslav.tms.models.test.TestCase;
import com.yaroslav.tms.models.testplan.TestPlan;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "test_plan_id")
    private TestPlan testPlan;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestCase> testCases;
}
