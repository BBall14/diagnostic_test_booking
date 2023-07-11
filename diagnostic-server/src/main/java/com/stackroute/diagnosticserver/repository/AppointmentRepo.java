package com.stackroute.diagnosticserver.repository;

import com.stackroute.diagnosticserver.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// annotate with Repository
// extend JpaRepository
@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
}
