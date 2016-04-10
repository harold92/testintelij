package entité;

public class Salle {
    private int typesalID;
    private String nom;
    private  String site;
    private int capacite;

    public Salle(String nom) {
        this.nom = nom;
    }

    public Salle(int typesalID, String nom, String site, int capacite) {
        this.typesalID = typesalID;
        this.nom = nom;
        this.site = site;
        this.capacite = capacite;
    }


    public String getSite() {
        return site;
    }

    public String getNom() {
        return nom;
    }

    public int getCapacite() {
        return capacite;
    }

    public int getTypesalID() {
        return typesalID;
    }
}
