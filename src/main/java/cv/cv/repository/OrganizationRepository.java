/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository;

import cv.cv.entities.Organization;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kresna92
 */
@Repository
public interface OrganizationRepository extends CrudRepository<Organization, String> {

    @Query(value = "SELECT * FROM organization WHERE id=?1", nativeQuery = true)
    public Organization findbyid(String id);
    
        @Query(value = "SELECT * FROM organization WHERE employee=?1", nativeQuery = true)
    public List<Organization> findbyempid(String id);
    
        @Query(value = "SELECT COUNT(*) FROM organization", nativeQuery = true)
    public Integer findmax();
}
