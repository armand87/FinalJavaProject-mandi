package com.sda.hospitalappointmentmanagement.repository;

import com.sda.hospitalappointmentmanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer > {
}
