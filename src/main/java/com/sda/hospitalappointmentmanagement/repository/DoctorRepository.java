package com.sda.hospitalappointmentmanagement.repository;

import com.sda.hospitalappointmentmanagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
