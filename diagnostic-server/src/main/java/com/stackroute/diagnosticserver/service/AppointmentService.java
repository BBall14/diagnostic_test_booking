package com.stackroute.diagnosticserver.service;

import com.stackroute.diagnosticserver.Exception.AppointmentDoesNotExistException;
import com.stackroute.diagnosticserver.Exception.TestDoesNotExistException;
import com.stackroute.diagnosticserver.model.Appointment;
import com.stackroute.diagnosticserver.model.Diagnostic;
import com.stackroute.diagnosticserver.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// annotate with Service
@Service
public class AppointmentService {

    // Autowire the AppointmentRepo
    @Autowired
    private AppointmentRepo appointmentRepo;

    // Autowire the DiagnosticService
    @Autowired
    private DiagnosticService diagnosticService;

    // Methos to save appointment details in the database
    public void saveAppointment(Appointment appointment) throws TestDoesNotExistException {
        try {
            // Call the getTestsById method of diagnosticService
            Optional<Diagnostic> diagnostic = diagnosticService.getTestsById(appointment.getTestId());
            // If the diagnostic test does not exist, throw TestDoesNotExistException
            if (diagnostic == null) {
                throw new TestDoesNotExistException("Diagnostic test does not exist");
            }
            // Save the appointment details in the database
            appointmentRepo.save(appointment);
        } catch (Exception e) {
            throw new TestDoesNotExistException("Failed to save appointment");
        }
    }

    // Method to modify appointment details in the database
    public Appointment modifyAppointment(Appointment appointment) throws AppointmentDoesNotExistException {
        try {
            // Call the getReferenceById method of appointmentRepo
            Appointment appointmentData = appointmentRepo.getReferenceById(appointment.getBookId());
            // If the appointment does not exist, throw AppointmentDoesNotExistException
            if (appointmentData == null) {
                throw new AppointmentDoesNotExistException("Appointment does not exist");
            }
            // Update the appointment details in the database
            Appointment appointmentUpdate = appointmentRepo.save(appointment);
            return appointmentUpdate;
        } catch (AppointmentDoesNotExistException e) {
            throw new AppointmentDoesNotExistException("Appointment does not exist");
        }
    }

    // Method to delete appointment details from the database
    public void deleteAppointment(int id) throws AppointmentDoesNotExistException {
        try {
            // Call the getReferenceById method of appointmentRepo
            Appointment appointmentData = appointmentRepo.getReferenceById(id);
            // If the appointment does not exist, throw AppointmentDoesNotExistException
            if (appointmentData == null) {  
                throw new AppointmentDoesNotExistException("Appointment does not exist");
            }
            // Delete the appointment details from the database
            appointmentRepo.deleteById(id);
        } catch (AppointmentDoesNotExistException e) {
            throw new AppointmentDoesNotExistException("Appointment does not exist");
        }
    }

    // Method to get appointment details from the database
    public List<Appointment> getAllAppointment() {
        return appointmentRepo.findAll();
    }
}
