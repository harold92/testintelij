package entité;

import java.util.ArrayList;


public class convocation {
    String nom;
    private ArrayList heur = new ArrayList();
    private ArrayList date = new ArrayList();
    private ArrayList sal = new ArrayList();
    private String departement;
    private String nomDoyen;
    private String sall;

    public ArrayList getSal() {
        return sal;
    }

    private int HeurS;
    private int NBS;
    private String i;


    public convocation(String i, ArrayList d, ArrayList H, ArrayList S){
        this.heur = H;
        this.date = d;
        this.nom = i;
        this.sal = S;
    }
    public convocation(String i, String departement, String nomDoyen) {
        this.i = i;
        this.departement = departement;
        this.nomDoyen = nomDoyen;
    }

    public convocation(String nom, String date, String heur, String sal, int heurS) {
        this.nom = nom;
        this.date.add(date);
        this.heur.add(heur);
        this.sall = sal;
        this.HeurS = heurS;
        // this.NBS=nbhs;
    }

    public int getHeurS() {
        return HeurS;
    }

    public String getSall() {
        return sall;
    }

    public void setNBS(int NBS) {
        this.NBS = NBS;
    }

    public int getNBS() {
        return NBS;
    }

    public void setDate(String date) {
        getDate().add(date);
    }

    public void setHeur(String heur) {
        getHeur().add(heur);
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList getHeur() {

        return heur;
    }

    public ArrayList getDate() {
        return date;
    }

    public String getDepartement() {
        return departement;
    }

    public String getNomDoyen() {
        return nomDoyen;
    }


}
