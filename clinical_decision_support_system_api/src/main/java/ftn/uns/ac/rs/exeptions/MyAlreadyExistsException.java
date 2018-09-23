package ftn.uns.ac.rs.exeptions;

public class MyAlreadyExistsException extends RuntimeException {

    public MyAlreadyExistsException() {
        super();
    }

    public MyAlreadyExistsException(String message) {
        super(message);
    }
}