package ftn.uns.ac.rs.domain.dto;

public class SymptomDto {
    private String name;
    private boolean specific;
    public SymptomDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getSpecific() {
        return specific;
    }

    public void setSpecific(boolean specific) {
        this.specific = specific;
    }
}
