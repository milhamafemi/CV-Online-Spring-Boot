/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;

import cv.cv.entities.ProjectEmployee;
import cv.cv.repository.ProjectEmployeeRepository;
import cv.cv.repository.serviceinterface.ServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NINDA
 */
@Service
public class ProjectEmployeeServiceImpl implements ServiceInterface<ProjectEmployee> {

    @Autowired
    ProjectEmployeeRepository peRepository;

    @Override
    public Iterable<ProjectEmployee> findall() {
        return peRepository.findAll();
    }

    @Override
    public ProjectEmployee save(ProjectEmployee t) {
        return peRepository.save(t);
    }

    @Override
    public ProjectEmployee findbyid(String id) {
        return peRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        peRepository.delete(findbyid(id));
    }

    public List<ProjectEmployee> findbyempid(String id) {
        return peRepository.findbyempid(id);
    }

    public List<ProjectEmployee> findbyprojid(String id) {
        return peRepository.findbyprojid(id);
    }

    public String findmaxId() {
        return peRepository.findmax() + 1 + "";
    }

}
