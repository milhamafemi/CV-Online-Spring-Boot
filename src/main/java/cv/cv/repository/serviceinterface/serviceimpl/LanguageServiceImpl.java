/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;

import cv.cv.entities.Language;
import cv.cv.repository.serviceinterface.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cv.cv.repository.LanguageRepository;

/**
 *
 * @author NINDA
 */

@Service
public class LanguageServiceImpl implements ServiceInterface<Language>{
    
    @Autowired
    LanguageRepository languageRepository;

    @Override
    public Iterable<Language> findall() {
        return languageRepository.findAll();
    }

    @Override
    public Language save(Language t) {
        return languageRepository.save(t);
    }

    @Override
    public Language findbyid(String id) {
        return languageRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        languageRepository.delete(findbyid(id));
    }
}
