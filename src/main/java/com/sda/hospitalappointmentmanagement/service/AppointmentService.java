package com.sda.hospitalappointmentmanagement.service;

import com.sda.hospitalappointmentmanagement.entity.Appointment;
import com.sda.hospitalappointmentmanagement.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements EntityServiceInterface<Appointment>{
    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository theAppointmentRepository) {
        this.appointmentRepository=theAppointmentRepository;
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment findById(int theId) {
        Optional<Appointment> result = appointmentRepository.findById(theId);

        Appointment appointment = null;

        if(result.isPresent()){
            appointment= result.get();
        }else {
            throw new RuntimeException("Did not find Appointment ID - " + theId);
        }
        return appointment;
    }

    @Transactional
    @Override
    public Appointment save(Appointment object) {
        return appointmentRepository.save(object);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {

        appointmentRepository.deleteById(theId);
    }
}
