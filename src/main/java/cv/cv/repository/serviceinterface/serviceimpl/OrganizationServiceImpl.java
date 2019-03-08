/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;

import cv.cv.entities.Organization;
import cv.cv.repository.OrganizationRepository;
import cv.cv.repository.serviceinterface.ServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NINDA
 */
@Service
public class OrganizationServiceImpl implements ServiceInterface<Organization> {

    @Autowired
    OrganizationRepository organizationRepository;

    @Override
    public Iterable<Organization> findall() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization save(Organization t) {
        return organizationRepository.save(t);
    }

    @Override
    public Organization findbyid(String id) {
        return organizationRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        organizationRepository.delete(findbyid(id));
    }

    public List<Organization> findbyempid(String id) {
        return organizationRepository.findbyempid(id);
    }

    public String findmaxId() {
        return organizationRepository.findmax() + 1 + "";
    }

}
