/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository;

import org.springframework.data.repository.CrudRepository;
import cv.cv.entities.LanguageEmployee;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kresna92
 */
@Repository
public interface LanguageEmployeeRepository extends CrudRepository<LanguageEmployee, Object> {

    @Query(value = "SELECT * FROM language_employee WHERE id=?1", nativeQuery = true)
    public LanguageEmployee findbyid(String id);

    @Query(value = "SELECT * FROM language_employee WHERE employee=?1", nativeQuery = true)
    public List<LanguageEmployee> findbyempid(String id);
    
        @Query(value = "SELECT MAX(id) FROM language_employee", nativeQuery = true)
    public Integer findmax();
}
