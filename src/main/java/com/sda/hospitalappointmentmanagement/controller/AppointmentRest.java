package com.sda.hospitalappointmentmanagement.controller;


import com.sda.hospitalappointmentmanagement.entity.Appointment;
import com.sda.hospitalappointmentmanagement.entity.Patient;
import com.sda.hospitalappointmentmanagement.service.AppointmentService;
import com.sda.hospitalappointmentmanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppointmentRest {

    private AppointmentService appointmentService;


    @Autowired
    public AppointmentRest(AppointmentService theAppointmentService){
        this.appointmentService =theAppointmentService;
    }



    @GetMapping("/appointments")
    public List<Appointment> findAll() {
        return appointmentService.findAll();
    }

    @GetMapping("/appointments/{appointmentId}")
    public Appointment getAppointment(@PathVariable int appointmentId) {
        Appointment theAppointment = appointmentService.findById(appointmentId);

        if (theAppointment == null) {
            throw new RuntimeException("Appointment ID not found - " + appointmentId);
        }

        return theAppointment;
    }

    @PostMapping("/appointments")
    public Appointment addAppointment(@RequestBody Appointment theAppointment) {

        theAppointment.setId(0);
        Appointment dbAppointment = appointmentService.save(theAppointment);
        return dbAppointment;
    }

    @PutMapping("/appointments")
    public Appointment updateAppointment(@RequestBody Appointment theAppointment) {

        Appointment dbAppointment = appointmentService.save(theAppointment);

        return dbAppointment;
    }

    @DeleteMapping("/appointments/{appointmentId}")
    public String deleteAppointment(@PathVariable int appointmentId) {

        Appointment tempAppointment= appointmentService.findById(appointmentId);

        if( tempAppointment== null){
            throw new RuntimeException("Appointment ID not found - "+ appointmentId);
        }

        appointmentService.deleteById(appointmentId);
        return "Deleted appointment ID - " + appointmentId;
    }
}
