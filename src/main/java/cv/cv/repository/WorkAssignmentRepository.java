/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository;

import cv.cv.entities.WorkAssignment;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NINDA
 */
@Repository
public interface WorkAssignmentRepository extends CrudRepository<WorkAssignment, String> {

    @Query(value = "SELECT * FROM work_assignment WHERE id=?1", nativeQuery = true)
    public WorkAssignment findbyid(String id);

    @Query(value = "SELECT * FROM work_assignment WHERE employee=?1", nativeQuery = true)
    public List<WorkAssignment> findbyempid(String id);
    
        @Query(value = "SELECT COUNT(*) FROM work_assignment", nativeQuery = true)
    public Integer findmax();
}
