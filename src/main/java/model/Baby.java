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

    public void setName(String name) {
        this.name = name;
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

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getMotherCPF() {
        return MotherCPF;
    }

    public void setMotherCPF(String MotherCPF) {
        this.MotherCPF = MotherCPF;
    }

}
