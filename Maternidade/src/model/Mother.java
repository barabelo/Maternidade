package model;

import java.time.LocalDate;

public class Mother {

    public static int TAM_MAX_CPF = 14;
    public static int TAM_MAX_REG = 15;
    public static int TAM_MAX_NAME = 50;
    private String CPF;
    private String REG;
    private String name;
    private LocalDate birthday;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getREG() {
        return REG;
    }

    public void setREG(String REG) {
        this.REG = REG;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
