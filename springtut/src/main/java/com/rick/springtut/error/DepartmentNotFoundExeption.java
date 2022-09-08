package com.rick.springtut.error;

public class DepartmentNotFoundExeption extends Exception{
    public DepartmentNotFoundExeption() {
        super();
    }

    public DepartmentNotFoundExeption(String message) {
        super(message);
    }

    public DepartmentNotFoundExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFoundExeption(Throwable cause) {
        super(cause);
    }

    protected DepartmentNotFoundExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
