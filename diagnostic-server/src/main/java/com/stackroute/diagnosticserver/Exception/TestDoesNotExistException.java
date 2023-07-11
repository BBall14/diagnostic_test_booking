package com.stackroute.diagnosticserver.Exception;

// This class will be used to throw the exception when the test does not exist
public class TestDoesNotExistException extends Exception{
    private String message;
    public TestDoesNotExistException(String message) {
        super(message);
        this.message=message;
    }

    public TestDoesNotExistException() {}
}
