package practice.demo.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import practice.demo.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {



   @Query("SELECT e FROM Employee e WHERE LOWER(e.department) = LOWER(:department)")
   public Page<Employee> findByDepartment(@Param("department") String department, Pageable pageable);



}