/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;

import cv.cv.entities.Experience;
import cv.cv.repository.ExperienceRepository;
import cv.cv.repository.serviceinterface.ServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NINDA
 */
@Service
public class ExperienceServiceImpl implements ServiceInterface<Experience> {

    @Autowired
    ExperienceRepository experienceRepository;

    @Override
    public Iterable<Experience> findall() {
        return experienceRepository.findAll();
    }

    @Override
    public Experience save(Experience t) {
        return experienceRepository.save(t);
    }

    @Override
    public Experience findbyid(String id) {
        return experienceRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        experienceRepository.delete(findbyid(id));
    }

    public List<Experience> findbyempid(String id) {
        return experienceRepository.findbyempid(id);
    }

    public String findmaxId() {
        return experienceRepository.findmax() + 1 + "";
    }

}
