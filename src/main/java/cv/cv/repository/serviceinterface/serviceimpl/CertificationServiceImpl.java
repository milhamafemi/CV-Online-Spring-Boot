/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;

import cv.cv.entities.Certification;
import cv.cv.repository.CertificationRepository;
import cv.cv.repository.serviceinterface.ServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NINDA
 */
@Service
public class CertificationServiceImpl implements ServiceInterface<Certification> {

    @Autowired
    CertificationRepository certificationRepository;

    @Override
    public Iterable<Certification> findall() {
        return certificationRepository.findAll();
    }

    @Override
    public Certification save(Certification t) {
        return certificationRepository.save(t);
    }

    @Override
    public Certification findbyid(String id) {
        return certificationRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        certificationRepository.delete(findbyid(id));
    }

    public List<Certification> findbyempid(String id) {
        return certificationRepository.findbyempid(id);
    }

    public String findmaxId() {
        return certificationRepository.findmax() + 1 + "";
    }
}
