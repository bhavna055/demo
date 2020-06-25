package practice.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import practice.demo.model.employee;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<employee, Long> {


   @Query("SELECT e FROM employee e WHERE LOWER(e.department) = LOWER(:department)")
   public List<employee> findByDepartment(@Param("department") String department);



}