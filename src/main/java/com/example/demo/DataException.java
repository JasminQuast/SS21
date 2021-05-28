package com.example.demo;


@SuppressWarnings("serial")
public class DataException extends RuntimeException {

    public DataException() {
    }

    public DataException(String msg) {

        super(msg);
    }

    public DataException(Throwable t) {

        super(t);
    }

}
