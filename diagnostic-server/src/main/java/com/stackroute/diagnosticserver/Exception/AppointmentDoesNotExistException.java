package com.stackroute.diagnosticserver.Exception;

// This class will be used to throw the exception when the appointment does not exist
public class AppointmentDoesNotExistException extends Exception{

    private String message;

    public AppointmentDoesNotExistException(String message) {
        super(message);
        this.message=message;
    }

    public AppointmentDoesNotExistException() {}
}
