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
        String trimmedRg = rg.replaceAll(" +", "");
        if (trimmedRgIsValid(trimmedRg)) {
            return trimmedRg;
        } else {
            throw new ValorInvalidoException("RG do acompanhante inválido: ele deve "
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
            throw new ValorInvalidoException("Nome do acompanhante inválido: "
                    + "ele deve conter apenas letras e espaços");
        }
    }

    public void setName(String name) throws ValorInvalidoException {
        this.name = trimName(name);
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

    private static boolean trimmedKinshipIsValid(String trimmedKinship) {
        for (int i = 0; i < trimmedKinship.length(); i++) {
            char ch = trimmedKinship.charAt(i);
            if (!Character.isLetter(ch) && ch != ' ') {
                return false;
            }
        }
        return true;
    }
    
    public static String trimKinship(String kinship) throws ValorInvalidoException {
        String trimmedKinship = kinship.replaceAll(" +", " ");
        if (trimmedKinshipIsValid(trimmedKinship)) {
            return trimmedKinship;
        } else {
            throw new ValorInvalidoException("Parentesco do acompanhante inválido: "
                        + "ele deve conter apenas letras e espaços");
        }
    }

    public void setKinship(String kinship) throws ValorInvalidoException {
        this.kinship = trimKinship(kinship);
    }

    public String getEmail() {
        return email;
    }

    public static String trimEmail(String email) throws ValorInvalidoException {
        String repairedEmail = email.trim();
        if (EmailValidator.getInstance().isValid(email)) {
            return repairedEmail;
        } else {
            throw new ValorInvalidoException("Email do acompanhante inválido.");
        }
    }

    public void setEmail(String email) throws ValorInvalidoException {
        this.email = trimEmail(email);
    }

    public String getPhone() {
        return phone;
    }

    private static boolean trimmedPhoneIsValid(String trimmedPhone) {
        return trimmedPhone.matches("(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})");
    }
    
    public static String formatPhone(String phone) throws ValorInvalidoException {
        String trimmedPhone = phone.trim().replaceAll(" +", " ");
        if (trimmedPhoneIsValid(trimmedPhone)) {
            String[] phoneParts = phone.split(" ");
            if (phoneParts.length > 1) {
                StringBuilder formattedPhone = new StringBuilder();
                formattedPhone.append("(");
                formattedPhone.append(phoneParts[0]);
                formattedPhone.append(")");
                formattedPhone.append(phoneParts[1]);
                return formattedPhone.toString();
            } else {
                return trimmedPhone;
            }
        } else {
            throw new ValorInvalidoException("Telefone do acompanhante "
                    + "inválido. Digite-o em um destes formatos:\n(xx) "
                    + "xxxxx-xxxx\n(xx) xxxx-xxxx\nxx xxxxx-xxxx\nxx "
                    + "xxxx-xxxx\nxxxxx-xxxx\nxxxx-xxxx");
        }
    }

    public void setPhone(String phone) throws ValorInvalidoException {
        this.phone = formatPhone(phone);
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
