/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;

import cv.cv.entities.RoleMii;
import cv.cv.repository.RoleRepository;
import cv.cv.repository.serviceinterface.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NINDA
 */

@Service
public class RoleServiceImpl implements ServiceInterface<RoleMii>{
        @Autowired
    RoleRepository roleRepository;

    @Override
    public Iterable<RoleMii> findall() {
        return roleRepository.findAll();
    }

    @Override
    public RoleMii save(RoleMii t) {
        return roleRepository.save(t);
    }

    @Override
    public RoleMii findbyid(String id) {
        return roleRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        roleRepository.delete(findbyid(id));
    }
}
