package entité;

import java.util.ArrayList;

public class Epreuve {

    private String NomEp;
    private String DateEp;
    private String HeurEp;
    private int MatiereEp;
    private String matiereEP;
    private ArrayList<Salle> salles;
    private int typeE;
    private String sal;
    private int cap;

    public Epreuve(String dateEp, String heurEp, String matiereEP, String sal, int cap) {
        DateEp = dateEp;
        HeurEp = heurEp;
        this.matiereEP = matiereEP;
        this.sal = sal;
        this.cap = cap;
    }

    public Epreuve(String dateEp, String heurEp, int matiereEp, int type) {
        MatiereEp = matiereEp;
        DateEp = dateEp;
        HeurEp = heurEp;
        typeE = type;
    }

    public Epreuve(String dateEp, String heurEp, String matiereSS, int type) {
        matiereEP = matiereSS;
        DateEp = dateEp;
        HeurEp = heurEp;
        typeE = type;
    }

    public Epreuve(String dateEp, String heurEp, int matiereEp) {
        DateEp = dateEp;
        HeurEp = heurEp;
        MatiereEp = matiereEp;
    }
    //    public Epreuve(String dateEp, String heurEp, String matiereEp, ArrayList<Salle> salleEp) {
//       //this.DateEp = dateEp;
//        this.HeurEp = heurEp;
//        this.MatiereEp = matiereEp;
//        this.salles= salleEp;
//    }


    public String getSal() {
        return sal;
    }

    public int getCap() {
        return cap;
    }
    public int getTypeE() {
        return typeE;
    }

    public String getNomEp() {
        return NomEp;
    }

    public String getMatiereEP() {
        return matiereEP;
    }

    public String getDateEp() {
        return DateEp;
    }

    public String getHeurEp() {
        return HeurEp;
    }

    public int getMatiereEp() {
        return MatiereEp;
    }

    public ArrayList<Salle> getSalles() {
        return salles;
    }


}
