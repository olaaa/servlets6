package ru.ferdibiflator.springDemoApplication.dao.exception;

public class NoSuchEntityException extends Exception{
    public NoSuchEntityException() {
        super();
    }

    public NoSuchEntityException(String message) {
        super(message);
    }

    public NoSuchEntityException(Throwable cause) {
        super(cause);
    }

    public NoSuchEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
