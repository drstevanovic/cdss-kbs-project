package ftn.uns.ac.rs.exeptions;

public class MyAccessDeniedException extends RuntimeException {
    public MyAccessDeniedException() {
        super();
    }

    public MyAccessDeniedException(String message) {
        super(message);
    }
}
