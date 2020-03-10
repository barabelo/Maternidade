package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Companion {

    private String CPF;
    private String REG;
    private String name;
    private String sex;
    private String kinship;

    private String email;
    private String phone;

    private String MCPF;

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

    public String getMCPF() {

        return MCPF;
    }

    public static void insert() {

        Companion companion = new Companion();

        System.out.print("\n Entre com o nome do(a) acompanhante.\n" + " > ");

        companion.name = scanner.nextLine();

        System.out.print("\n Entre com o CPF.\n" + " > ");

        companion.CPF = scanner.nextLine();

        System.out.print("\n Entre com o RG.\n" + " > ");

        companion.REG = scanner.nextLine();

        System.out.print("\n Entre com o sexo.\n" + " > ");

        companion.sex = scanner.nextLine();

        System.out.print("\n Entre com o CPF da paciente.\n" + " > ");

        companion.MCPF = scanner.nextLine();

        System.out.print("\n Entre com o parentesco.\n" + " > ");

        companion.kinship = scanner.nextLine();

        System.out.print("\n Entre com o e-mail.\n" + " > ");

        companion.email = scanner.nextLine();

        System.out.print("\n Entre com o número do telefone.\n" + " > ");

        companion.phone = scanner.nextLine();

        CompanionDAO.insert(companion);
    }

    public static void update() {

        int option;

        String current;

        Companion companion = new Companion();

        System.out.println(" Você deseja editar qual grupo de informações?\n");

        System.out.println(" [1] Informações Pessoais  [2] Informações de Contato");

        System.out.print("\n Escolha uma opção e pressione ENTER.\n" + " > ");

        option = Integer.parseInt(scanner.nextLine());

        System.out.print("\n Entre com o CPF atual do(a) acompanhante.\n" + " > ");

        current = scanner.nextLine();

        System.out.print("\n Entre com o novo CPF do(a) acompanhante.\n" + " > ");

        companion.CPF = scanner.nextLine();

        switch (option) {

            case 1:
                System.out.print("\n Entre com o nome do(a) acompanhante.\n" + " > ");

                companion.name = scanner.nextLine();

                System.out.print("\n Entre com o RG.\n" + " > ");

                companion.REG = scanner.nextLine();

                System.out.print("\n Entre com o sexo.\n" + " > ");

                companion.sex = scanner.nextLine();

                System.out.print("\n Entre com o parentesco.\n" + " > ");

                companion.kinship = scanner.nextLine();

                CompanionDAO.update(companion, current, option);

                break;
            case 2:
                System.out.print("\n Entre com o e-mail.\n" + " > ");

                companion.email = scanner.nextLine();

                System.out.print("\n Entre com o número do telefone.\n" + " > ");

                companion.phone = scanner.nextLine();

                CompanionDAO.update(companion, current, option);

                break;
        }
    }

    public static void select(String CPF) {

        List<Companion> list = new ArrayList<>();

        list = CompanionDAO.select(CPF);

        System.out.println(" Informações do(a) Acompanhante\n");

        System.out.println(" Nome: " + list.get(0).name);
        System.out.println(" Sexo: " + list.get(0).sex);
        System.out.println(" CPF: " + list.get(0).CPF);
        System.out.println(" REG: " + list.get(0).REG);
        System.out.println(" Parentesco: " + list.get(0).kinship);
        System.out.println(" E-mail: " + list.get(0).email);
        System.out.println(" Telefone: " + list.get(0).phone + "\n");

        System.out.println(" -----------------------------------\n");
    }
}
