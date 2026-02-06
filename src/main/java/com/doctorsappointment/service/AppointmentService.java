package com.doctorsappointment.service;

import com.doctorsappointment.entity.Appointment;
import com.doctorsappointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    /**
     * Get all appointments
     */
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    
    /**
     * Get appointment by ID
     */
    public Optional<Appointment> getAppointmentById(Long id) {
        return appointmentRepository.findById(id);
    }
    
    /**
     * Create new appointment
     */
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
    
    /**
     * Update appointment
     */
    public Appointment updateAppointment(Long id, Appointment appointmentDetails) {
        Optional<Appointment> existingAppointment = appointmentRepository.findById(id);
        
        if (existingAppointment.isPresent()) {
            Appointment appointment = existingAppointment.get();
            
            if (appointmentDetails.getPatientName() != null) {
                appointment.setPatientName(appointmentDetails.getPatientName());
            }
            if (appointmentDetails.getPatientEmail() != null) {
                appointment.setPatientEmail(appointmentDetails.getPatientEmail());
            }
            if (appointmentDetails.getPatientPhone() != null) {
                appointment.setPatientPhone(appointmentDetails.getPatientPhone());
            }
            if (appointmentDetails.getDoctorName() != null) {
                appointment.setDoctorName(appointmentDetails.getDoctorName());
            }
            if (appointmentDetails.getAppointmentDate() != null) {
                appointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
            }
            if (appointmentDetails.getAppointmentTime() != null) {
                appointment.setAppointmentTime(appointmentDetails.getAppointmentTime());
            }
            if (appointmentDetails.getReason() != null) {
                appointment.setReason(appointmentDetails.getReason());
            }
            
            return appointmentRepository.save(appointment);
        }
        return null;
    }
    
    /**
     * Delete appointment
     */
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
    
    /**
     * Find appointments by patient email
     */
    public List<Appointment> getAppointmentsByPatientEmail(String patientEmail) {
        return appointmentRepository.findByPatientEmail(patientEmail);
    }
    
    /**
     * Find appointments by doctor name
     */
    public List<Appointment> getAppointmentsByDoctorName(String doctorName) {
        return appointmentRepository.findByDoctorName(doctorName);
    }
    
    /**
     * Find appointments by date
     */
    public List<Appointment> getAppointmentsByDate(LocalDate date) {
        return appointmentRepository.findByAppointmentDate(date);
    }
}
