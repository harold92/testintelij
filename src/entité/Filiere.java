package entité;

public class Filiere {

    private String nomF;
    private String Faculte;

    public String getNomF() {
        return nomF;
    }

    public String getFaculte() {
        return Faculte;
    }

    public Filiere(String nomF, String faculte) {

        this.nomF = nomF;
        Faculte = faculte;
    }
}
