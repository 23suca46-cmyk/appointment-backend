package com.doctorsappointment.repository;

import com.doctorsappointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByPatientEmail(String patientEmail);
    List<Appointment> findByDoctorName(String doctorName);
    List<Appointment> findByAppointmentDate(LocalDate appointmentDate);
}
