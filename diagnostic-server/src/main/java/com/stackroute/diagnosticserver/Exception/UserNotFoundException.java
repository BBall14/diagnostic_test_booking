package com.stackroute.diagnosticserver.Exception;

// This class will be used to throw the exception when the user does not exist
public class UserNotFoundException  extends Exception{

    private String message;

    public UserNotFoundException(String message){
        super(message);
        this.message=message;
    }

    public UserNotFoundException() {}
}
