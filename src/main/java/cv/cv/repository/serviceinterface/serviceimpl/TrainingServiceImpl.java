/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;

import cv.cv.entities.Training;
import cv.cv.repository.TrainingRepository;
import cv.cv.repository.serviceinterface.ServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NINDA
 */
@Service
public class TrainingServiceImpl implements ServiceInterface<Training> {

    @Autowired
    TrainingRepository trainingRepository;

    @Override
    public Iterable<Training> findall() {
        return trainingRepository.findAll();
    }

    @Override
    public Training save(Training t) {
        return trainingRepository.save(t);
    }

    @Override
    public Training findbyid(String id) {
        return trainingRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        trainingRepository.delete(findbyid(id));
    }

    public List<Training> findbyempid(String id) {
        return trainingRepository.findbyempid(id);
    }

    public String findmaxId() {
        return trainingRepository.findmax() + 1 + "";
    }

}
