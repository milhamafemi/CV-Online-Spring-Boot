/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository;

import cv.cv.entities.Education;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NINDA
 */
@Repository
public interface EducationRepository extends CrudRepository<Education, String> {

    @Query(value = "SELECT * FROM education WHERE id=?1", nativeQuery = true)
    public Education findbyid(String id);

    @Query(value = "SELECT * FROM education WHERE employee=?1", nativeQuery = true)
    public List<Education> findbyempid(String id);

    @Query(value = "SELECT COUNT(*) FROM education", nativeQuery = true)
    public Integer findmax();
}
