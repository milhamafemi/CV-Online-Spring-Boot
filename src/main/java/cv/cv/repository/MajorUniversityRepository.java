/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository;

import cv.cv.entities.MajorUniversity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NINDA
 */
@Repository
public interface MajorUniversityRepository extends CrudRepository<MajorUniversity, String> {

    @Query(value = "SELECT * FROM major_university WHERE id=?1", nativeQuery = true)
    public MajorUniversity findbyid(String id);
}
