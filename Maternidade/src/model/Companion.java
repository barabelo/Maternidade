package model;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.CPF);
        hash = 83 * hash + Objects.hashCode(this.RG);
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.sex);
        hash = 83 * hash + Objects.hashCode(this.kinship);
        hash = 83 * hash + Objects.hashCode(this.email);
        hash = 83 * hash + Objects.hashCode(this.phone);
        hash = 83 * hash + Objects.hashCode(this.MotherCPF);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Companion other = (Companion) obj;
        if (!Objects.equals(this.CPF, other.CPF)) {
            return false;
        }
        if (!Objects.equals(this.RG, other.RG)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.sex, other.sex)) {
            return false;
        }
        if (!Objects.equals(this.kinship, other.kinship)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.MotherCPF, other.MotherCPF)) {
            return false;
        }
        return true;
    }

}
