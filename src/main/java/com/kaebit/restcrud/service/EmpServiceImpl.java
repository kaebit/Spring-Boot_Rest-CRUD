package com.kaebit.restcrud.service;

import com.kaebit.restcrud.Exception.ResourceNotFoundException;
import com.kaebit.restcrud.model.Emp;
import com.kaebit.restcrud.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

class A {
    String id;
    String password;
    A(String id, String password) {
        this.id = id;
        this.password = password;
    }
}

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpRepository empRepository;

    @Override
    public List<Emp> findAll() {
        List<Emp> emps = new ArrayList<>();
        empRepository.findAll().forEach(val -> emps.add(val));
        return emps;
    }

    @Override
    public Emp findById(int empno) {
        Emp emp = empRepository.findById(empno).orElseThrow(() -> new ResourceNotFoundException("Emp", "empno", empno));
        return emp;
    }

    @Override
    public void deleteById(int empno) {
        empRepository.deleteById(empno);
    }

    @Override
    public Emp save(Emp emp) {
        empRepository.save(emp);
        return emp;
    }

    @Override
    public List<Emp> findBySalBetween(int sal1, int sal2) {
        List<Emp> emps = empRepository.findBySalBetween(sal1, sal2);
        System.out.println(emps.size() + ">>>>>>>>>>>>>>>" + sal1 + sal2);
        if (emps.size() > 0)
            return emps;
        else
            return null;
    }

    @Override
    public void updateById(int empno, Emp emp) {
        Emp e = empRepository.findById(empno).orElseThrow(() -> new ResourceNotFoundException("Emp", "empno", empno));
        e.setEname(emp.getEname());
        e.setSal(emp.getSal());

        empRepository.save(e);
    }
}
