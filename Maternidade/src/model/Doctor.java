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

    public static String repairCrm(String crm) throws ValorInvalidoException {
        String repairedCrm = crm.trim().replaceAll(" +", " ");
        for (int i = 0; i < repairedCrm.length(); i++) {
            char ch = repairedCrm.charAt(i);
            if (!(Character.isLetterOrDigit(ch) || ch == ' ')) {
                throw new ValorInvalidoException("CRM do médico inválido:\n"
                        + "Ele deve conter apenas letras, números e espaços");
            }
        }
        return repairedCrm;
    }

    public void setCrm(String crm) throws ValorInvalidoException {
        this.crm = repairCrm(crm);

    }

    public String getName() {
        return name;
    }

    public static String repairName(String name) throws ValorInvalidoException {
        String repairedName = name.trim().replaceAll(" +", " ");
        for (int i = 0; i < repairedName.length(); i++) {
            char ch = repairedName.charAt(i);
            if (!(Character.isLetter(ch) || ch == ' ')) {
                throw new ValorInvalidoException("Nome do médico inválido:\n"
                        + "Ele deve conter apenas letras e espaços");
            }
        }
        return repairedName;
    }

    public void setName(String name) throws ValorInvalidoException {
        this.name = repairName(name);
    }

    public String getSpeciality() {
        return speciality;
    }

    public static String repairSpecialty(String specialty) throws ValorInvalidoException {
        String repairedSpecialty = specialty.trim().replaceAll(" +", " ");
        for (int i = 0; i < repairedSpecialty.length(); i++) {
            char ch = repairedSpecialty.charAt(i);
            if (!(Character.isLetter(ch) || ch == ' ')) {
                throw new ValorInvalidoException("Especialidade do médico inválida:"
                        + "\nEla deve conter apenas letras e espaços");
            }
        }
        return repairedSpecialty;
    }

    public void setSpeciality(String speciality) throws ValorInvalidoException {
        this.speciality = repairSpecialty(speciality);
    }
}
