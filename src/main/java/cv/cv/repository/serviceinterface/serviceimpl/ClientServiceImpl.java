/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;

import cv.cv.entities.Client;
import cv.cv.repository.serviceinterface.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cv.cv.repository.ClientRepository;

/**
 *
 * @author kresna92
 */
@Service
public class ClientServiceImpl implements ServiceInterface<Client> {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Iterable<Client> findall() {
        return clientRepository.findAll();
    }

    @Override
    public Client save(Client t) {
        return clientRepository.save(t);
    }

    @Override
    public Client findbyid(String id) {
        return clientRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        clientRepository.delete(findbyid(id));
    }

}
