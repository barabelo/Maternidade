package model;

import java.time.LocalDate;

public class Baby {

    public static int TAM_MAX_ID = 5;
    public static int TAM_MAX_NAME = 50;
    public static int TAM_MAX_SEX = 10;
    private String id;
    private String name;
    private LocalDate birthday;
    private String sex;
    private String MotherCPF;
    private double height;
    private double weight;

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private static boolean trimmedNameIsValid(String trimmedName) {
        for (int i = 0; i < trimmedName.length(); i++) {
            char ch = trimmedName.charAt(i);
            if (!Character.isLetter(ch) && ch != ' ') {
                return false;
            }
        }
        return true;
    }
    
    public static String trimName(String name) throws ValorInvalidoException {
        String trimmedName = name.trim().replaceAll(" +", "");
        if (trimmedNameIsValid(trimmedName)) {
            return trimmedName;
        } else {
            throw new ValorInvalidoException("Nome da mãe inválido: "
                        + "ele deve conter apenas letras e espaços");
        }
    }
    
    public void setName(String name) throws ValorInvalidoException {
        this.name = trimName(name);
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws ValorInvalidoException {
        if (height > 0) {
            this.height = height;
        } else {
            throw new ValorInvalidoException("Altura inválida: ela deve ser "
                    + "maior do que zero.");
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws ValorInvalidoException {
        if (weight > 0) {
            this.weight = weight;
        } else {
            throw new ValorInvalidoException("Largura inválida: ela deve ser "
                    + "maior do que zero.");
        }
    }

    public String getMotherCPF() {
        return MotherCPF;
    }

    public void setMotherCPF(String MotherCPF) {
        this.MotherCPF = MotherCPF;
    }

}
