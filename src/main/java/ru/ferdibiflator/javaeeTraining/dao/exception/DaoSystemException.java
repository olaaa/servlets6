package ru.ferdibiflator.javaeeTraining.dao.exception;


public class DaoSystemException extends Exception {
    public DaoSystemException() {
        super();
    }

    public DaoSystemException(String message) {
        super(message);
    }

    public DaoSystemException(Throwable cause) {
        super(cause);
    }

    public DaoSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
