package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baby {

    private String id;
    private String name;
    private String birthday;
    private String sex;
    private String MCPF;

    private double height;
    private double weight;

    static Scanner scanner = new Scanner(System.in);

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

    public String getBirthday() {

        return birthday;
    }

    public void setBirthday(String birthday) {

        this.birthday = birthday;
    }

    public String getSex() {

        return sex;
    }

    public void setSex(String sex) {

        this.sex = sex;
    }

    public String getMCPF() {

        return MCPF;
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

    public static void insert() {

        Baby baby = new Baby();

        System.out.print("\n Entre com o identificador do(a) recém-nascido(a).\n" + " > ");

        baby.id = scanner.nextLine();

        System.out.print("\n Entre com o nome do(a) recém-nascido(a).\n" + " > ");

        baby.name = scanner.nextLine();

        System.out.print("\n Entre com a data de nascimento.\n" + " > ");

        baby.birthday = scanner.nextLine();

        System.out.print("\n Entre com o sexo.\n" + " > ");

        baby.sex = scanner.nextLine();

        System.out.print("\n Entre com o CPF da mãe.\n" + " > ");

        baby.MCPF = scanner.nextLine();

        System.out.print("\n Entre com a altura do(a) recém-nascido(a).\n" + " > ");

        baby.height = Double.parseDouble(scanner.nextLine());

        System.out.print("\n Entre com o peso do(a) recém-nascido(a).\n" + " > ");

        baby.weight = Double.parseDouble(scanner.nextLine());

        BabyDAO.insert(baby);
    }

    public static void update() {

        String current;

        Baby baby = new Baby();

        System.out.print("\n Entre com o identificador atual do(a) recém-nascido(a).\n" + " > ");

        current = scanner.nextLine();

        System.out.print("\n Entre com o novo identificadordo(a) recém-nascido(a).\n" + " > ");

        baby.id = scanner.nextLine();

        System.out.print("\n Entre com o nome do(a) recém-nascido(a).\n" + " > ");

        baby.name = scanner.nextLine();

        System.out.print("\n Entre com a data de nascimento.\n" + " > ");

        baby.birthday = scanner.nextLine();

        System.out.print("\n Entre com o sexo.\n" + " > ");

        baby.sex = scanner.nextLine();

        System.out.print("\n Entre com a altura do(a) recém-nascido(a).\n" + " > ");

        baby.height = Double.parseDouble(scanner.nextLine());

        System.out.print("\n Entre com o peso do(a) recém-nascido(a).\n" + " > ");

        baby.weight = Double.parseDouble(scanner.nextLine());

        BabyDAO.update(baby, current);
    }

    public static void select(String CPF) {

        List<Baby> list = new ArrayList<>();

        list = BabyDAO.select(CPF);

        if (list.size() == 1) {
            System.out.println(" Informações do(a) Recém-Nascido(a)\n");
        } else {
            System.out.println(" Informações do(s) Recém-Nascido(s)\n");
        }

        for (int i = 0; i < list.size(); i++) {

            System.out.println(" ID: " + list.get(i).id);
            System.out.println(" Nome: " + list.get(i).name);
            System.out.println(" Sexo: " + list.get(i).sex);
            System.out.println(" Altura: " + list.get(i).height + " cm");
            System.out.println(" Peso: " + list.get(i).weight + " kg");
            System.out.println(" Nascimento: " + list.get(i).birthday + "\n");
        }

        System.out.println(" -----------------------------------\n");
    }
}
