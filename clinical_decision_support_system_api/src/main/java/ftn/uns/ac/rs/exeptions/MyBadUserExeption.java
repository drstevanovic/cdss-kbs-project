package ftn.uns.ac.rs.exeptions;

public class MyBadUserExeption extends RuntimeException {

    public MyBadUserExeption() {
        super();
    }

    public MyBadUserExeption(String message) {
        super(message);
    }

}
