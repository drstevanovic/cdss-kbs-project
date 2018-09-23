package ftn.uns.ac.rs.exeptions;

public class MyValidationFormException extends RuntimeException {

    public MyValidationFormException() {
        super();
    }

    public MyValidationFormException(String message) {
        super(message);
    }

}
