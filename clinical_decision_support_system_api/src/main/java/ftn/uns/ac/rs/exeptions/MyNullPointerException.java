package ftn.uns.ac.rs.exeptions;

public class MyNullPointerException extends RuntimeException {

    public MyNullPointerException() {
        super();
    }

    public MyNullPointerException(String message) {
        super(message);
    }
}
