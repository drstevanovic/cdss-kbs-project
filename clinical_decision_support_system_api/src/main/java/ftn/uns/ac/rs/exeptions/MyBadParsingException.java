package ftn.uns.ac.rs.exeptions;

public class MyBadParsingException extends RuntimeException {

    public MyBadParsingException() {
        super();
    }

    public MyBadParsingException(String message) {
        super(message);
    }

}
