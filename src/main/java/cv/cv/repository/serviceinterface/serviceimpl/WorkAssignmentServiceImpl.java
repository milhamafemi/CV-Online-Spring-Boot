/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;

import cv.cv.entities.WorkAssignment;
import cv.cv.repository.ClientRepository;
import cv.cv.repository.WorkAssignmentRepository;
import cv.cv.repository.serviceinterface.ServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NINDA
 */
@Service
public class WorkAssignmentServiceImpl implements ServiceInterface<WorkAssignment> {

    @Autowired
    WorkAssignmentRepository workRepository;

    @Override
    public Iterable<WorkAssignment> findall() {
        return workRepository.findAll();
    }

    @Override
    public WorkAssignment save(WorkAssignment t) {
        return workRepository.save(t);
    }

    @Override
    public WorkAssignment findbyid(String id) {
        return workRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        workRepository.delete(findbyid(id));
    }

    public List<WorkAssignment> findbyempid(String id) {
        return workRepository.findbyempid(id);
    }

    public String findmaxId() {
        return workRepository.findmax() + 1 + "";
    }

}
