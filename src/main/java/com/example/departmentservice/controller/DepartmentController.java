package com.example.departmentservice.controller;

import com.example.departmentservice.dao.DepartmentRepository;
import com.example.departmentservice.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Value("${uri}")
    private String uri;

    @Autowired
    public RestTemplate restTemplate;

    @Autowired
    public DepartmentRepository repository;

    @PostMapping("/saveDepartment")
    public String saveDepartment(@RequestBody Department department){
        repository.save(department);
        return "Details saved...";
    }

    @GetMapping("/getDetails")
    public List<Department>getAll(){
        return repository.findAll();
    }
    @GetMapping("/getDetails/{departmentId}")
    public Optional<Department> getDetailsById(@PathVariable Long departmentId){
        return repository.findById(departmentId);
    }
    @GetMapping("/employeeName")
    public String EmployeeName(){

    String response=restTemplate.exchange(uri , HttpMethod.GET,null,String.class).getBody();
    return response;
}
}