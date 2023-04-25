package com.sda.hospitalappointmentmanagement.service;

import com.sda.hospitalappointmentmanagement.entity.Doctor;
import com.sda.hospitalappointmentmanagement.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService implements EntityServiceInterface<Doctor> {


    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository thDoctorRepository){
        this.doctorRepository=thDoctorRepository;
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findById(int theId) {
        Optional<Doctor> result = doctorRepository.findById(theId);
        Doctor theDoctor=null;

        if (result.isPresent()){
            theDoctor=result.get();
        }else {
            throw new RuntimeException("Did not find Doctor ID - "+ theId);
        }

        return theDoctor;
    }

    @Transactional
    @Override
    public Doctor save(Doctor theDoctor) {
        return doctorRepository.save(theDoctor);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        doctorRepository.deleteById(theId);

    }
}
