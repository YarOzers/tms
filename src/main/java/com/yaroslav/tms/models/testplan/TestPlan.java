package com.yaroslav.tms.models.testplan;

import com.yaroslav.tms.models.project.Project;
import com.yaroslav.tms.models.section.Section;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class TestPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "testPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Section> sections;
}
