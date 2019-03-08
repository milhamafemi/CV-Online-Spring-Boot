/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;

import cv.cv.entities.Achievement;
import cv.cv.repository.AchievementRepository;
import cv.cv.repository.serviceinterface.ServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NINDA
 */

@Service
public class AchievementServiceImpl implements ServiceInterface<Achievement>{
        @Autowired
        AchievementRepository achievementRepository;

    @Override
    public Iterable<Achievement> findall() {
        return achievementRepository.findAll();
    }

    @Override
    public Achievement save(Achievement t) {
        return achievementRepository.save(t);
    }

    @Override
    public Achievement findbyid(String id) {
        return achievementRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        achievementRepository.delete(findbyid(id));
    }
    
        public List<Achievement> findbyempid(String id) {
        return achievementRepository.findbyempid(id);
    }

    public String findmaxId() {
        return achievementRepository.findmax() + 1 + "";
    }

}
