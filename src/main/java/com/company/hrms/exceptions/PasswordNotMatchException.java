package com.company.hrms.exceptions;

public class PasswordNotMatchException extends RuntimeException{
    public PasswordNotMatchException(String msg){
        super(msg);
    }
}
