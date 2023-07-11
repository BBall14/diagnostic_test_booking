package com.stackroute.diagnosticserver.controller;

import com.stackroute.diagnosticserver.Exception.TestAlreadyExistException;
import com.stackroute.diagnosticserver.Exception.TestDoesNotExistException;
import com.stackroute.diagnosticserver.model.Diagnostic;
import com.stackroute.diagnosticserver.service.DiagnosticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Mark as Controller
// Mark the class with @RequestMapping
// Mark the class with @CrossOrigin
@RestController
@RequestMapping("api/v1/diagnostic")
@CrossOrigin("*")
public class DiagnosticController {

    // Autowire the DiagnosticService
    @Autowired
    public DiagnosticService diagnosticService;

    @GetMapping("hello")
    public String getMessage() {
        return  "Good Morning!!";
    }

    // Mark the method with @PostMapping to save the diagnostic test
    @PostMapping("/")
    public ResponseEntity<?> saveDiagnosticTest(@RequestBody Diagnostic diagnostic) {
        try {
            // Call the saveDiagnosticTest method of diagnosticService
            diagnosticService.saveDiagnosticTest(diagnostic);
            return new ResponseEntity<>("Successfully created", HttpStatus.CREATED);
        } catch (TestAlreadyExistException e) {
            return new ResponseEntity<>("Test already exists", HttpStatus.CONFLICT);
        }
    }

    // Mark the method with @GetMapping to get all the diagnostic tests
    @GetMapping("/")
    public ResponseEntity<?> getAllTests() {
        try {
            // Call the getAllTests method of diagnosticService
            return new ResponseEntity<>(diagnosticService.getAllTests(), HttpStatus.OK);
        } catch (TestDoesNotExistException e) {
            return new ResponseEntity<>("No tests found", HttpStatus.NOT_FOUND);
        }
    }

    // Mark the method with @GetMapping to get the diagnostic test by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getTestById(@PathVariable int id) {
        try {
            // Call the getTestById method of diagnosticService
            Optional<Diagnostic> diagnostic = diagnosticService.getTestsById(id);
            // Return data as list
            List<Diagnostic> diagnosticList = new ArrayList<>();
            diagnostic.ifPresent(diagnosticList::add);
            return new ResponseEntity<>(diagnosticList, HttpStatus.OK);

        } catch (TestDoesNotExistException e) {
            return new ResponseEntity<>("Test with id doesn't exist", HttpStatus.NOT_FOUND);
        }
    }
}
