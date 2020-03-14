package model;

public class Doctor {

    public static int TAM_MAX_CRM = 15;
    public static int TAM_MAX_ESPECIALIDADE = 50;
    public static int TAM_MAX_NOME = 35;
    private String CRM;
    private String name;
    private String speciality;

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
