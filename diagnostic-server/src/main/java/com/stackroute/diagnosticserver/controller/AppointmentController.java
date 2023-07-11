package com.stackroute.diagnosticserver.controller;

import com.stackroute.diagnosticserver.Exception.TestDoesNotExistException;
import com.stackroute.diagnosticserver.model.Appointment;
import com.stackroute.diagnosticserver.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Mark as Controller
// Mark the class with @RequestMapping
// Mark the class with @CrossOrigin
@RestController
@RequestMapping("api/v1/appointment")
@CrossOrigin("*")
public class AppointmentController {

    // Autowire the AppointmentService
    @Autowired
    private AppointmentService appointmentService;

    // Mark the method with @PostMapping to save the appointment
    // Mark the method with @RequestBody
    @PostMapping("/")
    public ResponseEntity<?> saveAppointment(@RequestBody Appointment appointment) {
        try {
            appointmentService.saveAppointment(appointment);
            return new ResponseEntity<>("Successfully created", HttpStatus.CREATED);
        } catch (TestDoesNotExistException te) {
            return new ResponseEntity<>("Test does not exist", HttpStatus.NOT_FOUND);
        }catch (Exception e) {
            return new ResponseEntity<>("Appointment already exists", HttpStatus.CONFLICT);
        }
    }

    // Mark the method with @PutMapping to modify the appointment
    @PutMapping("/")
    public ResponseEntity<?> modifyAppointment(@RequestBody Appointment appointment) {
        try {
            // Call the modifyAppointment method of appointmentService
            appointmentService.modifyAppointment(appointment);
            return new ResponseEntity<>("Successfully modified", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Appointment does not exist", HttpStatus.NOT_FOUND);
        }
    }

    // Mark the method with @DeleteMapping to delete the appointment
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable int id) {
        try {
            // Call the deleteAppointment method of appointmentService
            appointmentService.deleteAppointment(id);
            return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Appointment does not exist", HttpStatus.NOT_FOUND);
        }
    }

    // Mark the method with @GetMapping to get the appointments
    @GetMapping("/")
    public ResponseEntity<?> getAllAppointments() {
        try {
            // Call the getAllAppointment method of appointmentService
            return new ResponseEntity<>(appointmentService.getAllAppointment(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("No appointments found", HttpStatus.NOT_FOUND);
        }
    }
}
