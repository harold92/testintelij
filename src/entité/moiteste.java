package entité;

import java.util.ArrayList;

/**
 * Created by rhef on 4/4/16.
 */
public class moiteste {

    String Heur;String date;String matiere;ArrayList salle;

    public String getHeur() {
        return Heur;
    }

    public String getDate() {
        return date;
    }

    public String getMatiere() {
        return matiere;
    }

    public ArrayList getSalle() {
        return salle;
    }

    public moiteste(String heur, String date, String matiere, ArrayList salle) {
        this.Heur = heur;
        this.date = date;
        this.matiere = matiere;
        this.salle = salle;
    }
}
