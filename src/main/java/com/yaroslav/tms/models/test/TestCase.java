package com.yaroslav.tms.models.test;


import com.yaroslav.tms.models.section.Section;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;
}
