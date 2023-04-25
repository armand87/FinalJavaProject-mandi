package com.sda.hospitalappointmentmanagement.controller;


import com.sda.hospitalappointmentmanagement.entity.Doctor;
import com.sda.hospitalappointmentmanagement.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorRest{

    private DoctorService doctorService;

    @Autowired
    public DoctorRest(DoctorService theDoctorService){
        this.doctorService=theDoctorService;
    }



    @GetMapping("/doctors")
    public List<Doctor> findAll() {
        return doctorService.findAll();
    }

    @GetMapping("/doctors/{doctorId}")
    public Doctor getDoctor(@PathVariable int doctorId) {
        Doctor theDoctor = doctorService.findById(doctorId);

        if (theDoctor == null) {
            throw new RuntimeException("Doctor ID not found - " + doctorId);
        }

        return theDoctor;
    }

    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor theDoctor) {

        theDoctor.setId(0);
        Doctor dbDoctor = doctorService.save(theDoctor);
        return dbDoctor;
    }

    @PutMapping("/doctors")
    public Doctor updateDoctor(@RequestBody Doctor theDoctor) {

        Doctor dbDoctor = doctorService.save(theDoctor);

        return dbDoctor;
    }

    @DeleteMapping("/doctors/{doctorId}")
    public String deleteDoctor(@PathVariable int doctorId) {

        Doctor tempDoctor = doctorService.findById(doctorId);

        if(tempDoctor == null){
            throw new RuntimeException("Doctor ID not found - "+ doctorId);
        }

        doctorService.deleteById(doctorId);
        return "Deleted Doctor ID - " + doctorId;
    }
}
