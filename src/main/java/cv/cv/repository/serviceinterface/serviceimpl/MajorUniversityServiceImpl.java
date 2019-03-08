/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;

import cv.cv.entities.MajorUniversity;
import cv.cv.repository.MajorUniversityRepository;
import cv.cv.repository.serviceinterface.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NINDA
 */
@Service
public class MajorUniversityServiceImpl implements ServiceInterface<MajorUniversity> {

    @Autowired
    MajorUniversityRepository majorUniversityRepository;

    @Override
    public Iterable<MajorUniversity> findall() {
        return majorUniversityRepository.findAll();
    }

    @Override
    public MajorUniversity save(MajorUniversity t) {
        return majorUniversityRepository.save(t);
    }

    @Override
    public MajorUniversity findbyid(String id) {
        return majorUniversityRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        majorUniversityRepository.delete(findbyid(id));
    }
}
