/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository;

import cv.cv.entities.UserMii;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NINDA
 */

@Repository
public interface UserMiiRepository extends CrudRepository<UserMii, String> {

    @Query(value = "SELECT * FROM user_mii WHERE id=?1", nativeQuery = true)
    public UserMii findbyid(String id);
    @Query(value = "SELECT * FROM user_mii WHERE email=?1", nativeQuery = true)
    public UserMii findbyemail(String email);
    @Query(value = "SELECT * FROM user_mii WHERE token=?1", nativeQuery = true)
    public UserMii findbytoken(String token);
    @Modifying
    @Query(value = "UPDATE user_mii SET password =?1 WHERE id =?2", nativeQuery = true)
    void updatePassword(String password,String id);
}
