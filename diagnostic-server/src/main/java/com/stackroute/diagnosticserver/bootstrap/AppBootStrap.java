package com.stackroute.diagnosticserver.bootstrap;

import com.stackroute.diagnosticserver.model.Diagnostic;
import com.stackroute.diagnosticserver.model.User;
import com.stackroute.diagnosticserver.repository.DiagnosticRepo;
import com.stackroute.diagnosticserver.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppBootStrap implements CommandLineRunner {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private DiagnosticRepo diagnosticRepo;

    // This method will be executed after the application is up and running
    // This method will be used to insert some data into the database
    @Override
    public void run(String... args) throws Exception {
        // Insert some users
        User user1 = new User(1, "PrashuDev", "Prashu");
        User user2 = new User(2, "PradeepDev","Pradeep");
        userRepo.save(user1);
        userRepo.save(user2);

        // Insert some diagnostics
        Diagnostic diagnostic1 = new Diagnostic(1, "Blood Pressure", "Check for normal BP",30.0);
        Diagnostic diagnostic2 = new Diagnostic(2, "X-Ray", "Chest XRay",500.0);
        Diagnostic diagnostic3 = new Diagnostic(3, "Blood Test", "Complete count of RBC and WBC",100.0);
        Diagnostic diagnostic4 = new Diagnostic(4, "Cholesterol", "Check for higher cholesterol",345.0);
        Diagnostic diagnostic5 = new Diagnostic(5, "Diabetic Test", "Check for Glucose level",300.0);
        diagnosticRepo.save(diagnostic1);
        diagnosticRepo.save(diagnostic2);
        diagnosticRepo.save(diagnostic3);
        diagnosticRepo.save(diagnostic4);
        diagnosticRepo.save(diagnostic5);
    }
}