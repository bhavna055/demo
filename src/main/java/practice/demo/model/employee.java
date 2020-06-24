package practice.demo.model;


import javax.persistence.*;

@Entity
@Table

public class employee {

    private long id;

    private String empName;

    private String department;

    private String role;
    public employee() {}

    public employee(String empame, String department, String role) {

        this.empName = empName;
        this.department = department;
        this.role = role;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empname) {
        this.empName = empname;
    }

    public void setDepartment(String department){
        this.department = department;
    }
    public String getDepartment() { return this.department; }


    public void setRole(String role) {
        this.role = role;
    }


   // public String getEmpName() {
     //   return this.empname;
   // }

    public String getRole() {
        return this.role;
    }



    @Override
    public String toString() {
        return "Employee [id=" + id + ", empName=" + empName + ", department=" + department + ", role=" + role
                + "]";
    }
}
