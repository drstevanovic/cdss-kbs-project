package ftn.uns.ac.rs.exeptions;

public class MyDeletingInRepoException extends RuntimeException {

    public MyDeletingInRepoException() {
        super();
    }

    public MyDeletingInRepoException(String message) {
        super(message);
    }
}
