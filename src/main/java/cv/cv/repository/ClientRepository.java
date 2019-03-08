/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository;

import cv.cv.entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kresna92
 */

@Repository
public interface ClientRepository extends CrudRepository<Client, String>{
    @Query(value = "SELECT * FROM client WHERE id=?1",nativeQuery = true)
    public Client findbyid(String id);
    
}
