package ftn.uns.ac.rs.exeptions;

public class MyInvalidRequestException extends RuntimeException {

    public MyInvalidRequestException() {
        super();
    }

    public MyInvalidRequestException(String message) {
        super(message);
    }
}
