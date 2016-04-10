package entité;

public class Prof {

    private String Nom;
    private String email;
    private int tel;
    private String statut;
    private int Heur_Surveillance;
    private String Mat;


    public Prof(String nom, String email, String statut, String mat, int heur_Surveillance) {
        Nom = nom;
        this.Mat = mat;
        this.email = email;
        this.statut = statut;
        Heur_Surveillance = heur_Surveillance;
    }

    public Prof(String nom, String statut, int heur_Surveillance) {
        Nom = nom;
        this.statut = statut;
        Heur_Surveillance = heur_Surveillance;
    }

    public Prof(String nom, String email, String statut) {
        Nom = nom;
        this.email = email;
        this.statut = statut;
    }

    public Prof(String nom, String email, int tel, String statut) {
        Nom = nom;
        this.email = email;
        this.tel = tel;
        this.statut = statut;
    }

    public void setHeur_Surveillance(int heur_Surveillance) {
        Heur_Surveillance = getHeur_Surveillance() + heur_Surveillance;
    }

    public int getHeur_Surveillance() {
        return Heur_Surveillance;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getNom() {
        return Nom;
    }

    public String getEmail() {
        return email;
    }

    public int getTel() {
        return tel;
    }

    public String getStatut() {
        return statut;
    }

    public String getMat() {
        return Mat;
    }

    public void setMat(String mat) {
        Mat = mat;
    }

}
