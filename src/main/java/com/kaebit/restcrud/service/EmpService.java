package com.kaebit.restcrud.service;

import com.kaebit.restcrud.model.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> findAll();

    Emp findById(int empno);

    void deleteById(int empno);

    Emp save(Emp emp);

    List<Emp> findBySalBetween(int sal1, int sal2);

    void updateById(int empno, Emp emp);
}
