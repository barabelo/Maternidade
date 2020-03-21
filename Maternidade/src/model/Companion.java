package model;

public class Companion {

    public static int TAM_MAX_CPF = 14;
    public static int TAM_MAX_RG = 15;
    public static int TAM_MAX_NAME = 50;
    public static int TAM_MAX_SEX = 10;
    public static int TAM_MAX_KINSHIP = 20;
    public static int TAM_MAX_EMAIL = 50;
    public static int TAM_MAX_PHONE = 15;
    public static int TAM_MAX_MOTHER_ID = 14;

    private String CPF;
    private String RG;
    private String name;
    private String sex;
    private String kinship;
    private String email;
    private String phone;
    private String MotherCPF;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getKinship() {
        return kinship;
    }

    public void setKinship(String kinship) {
        this.kinship = kinship;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMotherCPF(String MotherCPF) {
        this.MotherCPF = MotherCPF;
    }

    public String getMotherCPF() {
        return MotherCPF;
    }

}
