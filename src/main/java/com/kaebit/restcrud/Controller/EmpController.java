package com.kaebit.restcrud.Controller;

import com.kaebit.restcrud.model.Emp;
import com.kaebit.restcrud.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<Emp>> getAllEmps() {
        List<Emp> emps = empService.findAll();
        return new ResponseEntity<List<Emp>>(emps, HttpStatus.OK);
    }

    @GetMapping(value = "/{empno}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Emp> getOneEmp(@PathVariable("empno") int empno) {
        return new ResponseEntity<Emp>(empService.findById(empno), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{empno}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteEmp(@PathVariable("empno") int empno) {
        empService.deleteById(empno);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping(value = "/{empno}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Emp> updateEmp(@PathVariable("empno") int empno, @RequestBody Emp emp) {
        empService.updateById(empno, emp);
        return new ResponseEntity<Emp>(emp, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Emp> save(@RequestBody Emp emp) {
        empService.save(emp);
        return new ResponseEntity<Emp>(emp, HttpStatus.OK);
    }

    @GetMapping(value = "/{sal1}/{sal2}")
    public ResponseEntity<List<Emp>> getEmpBySalBetween(@PathVariable("sal1") int sal1, @PathVariable("sal2") int sal2) {
        List<Emp> emps = empService.findBySalBetween(sal1, sal2);
        return new ResponseEntity<List<Emp>>(emps, HttpStatus.OK);
    }
}
