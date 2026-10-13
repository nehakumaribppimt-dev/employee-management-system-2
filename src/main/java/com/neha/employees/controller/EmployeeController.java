package com.neha.employees.controller;

import com.neha.employees.model.Employee;
import com.neha.employees.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeRepository repo;

    public EmployeeController(EmployeeRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Employee> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Employee one(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee add(@RequestBody Employee item) {
        return repo.save(item);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee item) {
        Employee old = one(id);
        old.setFirstName(item.getFirstName());
        old.setLastName(item.getLastName());
        old.setEmail(item.getEmail());
        old.setDepartment(item.getDepartment());
        old.setSalary(item.getSalary());
        return repo.save(old);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        if (!repo.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        repo.deleteById(id);
    }
}
