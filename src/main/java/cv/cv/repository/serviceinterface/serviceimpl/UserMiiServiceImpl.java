/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;

import cv.cv.entities.UserMii;
import cv.cv.repository.UserMiiRepository;
import cv.cv.repository.serviceinterface.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NINDA
 */
@Service
public class UserMiiServiceImpl implements ServiceInterface<UserMii> {

    @Autowired
    UserMiiRepository userRepository;

    @Override
    public Iterable<UserMii> findall() {
        return userRepository.findAll();
    }

    @Override
    public UserMii save(UserMii t) {
        return userRepository.save(t);
    }

    @Override
    public UserMii findbyid(String id) {
        return userRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        userRepository.delete(findbyid(id));
    }

    public UserMii findbyemail(String email) {
        return userRepository.findbyemail(email);
    }

    public UserMii findbytoken(String token) {
        return userRepository.findbytoken(token);
    }

    public void updatePassword(String password, String userId) {
        userRepository.updatePassword(password, userId);
    }
}
