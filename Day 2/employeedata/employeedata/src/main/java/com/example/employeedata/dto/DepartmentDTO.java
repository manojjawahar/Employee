package com.example.employeedata.dto;

import java.util.List;

public class DepartmentDTO {
    private Long id;
    private String name;
    private List<String> employeeIds;

    public DepartmentDTO() {}

    public DepartmentDTO(Long id, String name, List<String> employeeIds) {
        this.id = id;
        this.name = name;
        this.employeeIds = employeeIds;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEmployeeIds() {
        return employeeIds;
    }
    public void setEmployeeIds(List<String> employeeIds) {
        this.employeeIds = employeeIds;
    }
}
