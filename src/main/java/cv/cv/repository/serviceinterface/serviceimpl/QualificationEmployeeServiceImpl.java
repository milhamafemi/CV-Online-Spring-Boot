/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;

import cv.cv.entities.QualificationEmployee;
import cv.cv.repository.QualificationEmployeeRepository;
import cv.cv.repository.serviceinterface.ServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NINDA
 */
@Service
public class QualificationEmployeeServiceImpl implements ServiceInterface<QualificationEmployee> {

    @Autowired
    QualificationEmployeeRepository qeRepository;

    @Override
    public Iterable<QualificationEmployee> findall() {
        return qeRepository.findAll();
    }

    @Override
    public QualificationEmployee save(QualificationEmployee t) {
        return qeRepository.save(t);
    }

    @Override
    public QualificationEmployee findbyid(String id) {
        return qeRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        qeRepository.delete(findbyid(id));
    }

    public List<QualificationEmployee> findbyempid(String id) {
        return qeRepository.findbyempid(id);
    }

    public String findmaxId() {
        return qeRepository.findmax() + 1 + "";
    }

}
