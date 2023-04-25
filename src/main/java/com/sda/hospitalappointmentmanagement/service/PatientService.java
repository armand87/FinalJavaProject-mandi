package com.sda.hospitalappointmentmanagement.service;

import com.sda.hospitalappointmentmanagement.entity.Patient;
import com.sda.hospitalappointmentmanagement.repository.PatientRepository;
import jakarta.persistence.EntityManager;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements EntityServiceInterface<Patient>{

    private PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository thePatientRepository){
        this.patientRepository=thePatientRepository;
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findById(int theId) {
        Optional<Patient> result = patientRepository.findById(theId);

        Patient thePatient=null;

        if (result.isPresent()){
            thePatient=result.get();
        }else {
            throw new RuntimeException("Did not find Patient ID - "+ theId);
        }
        return thePatient;
    }
    @Transactional
    @Override
    public Patient save(Patient object) {
        return patientRepository.save(object);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        patientRepository.deleteById(theId);

    }
}
