package io.jetbrains.springbooster.department;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @Column(name = "dept_id")
    private int dept_id;

    @Column(name = "lang_id")
    private int lang_id;

    @Column(name = "departmentName")
    private String departmentName;

    public Department(){}

    public Department(int dept_id,int lang_id, String departmentName) {
        this.dept_id=dept_id;
        this.lang_id = lang_id;
        this.departmentName = departmentName;
    }

    public Department(String departmentName , int lang_id) {
        this.departmentName = departmentName;
        this.lang_id = lang_id;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getLang_id() {
        return lang_id;
    }

    public void setLang_id(int lang_id) {
        this.lang_id = lang_id;
    }
}
