/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.repository.serviceinterface;

/**
 *
 * @author kresna92
 */
public interface ServiceInterface <T>{
    Iterable<T> findall();
    T save (T t);
    T findbyid(String id);
    void delete(String id);
}
