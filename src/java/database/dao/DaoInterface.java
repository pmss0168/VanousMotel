/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package database.dao;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author ADMIN
 */
public interface DaoInterface<T> {
    List<T> getAll();
    Optional<T> get(int id);
    int save(T t);
    boolean update(T t);
    boolean delete(T t);
}
