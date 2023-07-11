package com.stackroute.diagnosticserver.repository;

import com.stackroute.diagnosticserver.model.Diagnostic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// annotate with Repository
// extend JpaRepository
@Repository
public interface DiagnosticRepo extends JpaRepository<Diagnostic, Integer> {
}
