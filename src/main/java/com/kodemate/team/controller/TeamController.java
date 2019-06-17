package com.kodemate.team.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodemate.team.model.Employee;
import com.kodemate.team.model.User;

@CrossOrigin()
@RestController
@RequestMapping({ "/employees" })
public class TeamController {

    private static final Logger logger = LoggerFactory.getLogger(TeamController.class);

    private List<Employee> employees = createList();

    @GetMapping(produces = "application/json")
    public List<Employee> firstPage() {
        logger.info("first page data: " + employees);
        return employees;
    }

    @GetMapping(produces = "application/json")
    @RequestMapping({ "/validateLogin" })
    public User validateLogin() {
        logger.info("login verification");
        return new User("User successfully authenticated");
    }

    @DeleteMapping(path = { "/{id}" })
    public Employee delete(@PathVariable("id") String id) {
        Employee deletedEmp = null;
        for (Employee emp : employees) {
            if (emp.getEmpId().equals(id)) {
                employees.remove(emp);
                deletedEmp = emp;
                break;
            }
        }
        logger.info("team member deleted: " + deletedEmp);
        return deletedEmp;
    }

    @PostMapping
    public Employee create(@RequestBody Employee user) {
        employees.add(user);
        logger.info("team member created: " + user);
        return user;
    }

    private static List<Employee> createList() {
        List<Employee> tempEmployees = new ArrayList<>();
        Employee emp1 = new Employee();
        emp1.setName("Edward Biton");
        emp1.setDesignation("Technical Manager");
        emp1.setEmpId("qubz1");
        emp1.setSalary(3000000);
        emp1.setCompany("UST Global");
        emp1.setEmailId("edward.biton@ust-global.com");

        Employee emp2 = new Employee();
        emp2.setName("Anand Govindan");
        emp2.setDesignation("Project Manager");
        emp2.setEmpId("qubz2");
        emp2.setSalary(3000000);
        emp2.setCompany("UST Global");
        emp2.setEmailId("anand.govindan@ust-global.com");

        tempEmployees.add(emp1);
        tempEmployees.add(emp2);
        logger.info("team member list: " + tempEmployees);
        return tempEmployees;
    }
}