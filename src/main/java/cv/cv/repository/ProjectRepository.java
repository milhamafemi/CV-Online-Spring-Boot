/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository;

import cv.cv.entities.Project;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kresna92
 */
@Repository
public interface ProjectRepository extends CrudRepository<Project, String> {

    @Query(value = "SELECT * FROM project WHERE id=?1", nativeQuery = true)
    public Project findbyid(String id);

    @Query(value = "SELECT * FROM project WHERE client=?1", nativeQuery = true)
    public List<Project> findbyclientid(String id);
}
