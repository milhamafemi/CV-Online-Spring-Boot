/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository;

import cv.cv.entities.ProjectEmployee;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kresna92
 */
@Repository
public interface ProjectEmployeeRepository extends CrudRepository<ProjectEmployee, String> {

    @Query(value = "SELECT * FROM project_employee WHERE id=?1", nativeQuery = true)
    public ProjectEmployee findbyid(String id);

    @Query(value = "SELECT * FROM project_employee WHERE employee=?1", nativeQuery = true)
    public List<ProjectEmployee> findbyempid(String id);
   

    @Query(value = "SELECT * FROM project_employee WHERE project=?1", nativeQuery = true)
    public List<ProjectEmployee> findbyprojid(String id);

    @Query(value = "SELECT MAX(id) FROM project_employee", nativeQuery = true)
    public Integer findmax();
}
