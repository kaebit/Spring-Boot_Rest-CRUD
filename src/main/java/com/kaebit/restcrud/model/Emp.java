package com.kaebit.restcrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "emp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empno;

    private String ename;

    private Integer sal;
    
}
