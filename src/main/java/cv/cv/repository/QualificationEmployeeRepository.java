/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository;

import cv.cv.entities.QualificationEmployee;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NINDA
 */
@Repository
public interface QualificationEmployeeRepository extends CrudRepository<QualificationEmployee, String> {

    @Query(value = "SELECT * FROM qualification_employee WHERE id=?1", nativeQuery = true)
    public QualificationEmployee findbyid(String id);

    @Query(value = "SELECT * FROM qualification_employee WHERE employee=?1", nativeQuery = true)
    public List<QualificationEmployee> findbyempid(String id);
    
        @Query(value = "SELECT COUNT(*) FROM qualification_employee", nativeQuery = true)
    public Integer findmax();
}
