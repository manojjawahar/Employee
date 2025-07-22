package com.example.employeedata.controller;

import com.example.employeedata.dto.ProjectDTO;
import com.example.employeedata.model.Project;
import com.example.employeedata.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // 🔁 Create Project
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody @Valid Project project) {
        Project created = projectService.create(project);
        return ResponseEntity.status(201).body(created);
    }

    // 📋 Get All Projects
    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAll();
        return ResponseEntity.ok(projects);
    }

    // 🔍 Get Project by ID with employee IDs
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id) {
        ProjectDTO dto = projectService.getProjectDTOById(id);
        return ResponseEntity.ok(dto);
    }

    // ✏️ Update Project
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody @Valid Project project) {
        Project updated = projectService.update(id, project);
        return ResponseEntity.ok(updated);
    }

    // ❌ Delete Project
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
