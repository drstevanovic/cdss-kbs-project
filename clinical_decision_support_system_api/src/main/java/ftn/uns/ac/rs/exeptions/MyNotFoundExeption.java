package ftn.uns.ac.rs.exeptions;


public class MyNotFoundExeption extends RuntimeException {

    public MyNotFoundExeption() {
        super();
    }

    public MyNotFoundExeption(String message) {
        super(message);
    }

}