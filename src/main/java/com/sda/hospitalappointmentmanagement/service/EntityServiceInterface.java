package com.sda.hospitalappointmentmanagement.service;

import java.util.List;

public interface EntityServiceInterface<T> {

    List<T> findAll();

    T findById(int theId);

    T save(T object);

    void deleteById(int theId);
}
