package model;

import java.time.LocalDate;
import java.util.Objects;

public class Mother {

    public static int TAM_MAX_CPF = 14;
    public static int TAM_MAX_RG = 15;
    public static int TAM_MAX_NAME = 50;
    private String cpf;
    private String rg;
    private String name;
    private LocalDate birthday;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public static String repairRg(String rg) throws ValorInvalidoException {
        String repairedRg = rg.replaceAll(" +", " ");
        for (int i = 0; i < repairedRg.length(); i++) {
            char ch = repairedRg.charAt(i);
            if (!(Character.isLetterOrDigit(ch) || ch == ' ')) {
                throw new ValorInvalidoException("RG da mãe inválido:\nEle deve "
                        + "conter apenas letras, números e espaços.");
            }
        }
        return repairedRg;
    }

    public void setRg(String rg) throws ValorInvalidoException {
        this.rg = repairRg(rg);
    }

    public String getName() {
        return name;
    }

    public static String repairName(String name) throws ValorInvalidoException {
        String repairedName = name.trim().replaceAll(" +", " ");
        for (int i = 0; i < repairedName.length(); i++) {
            char ch = repairedName.charAt(i);
            if (!(Character.isLetter(ch) || ch == ' ')) {
                throw new ValorInvalidoException("Nome da mãe inválido:\n"
                        + "Ele deve conter apenas letras e espaços");
            }
        }
        return repairedName;
    }

    public void setName(String name) throws ValorInvalidoException {
        this.name = repairName(name);
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.cpf);
        hash = 29 * hash + Objects.hashCode(this.rg);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.birthday);
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
        final Mother other = (Mother) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.birthday, other.birthday)) {
            return false;
        }
        return true;
    }

}
