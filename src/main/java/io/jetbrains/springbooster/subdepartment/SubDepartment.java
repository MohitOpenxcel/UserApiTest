package io.jetbrains.springbooster.subdepartment;

import io.jetbrains.springbooster.department.Department;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;

@RestController
@Entity
@Table(name = "sub_department")
public class SubDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "sub_dept_id" , insertable = false , updatable = false)
    private int sub_dept_id;

    @ManyToOne(cascade= CascadeType.ALL ,targetEntity = Department.class)
    @JoinColumn(name = "dept_id")
    private Department department;

    @Column(name = "sub_department_name")
    private String subDepartmentName;

    SubDepartment(){

    }

    public SubDepartment(Department department, String subDepartmentName) {
        this.department = department;
        this.subDepartmentName = subDepartmentName;
    }
}
