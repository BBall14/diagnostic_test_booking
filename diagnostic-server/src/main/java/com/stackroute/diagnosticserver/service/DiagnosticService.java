package com.stackroute.diagnosticserver.service;

import com.stackroute.diagnosticserver.Exception.TestAlreadyExistException;
import com.stackroute.diagnosticserver.Exception.TestDoesNotExistException;
import com.stackroute.diagnosticserver.model.Diagnostic;
import com.stackroute.diagnosticserver.repository.DiagnosticRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// annotate with Service
@Service
public class DiagnosticService {

    // Autowire the DiagnosticRepo
    @Autowired
    private DiagnosticRepo diagnosticRepo;

    // Method to save diagnostic test details in the database
    public void saveDiagnosticTest(Diagnostic diagnostic) throws TestAlreadyExistException {
        try{
            // Save the diagnostic test details in the database
            diagnosticRepo.save(diagnostic);
        } catch (Exception e) {
            throw new TestAlreadyExistException("Test already exists");
        }
    }

    // Method to get all diagnostic test details from the database
    public List<Diagnostic> getAllTests() throws TestDoesNotExistException {
        try {
            // Get all diagnostic test details from the database
            return diagnosticRepo.findAll();
        } catch (Exception e) {
            throw new TestDoesNotExistException("No tests found");
        }
    }

    // Method to get diagnostic test details by id from the database
    public Optional<Diagnostic> getTestsById(int id) throws TestDoesNotExistException {
        try {
            // Get diagnostic test details by id from the database
            Optional<Diagnostic> diagnostic = diagnosticRepo.findById(id);
            // If the diagnostic test does not exist, throw TestDoesNotExistException
            if (diagnostic == null) {
                throw new TestDoesNotExistException("Test with id doesn't exist");
            }
            return diagnostic;
        } catch (Exception e) {
            throw new TestDoesNotExistException("No tests found");
        }
    }

}
