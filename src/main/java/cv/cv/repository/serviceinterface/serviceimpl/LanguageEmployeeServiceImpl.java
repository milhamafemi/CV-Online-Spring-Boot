/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;

import cv.cv.entities.LanguageEmployee;
import cv.cv.repository.LanguageEmployeeRepository;
import cv.cv.repository.serviceinterface.ServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NINDA
 */
@Service
public class LanguageEmployeeServiceImpl implements ServiceInterface<LanguageEmployee> {

    @Autowired
    LanguageEmployeeRepository leRepository;

    @Override
    public Iterable<LanguageEmployee> findall() {
        return leRepository.findAll();
    }

    @Override
    public LanguageEmployee save(LanguageEmployee t) {
        return leRepository.save(t);
    }

    @Override
    public LanguageEmployee findbyid(String id) {
        return leRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        leRepository.delete(findbyid(id));
    }

    public List<LanguageEmployee> findbyempid(String id) {
        return leRepository.findbyempid(id);
    }

    public String findmaxId() {
        return leRepository.findmax() + 1 + "";
    }

}
