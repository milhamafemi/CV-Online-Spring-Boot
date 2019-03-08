/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;

import cv.cv.entities.Project;
import cv.cv.repository.serviceinterface.ServiceInterface;
import cv.cv.repository.ProjectRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kresna92
 */
@Service
public class ProjectServiceImpl implements ServiceInterface<Project>{
    
    @Autowired
    private ProjectRepository projectRepository;
    
    @Override
    public Iterable<Project> findall() {
        return projectRepository.findAll();
    }

    @Override
    public Project save(Project p) {
        return projectRepository.save(p);
    }

    @Override
    public Project findbyid(String id) {
       return projectRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        projectRepository.delete(findbyid(id));}
    
    public List<Project> findbyclientid(String id){
        return projectRepository.findbyclientid(id);
    }
}
