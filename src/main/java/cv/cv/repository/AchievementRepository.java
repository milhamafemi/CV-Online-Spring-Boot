/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository;

import cv.cv.entities.Achievement;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NINDA
 */

@Repository
public interface AchievementRepository extends CrudRepository<Achievement, String> {

    @Query(value = "SELECT * FROM achievement WHERE id=?1", nativeQuery = true)
    public Achievement findbyid(String id);
    
    @Query(value = "SELECT * FROM achievement WHERE employee=?1", nativeQuery = true)
    public List<Achievement> findbyempid(String id);
    
    @Query(value = "SELECT COUNT(*) FROM achievement", nativeQuery = true)
    public Integer findmax();
}
