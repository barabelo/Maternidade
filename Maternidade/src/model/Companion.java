package model;

import java.util.Objects;
import org.apache.commons.validator.routines.EmailValidator;

public class Companion {

    public static int TAM_MAX_CPF = 14;
    public static int TAM_MAX_RG = 15;
    public static int TAM_MAX_NAME = 50;
    public static int TAM_MAX_SEX = 10;
    public static int TAM_MAX_KINSHIP = 20;
    public static int TAM_MAX_EMAIL = 50;
    public static int TAM_MAX_PHONE = 15;
    public static int TAM_MAX_MOTHER_ID = 14;

    private String cpf;
    private String rg;
    private String name;
    private String sex;
    private String kinship;
    private String email;
    private String phone;
    private String motherCpf;

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
                throw new ValorInvalidoException("RG do acompanhante inválido:\nEle deve "
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
                throw new ValorInvalidoException("Nome do acompanhante inválido:\n"
                        + "Ele deve conter apenas letras e espaços");
            }
        }
        return repairedName;
    }

    public void setName(String name) throws ValorInvalidoException {
        this.name = repairName(name);
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

    public static String repairKinship(String kinship) throws ValorInvalidoException {
        String repairedKinship = kinship.replaceAll(" +", " ");
        for (int i = 0; i < repairedKinship.length(); i++) {
            char ch = repairedKinship.charAt(i);
            if (!(Character.isLetter(ch) || ch == ' ')) {
                throw new ValorInvalidoException("Parentesco do acompanhante inválido:\n"
                        + "Ele deve conter apenas letras e espaços");
            }
        }
        return repairedKinship;
    }

    public void setKinship(String kinship) throws ValorInvalidoException {
        this.kinship = repairKinship(kinship);
    }

    public String getEmail() {
        return email;
    }

    public static String repairEmail(String email) throws ValorInvalidoException {
        String repairedEmail = email.trim();
        if (EmailValidator.getInstance().isValid(email)) {
            return repairedEmail;
        } else {
            throw new ValorInvalidoException("Email inválido");
        }
    }

    public void setEmail(String email) throws ValorInvalidoException {
        this.email = repairEmail(email);
    }

    public String getPhone() {
        return phone;
    }

    public static String repairPhone(String phone) {
        String repairedPhone = phone.trim().replaceAll(" +", " ");
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMotherCpf(String motherCpf) {
        this.motherCpf = motherCpf;
    }

    public String getMotherCpf() {
        return motherCpf;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.cpf);
        hash = 83 * hash + Objects.hashCode(this.rg);
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.sex);
        hash = 83 * hash + Objects.hashCode(this.kinship);
        hash = 83 * hash + Objects.hashCode(this.email);
        hash = 83 * hash + Objects.hashCode(this.phone);
        hash = 83 * hash + Objects.hashCode(this.motherCpf);
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
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
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
        if (!Objects.equals(this.motherCpf, other.motherCpf)) {
            return false;
        }
        return true;
    }

}
