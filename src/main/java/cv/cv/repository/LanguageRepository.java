/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository;

import cv.cv.entities.Language;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NINDA
 */
@Repository
public interface LanguageRepository extends CrudRepository<Language, String> {

    @Query(value = "SELECT * FROM foreignlanguage WHERE id=?1", nativeQuery = true)
    public Language findbyid(String id);
}
