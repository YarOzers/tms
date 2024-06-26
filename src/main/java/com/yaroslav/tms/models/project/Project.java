package com.yaroslav.tms.models.project;

import com.yaroslav.tms.models.test.TestCase;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Project {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
