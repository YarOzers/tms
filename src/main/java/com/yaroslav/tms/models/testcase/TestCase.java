package com.yaroslav.tms.models.testcase;


import com.yaroslav.tms.models.project.Project;
import com.yaroslav.tms.models.section.Section;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String author;
    private String priority;
    private int duration;
    private Status status;

    @ElementCollection
    private List<Step> preconditions = new ArrayList<>();

    @ElementCollection
    private List<Step> postconditions = new ArrayList<>();

    @ElementCollection
    private List<Step> steps = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
