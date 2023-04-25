package com.sda.hospitalappointmentmanagement.controller;


import com.sda.hospitalappointmentmanagement.entity.Patient;
import com.sda.hospitalappointmentmanagement.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientRest {

    private PatientService patientService;


    @Autowired
    public PatientRest(PatientService thePatientService){
        this.patientService =thePatientService;
    }



    @GetMapping("/patients")
    public List<Patient> findAll() {
        return patientService.findAll();
    }

    @GetMapping("/patients/{patientId}")
    public Patient getDoctor(@PathVariable int patientId) {
        Patient thePatient = patientService.findById(patientId);

        if (thePatient == null) {
            throw new RuntimeException("Doctor ID not found - " + patientId);
        }

        return thePatient;
    }

    @PostMapping("/patients")
    public Patient addDoctor(@RequestBody Patient theDoctor) {

        theDoctor.setId(0);
        Patient dbPatient = patientService.save(theDoctor);
        return dbPatient;
    }

    @PutMapping("/patients")
    public Patient updateDoctor(@RequestBody Patient thePatient) {

        Patient dbPatient = patientService.save(thePatient);

        return dbPatient;
    }

    @DeleteMapping("/patients/{patientId}")
    public String deletePatient(@PathVariable int patientId) {

        Patient tempPatient= patientService.findById(patientId);

        if( tempPatient== null){
            throw new RuntimeException("Patient ID not found - "+ patientId);
        }

        patientService.deleteById(patientId);
        return "Deleted Patient ID - " + patientId;
    }
}
