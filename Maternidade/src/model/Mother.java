package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mother {

    private String CPF;
    private String REG;
    private String name;
    private String birthday;

    static Scanner scanner = new Scanner(System.in);

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

    public String getBirthday() {

        return birthday;
    }

    public void setBirthday(String birthday) {

        this.birthday = birthday;
    }

    public static void insert() {

        int number;

        String CRM;

        Mother mother = new Mother();

        System.out.print("\n Entre com o nome da mãe.\n" + " > ");

        mother.name = scanner.nextLine();

        System.out.print("\n Entre com o CPF.\n" + " > ");

        mother.CPF = scanner.nextLine();

        System.out.print("\n Entre com o RG.\n" + " > ");

        mother.REG = scanner.nextLine();

        System.out.print("\n Entre com a data de nascimento.\n" + " > ");

        mother.birthday = scanner.nextLine();

        MotherDAO.insert(mother);

        System.out.print("\n Qual o número de médicos responsáveis pela paciente?.\n" + " > ");

        number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {

            System.out.print("\n Entre com o CRM do " + (i + 1) + "º médico.\n" + " > ");

            CRM = scanner.nextLine();

            MotherDoctorDAO.insert(mother.CPF, CRM);
        }
    }

    public static void delete() {

        String CPF;

        System.out.print("\n Entre com o CPF da paciente que você quer deletar.\n" + " > ");

        CPF = scanner.nextLine();

        MotherDAO.delete(CPF);
    }

    public static void update() {

        int number;
        int option;

        String CRM;
        String current;

        Mother mother = new Mother();

        System.out.println(" Você deseja editar quais grupos de informações?\n");

        System.out.println(" [1] Informações Pessoais [2] Médicos Relacionados");

        System.out.print("\n Escolha uma opção e pressione ENTER.\n" + " > ");

        option = Integer.parseInt(scanner.nextLine());

        switch (option) {

            case 1:
                System.out.print("\n Entre com o CPF atual da paciente.\n" + " > ");

                current = scanner.nextLine();

                System.out.print("\n Entre com o novo CPF da paciente.\n" + " > ");

                mother.CPF = scanner.nextLine();

                System.out.print("\n Entre com o nome da paciente.\n" + " > ");

                mother.name = scanner.nextLine();

                System.out.print("\n Entre com o RG.\n" + " > ");

                mother.REG = scanner.nextLine();

                System.out.print("\n Entre com a data de nascimento.\n" + " > ");

                mother.birthday = scanner.nextLine();

                MotherDAO.update(mother, current);

                break;
            case 2:
                System.out.print("\n Entre com o CPF da paciente.\n" + " > ");

                mother.CPF = scanner.nextLine();

                System.out.print("\n Entre com o número de médicos que você deseja relacionar a esta paciente.\n" + " > ");

                number = Integer.parseInt(scanner.nextLine());

                for (int i = 0; i < number; i++) {

                    System.out.print("\n Entre com o CRM do " + (i + 1) + "º médico.\n" + " > ");

                    CRM = scanner.nextLine();

                    MotherDoctorDAO.insert(mother.CPF, CRM);
                }

                break;
        }
    }

    public static void select(String CPF) {

        List<Mother> list = new ArrayList<>();

        list = MotherDAO.select(CPF);

        System.out.println(" Informações da Paciente\n");

        System.out.println(" Nome: " + list.get(0).name);
        System.out.println(" CPF: " + list.get(0).CPF);
        System.out.println(" REG: " + list.get(0).REG);
        System.out.println(" Nascimento: " + list.get(0).birthday + "\n");

        System.out.println(" -----------------------------------\n");
    }
}
