package com.example.employeedata.dto;

import java.util.List;

public class ProjectDTO {

    private Long projectId;
    private String projectName;
    private List<String> employeeIds;

    public ProjectDTO() {}

    public ProjectDTO(Long projectId, String projectName, List<String> employeeIds) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.employeeIds = employeeIds;
    }

    // Getters and Setters
    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<String> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(List<String> employeeIds) {
        this.employeeIds = employeeIds;
    }
}
