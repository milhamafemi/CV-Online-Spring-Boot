/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository;

import cv.cv.entities.Experience;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kresna92
 */
@Repository
public interface ExperienceRepository extends CrudRepository<Experience, String> {

    @Query(value = "SELECT * FROM experience WHERE id=?1", nativeQuery = true)
    public Experience findbyid(String id);

    @Query(value = "SELECT * FROM experience WHERE employee=?1", nativeQuery = true)
    public List<Experience> findbyempid(String id);
    
        @Query(value = "SELECT COUNT(*) FROM experience", nativeQuery = true)
    public Integer findmax();
}
