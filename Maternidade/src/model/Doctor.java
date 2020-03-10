package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Doctor {

    private String CRM;
    private String name;
    private String speciality;

    static Scanner scanner = new Scanner(System.in);

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

    public static void insert() {

        Doctor doctor = new Doctor();

        System.out.print("\n Entre com o nome do(a) médico(a).\n" + " > ");

        doctor.name = scanner.nextLine();

        System.out.print("\n Entre com a especialidade.\n" + " > ");

        doctor.speciality = scanner.nextLine();

        System.out.print("\n Entre com o CRM.\n" + " > ");

        doctor.CRM = scanner.nextLine();

        DoctorDAO.insert(doctor);
    }

    public static void delete() {

        String CRM;

        System.out.print("\n Entre com o CRM do(a) médico(a) que você quer deletar.\n" + " > ");

        CRM = scanner.nextLine();

        DoctorDAO.delete(CRM);
    }

    public static void select(String CPF) {

        List<Doctor> list = new ArrayList<>();

        list = DoctorDAO.select(CPF);

        System.out.println(" Informações de Médicos Relacionados\n");

        for (int i = 0; i < list.size(); i++) {

            System.out.println(" Nome: " + list.get(i).name);
            System.out.println(" CRM: " + list.get(i).CRM);
            System.out.println(" Especialidade: " + list.get(i).speciality + "\n");
        }
    }
}
