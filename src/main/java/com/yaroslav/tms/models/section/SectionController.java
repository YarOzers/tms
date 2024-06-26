package com.yaroslav.tms.models.section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sections")
public class SectionController {
    @Autowired
    private SectionService sectionService;

    @GetMapping
    public List<Section> getAllSections() {
        return sectionService.getAllSections();
    }

    @GetMapping("/{id}")
    public Optional<Section> getSectionById(@PathVariable Long id) {
        return sectionService.getSectionById(id);
    }

    @PostMapping
    public Section createSection(@RequestBody Section section) {
        return sectionService.createSection(section);
    }

    @PutMapping("/{id}")
    public Section updateSection(@PathVariable Long id, @RequestBody Section section) {
        return sectionService.updateSection(id, section);
    }

    @DeleteMapping("/{id}")
    public void deleteSection(@PathVariable Long id) {
        sectionService.deleteSection(id);
    }
}
