package com.sda.hospitalappointmentmanagement.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name ="appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    @Column(name="decription")
    private String decription;

    @Temporal(TemporalType.TIMESTAMP)
    private Date appointmentDateTime;

    public Appointment() {
    }

    public Appointment(Doctor doctor, Patient patient, String decription, Date appointmentDateTime) {
        this.doctor = doctor;
        this.patient = patient;
        this.decription = decription;
        this.appointmentDateTime = appointmentDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Date getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(Date appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", decription='" + decription + '\'' +
                ", appointmentDateTime=" + appointmentDateTime +
                '}';
    }
}
