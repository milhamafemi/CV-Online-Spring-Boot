/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface.serviceimpl;

import cv.cv.entities.Employee;
import cv.cv.repository.EmployeeRepository;
import cv.cv.repository.serviceinterface.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NINDA
 */
@Service
public class EmployeeServiceImpl implements ServiceInterface<Employee> {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> findall() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee t) {
        return employeeRepository.save(t);
    }

    @Override
    public Employee findbyid(String id) {
        return employeeRepository.findbyid(id);
    }

    @Override
    public void delete(String id) {
        employeeRepository.delete(findbyid(id));
    }

}
