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

    private static boolean trimmedRgIsValid(String trimmedRg) {
        for (int i = 0; i < trimmedRg.length(); i++) {
            char ch = trimmedRg.charAt(i);
            if (!Character.isLetterOrDigit(ch) && ch != ' ') {
                return false;
            }
        }
        return true;
    }
    
    public static String trimRg(String rg) throws ValorInvalidoException {
        String trimRg = rg.replaceAll(" +", " ");
        if (trimmedRgIsValid(trimRg)) {
            return trimRg;
        } else {
            throw new ValorInvalidoException("RG da mãe inválido: ele deve "
                        + "conter apenas letras, números e espaços.");
        }
    }

    public void setRg(String rg) throws ValorInvalidoException {
        this.rg = trimRg(rg);
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
        String trimmedName = name.trim().replaceAll(" +", " ");
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
