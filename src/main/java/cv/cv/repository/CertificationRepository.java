/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository;

import cv.cv.entities.Certification;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NINDA
 */
@Repository
public interface CertificationRepository extends CrudRepository<Certification, String> {

    @Query(value = "SELECT * FROM certification WHERE id=?1", nativeQuery = true)
    public Certification findbyid(String id);

    @Query(value = "SELECT * FROM certification WHERE employee=?1", nativeQuery = true)
    public List<Certification> findbyempid(String id);

    @Query(value = "SELECT COUNT(*) FROM certification", nativeQuery = true)
    public Integer findmax();
}
