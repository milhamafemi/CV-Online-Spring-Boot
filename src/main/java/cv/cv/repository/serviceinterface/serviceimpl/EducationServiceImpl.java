/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;

import cv.cv.entities.Education;
import cv.cv.repository.EducationRepository;
import cv.cv.repository.serviceinterface.ServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NINDA
 */
@Service
public class EducationServiceImpl implements ServiceInterface<Education> {

    @Autowired
    EducationRepository educationRepository;

    @Override
    public Iterable<Education> findall() {
        return educationRepository.findAll();
    }

    @Override
    public Education save(Education t) {
        return educationRepository.save(t);
    }

    @Override
    public Education findbyid(String id) {
        return educationRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        educationRepository.delete(findbyid(id));
    }

    public List<Education> findbyempid(String id) {
        return educationRepository.findbyempid(id);
    }

    public String findmaxId() {
        return educationRepository.findmax() + 1 + "";
    }

}
