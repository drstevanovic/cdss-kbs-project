package ftn.uns.ac.rs.domain.dto;

public class ReportDto {

    private String jmbg;
    private String firstName;
    private String lastName;

    public ReportDto(){

    }

    public ReportDto(String jmbg, String firstName, String lastName) {
        this.jmbg = jmbg;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
