package com.kaebit.restcrud.repository;

import com.kaebit.restcrud.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

    List<Emp> findBySalBetween(int sal1, int sal2);
}
