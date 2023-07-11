package com.stackroute.diagnosticserver.Exception;

// This class will be used to throw the exception when the test already exists
public class TestAlreadyExistException extends Exception{
    private String message;
    public TestAlreadyExistException(String message) {
        super(message);
        this.message=message;
    }

    public TestAlreadyExistException() {}
}
