package model;

public class Doctor {

    public static int TAM_MAX_CRM = 15;
    public static int TAM_MAX_ESPECIALIDADE = 50;
    public static int TAM_MAX_NOME = 35;
    private String crm;
    private String name;
    private String speciality;

    public String getCrm() {
        return crm;
    }

    private static boolean trimmedCrmIsValid(String trimmedCrm) {
        for (int i = 0; i < trimmedCrm.length(); i++) {
            char ch = trimmedCrm.charAt(i);
            if (!Character.isLetterOrDigit(ch) && ch != ' ') {
                return false;
            }
        }
        return true;
    }

    public static String trimCrm(String crm) throws ValorInvalidoException {
        String trimCrm = crm.trim().replaceAll(" +", " ");
        if (trimmedCrmIsValid(trimCrm)) {
            return trimCrm;
        } else {
            throw new ValorInvalidoException("CRM do médico inválido:\n"
                    + "Ele deve conter apenas letras, números e espaços");
        }
    }

    public void setCrm(String crm) throws ValorInvalidoException {
        this.crm = trimCrm(crm);

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
            throw new ValorInvalidoException("Nome do médico inválido:\n"
                    + "Ele deve conter apenas letras e espaços");
        }
    }

    public void setName(String name) throws ValorInvalidoException {
        this.name = trimName(name);
    }

    public String getSpeciality() {
        return speciality;
    }

    private static boolean trimmedSpecialtyIsValid(String trimmedSpecialty) {
        for (int i = 0; i < trimmedSpecialty.length(); i++) {
            char ch = trimmedSpecialty.charAt(i);
            if (!Character.isLetter(ch) && ch != ' ') {
                return false;
            }
        }
        return true;
    }

    public static String trimSpecialty(String specialty) throws ValorInvalidoException {
        String formattedSpecialty = specialty.trim().replaceAll(" +", " ");
        if (trimmedSpecialtyIsValid(formattedSpecialty)) {
            return formattedSpecialty;
        } else {
            throw new ValorInvalidoException("Especialidade do médico inválida:"
                    + "\nEla deve conter apenas letras e espaços");
        }
    }

    public void setSpeciality(String speciality) throws ValorInvalidoException {
        this.speciality = trimSpecialty(speciality);
    }
}
