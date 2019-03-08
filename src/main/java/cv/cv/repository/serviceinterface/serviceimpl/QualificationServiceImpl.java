/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;

import cv.cv.entities.Qualification;
import cv.cv.repository.QualificationRepository;
import cv.cv.repository.serviceinterface.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NINDA
 */

@Service
public class QualificationServiceImpl implements ServiceInterface<Qualification>{
        
    @Autowired
    QualificationRepository qualificationRepository;

    @Override
    public Iterable<Qualification> findall() {
        return qualificationRepository.findAll();
    }

    @Override
    public Qualification save(Qualification t) {
        return qualificationRepository.save(t);
    }

    @Override
    public Qualification findbyid(String id) {
        return qualificationRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        qualificationRepository.delete(findbyid(id));
    }
}
