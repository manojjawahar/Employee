package com.example.employeedata.controller;

import com.example.employeedata.dto.CreateEmployeeDTO;
import com.example.employeedata.dto.EmployeeDTO;
import com.example.employeedata.dto.GetEmployeeDTO;
import com.example.employeedata.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    // 🔁 Create new employee
    @PostMapping
    public EmployeeDTO create(@RequestBody @Valid CreateEmployeeDTO dto) {
        return service.create(dto);
    }

    // 📋 Get all employees (simple list)
    @GetMapping
    public List<EmployeeDTO> getAll() {
        return service.getAll();
    }

    // 🔍 Get employee by empId with department and profile details
    @GetMapping("/{empId}")
    public ResponseEntity<GetEmployeeDTO> getByEmpId(@PathVariable String empId) {
        GetEmployeeDTO dto = service.getByEmpId(empId);
        return ResponseEntity.ok(dto);
    }

    // ✏️ Update employee (including department)
    @PutMapping("/{empId}")
    public EmployeeDTO update(@PathVariable String empId, @RequestBody @Valid EmployeeDTO dto) {
        return service.update(empId, dto);
    }

    // ❌ Delete employee
    @DeleteMapping("/{empId}")
    public void delete(@PathVariable String empId) {
        service.delete(empId);
    }

    // ✅ Assign project to employee (uses String projectId)
    @PostMapping("/{empId}/projects/{projectId}")
    public ResponseEntity<String> assignProjectToEmployee(
            @PathVariable String empId,
            @PathVariable Long projectId) {
        service.assignProject(empId, projectId);
        return ResponseEntity.ok("Project assigned successfully.");
    }

    // ✅ Remove project from employee (also uses String projectId)
    @DeleteMapping("/{empId}/projects/{projectId}")
    public ResponseEntity<String> removeProjectFromEmployee(
            @PathVariable String empId,
            @PathVariable Long projectId) {
        service.removeProject(empId, projectId);
        return ResponseEntity.ok("Project removed successfully.");
    }
}
