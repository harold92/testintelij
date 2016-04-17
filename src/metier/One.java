package metier;

import DAO.EpreuveDAO;
import DAO.ProfDAO;
import DAO.convocationDAO;
import entité.Epreuve;
import entité.Prof;
import entité.convocation;
import org.omg.CORBA.OBJECT_NOT_EXIST;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

public class One {

    public static void main(String[] args) throws SQLException {
        EpreuveDAO epreuveDAO = new EpreuveDAO();
        ProfDAO profDAO = new ProfDAO();
        One one = new One();
        one.partage(epreuveDAO.getAllEp(), profDAO.getAllprof(), profDAO.getAll());
    }

    public void partage(ArrayList<Epreuve> epreuves, ArrayList<Prof> listeProf, ArrayList<Prof> profwithattr) throws SQLException {
        convocationDAO convocationDAO = new convocationDAO();
        ArrayList<convocation> listconvocation = new ArrayList<>();
        int A = 0;
        int b=0;
        int d=0;

        boolean contain = false;

        for (Epreuve ep : epreuves) {
//             System.out.println(ep.getMatiereEP()+" "+ep.getSal()+" "
//                     +ep.getCap()+" "+ep.getHeurEp()+" "+ep.getDateEp());

            // for (int i = 0; i < getNbEnseignant(ep.getCap()); i++)
            int NBS = getNbEnseignant(ep.getCap());
            while (NBS > 0) {

                A++;
                if (A >= listeProf.size())
                    A = 0;

//                System.out.println(ep.getSal()+" "+getNbEnseignant(ep.getCap())+" "+ep.getDateEp()+" "+
//                        ep.getHeurEp()+" "+ep.getMatiereEP()+" "+listeProf.get(A).getStatut());
//                //System.out.println(A);
//                    if (listconvocation.contains(listeProf.get(i).getNom())){
//                        listconvocation.get(i).getHeur().add(ep.getHeurEp());
//                        listconvocation.get(i).getDate().add(ep.getDateEp());
//                    }
//                else {
//                for (Prof pp: profwithattr ){
//                    if (ep.getMatiereEP()==pp.getMat()){
//                convocation convocation = new convocation(pp.getNom(), ep.getDateEp(), ep.getHeurEp(), ep.getSal());
//                listconvocation.add(convocation);
//                    }
//                }
//                convocation convocation = new convocation(listeProf.get(A).getNom(), ep.getDateEp(),
//                       ep.getHeurEp(), ep.getSal(),listeProf.get(A).getHeur_Surveillance());
//                listconvocation.add(convocation);
                /*
                * la convocation de maniere aleatoire, 70%fausse
                * */
                convocation convocation = null;
                if (ep.getHeurEp().equals("8H-10H") | ep.getHeurEp().equals("10H-12H")) {
                    if (listeProf.get(A).getStatut().equals("PTP")) {
                       // listeProf.get(A).setHeur_Surveillance(1);
                        convocation = new convocation(listeProf.get(A).getNom(), ep.getDateEp(),
                                ep.getHeurEp(), ep.getSal(), listeProf.get(A).getHeur_Surveillance());

                        for (convocation con : listconvocation) {
                            b++;
                            if (con.getHeur().equals(convocation.getHeur()) &
                                    con.getDate().equals(convocation.getDate())) {
                                // System.out.println("deja pris");
                            }
                            //si une convocation de meme nom existe ne recreer mais augmente juste ses heur de surveillance
                            if (con.getNom().equals(convocation.getNom())) {
                                con.setDate(convocation.getDate().toString());
                                con.setHeur(convocation.getHeur().toString());

                                // break;
                            }
                        }

                        if (contain == false) {
                                convocationDAO.AddEpreuve(convocation);
                            listconvocation.add(convocation);
                            NBS--;
                        }
                    }


                } else if (ep.getHeurEp().equals("15H-17H") | ep.getHeurEp().equals("17H-19H")) {
                    if (listeProf.get(A).getStatut().equals("VAC") | listeProf.get(A).getStatut().equals("PTP")) {
                        convocation = new convocation(listeProf.get(A).getNom(), ep.getDateEp(),
                                ep.getHeurEp(), ep.getSal(), listeProf.get(A).getHeur_Surveillance());
                        listeProf.get(A).setHeur_Surveillance(1);
                        if (listeProf.get(A).getHeur_Surveillance() <= 8) {
                            /// System.out.println("deja pris");
                        } else
                            for (convocation con : listconvocation) {
                                d++;
                                if (con.getHeur().equals(convocation.getHeur()) &
                                        con.getDate().equals(convocation.getDate()) &
                                        con.getNom().equals(convocation.getNom())) {
                                    con.setDate(convocation.getDate().get(d).toString());
                                    con.setHeur(convocation.getHeur().get(d).toString());
                                }
                                if (con.getNom().equals(convocation.getNom())) {
                                    if (!con.getHeur().contains(convocation.getDate().get(A))&
                                            !con.getDate().contains(convocation.getDate().get(A))){
                                    con.setDate(convocation.getDate().toString());
                                    con.setHeur(convocation.getHeur().toString());
                                    }

                                   // break;
                                }
                            }

                        if (contain == false) {
                            convocationDAO.AddEpreuve(convocation);
                            listconvocation.add(convocation);
                            NBS--;
                        }


                    }

                }
//
//                listeProf.get(A).setHeur_Surveillance(1);
//
//                convocation convocation = new convocation(listeProf.get(A).getNom(), ep.getDateEp(),
//                        ep.getHeurEp(), ep.getSal(),listeProf.get(A).getHeur_Surveillance());
//                listconvocation.add(convocation);
//
//
//                  }
//                System.out.println(listconvocation.get(i).getNom()+" "+listconvocation.get(i).getDate()+" "
//                        +listconvocation.get(i).getSall()+" "+listconvocation.get(i).getHeur());
//
// System.out.println(listconvocation.get(z).getNom()+" "+listconvocation.get(z).getDate().toString()
//                   +" "+listconvocation.get(z).getHeur().toString()+" "+getNbEnseignant(epreuves.get(z).getCap())+" "+
//                   listconvocation.get(z).getSall());
                //  c++;
//               if (listconvocation.isEmpty()){
//                   convocation convocation = new convocation(listeProf.get(i).getNom(),epreuves.get(i).getDateEp()
//                       ,epreuves.get(i).getHeurEp());
//                   listconvocation.add(convocation);
//                    tab = listconvocation.toArray();
//                 }
//               else if(tab.equals(listeProf.get(i).getNom())) {
//
//                   listconvocation.get(i).setDate(epreuves.get(y).getDateEp());
//                   listconvocation.get(i).setHeur(epreuves.get(y).getHeurEp());
//              }

//                convocation convocation = new convocation(listeProf.get(c).getNom(),epreuves.get(c).getDateEp()
//                      ,epreuves.get(c).getHeurEp(),"salle"+c);
//                  listconvocation.add(convocation);
//
//                  //  c=i;
//                if (y<epreuves.size() && i==epreuves.get(i).getCap()){
//                    A=0;
//                }
            }
            //System.out.println("tour fini");
//                //A=c;
        }

        HashSet<convocation> donpp = new HashSet();
        ArrayList<convocation> newiste= new ArrayList<>();
        for (int c = 0; c < listconvocation.size()-1; c++) {

            if (listconvocation.get(c).getNom().equals(listconvocation.get(c+1).getNom())){
              //  listconvocation.get(c).getHeur().add(listconvocation.get(c+1).getHeur().get(c+1));
            convocation con = new convocation(listconvocation.get(c).getNom(),listconvocation.get(c).getDate().get(c).toString(),
                    listconvocation.get(c).getHeur().get(c).toString(),listconvocation.get(c).getSall(),listconvocation.get(c).getHeurS());
           newiste.add(listconvocation.get(c));}
//            System.out.println(listconvocation.get(c).getNom() + " " + listconvocation.get(c).getDate().toString()
//                    + " " + listconvocation.get(c).getHeur().toString() + " " +
//                    listconvocation.get(c).getSall()+" "+c+" "+listconvocation.get(A).getHeurS());
         System.out.println(listconvocation.get(c).getNom());
            for (int i = 0; i < listconvocation.get(c).getHeur().size(); i++) {
                System.out.println(listconvocation.get(c).getDate().toString()
                        + " " + listconvocation.get(c).getHeur().toString() + " " +
                        listconvocation.get(c).getSall() + " " + c + " " + listconvocation.get(A).getHeurS());
//
}
        }

            ArrayList<convocation> ll = new ArrayList<>();
            for (int i=0;i<listconvocation.size()-1;i++){
                if (listconvocation.get(i).getNom().equals(listconvocation.get(i+1).getNom())){
                    System.out.println(listconvocation.get(i).getNom());
                    for (int r=0;r<listconvocation.get(i+1).getDate().size();r++){

                        listconvocation.get(i).setDate(listconvocation.get(i+1).getDate().get(r).toString());
                        listconvocation.get(i).setHeur(listconvocation.get(i+1).getHeur().get(r).toString());
                        ll.add(listconvocation.get(i));
                    }
                }
              //  System.out.println(newiste.get(i).getNom());
                for (int q=0;q<ll.size();q++){
                    System.out.println(ll.get(q).getDate().get(q).toString()+" "+
                    ll.get(q).getHeur().get(q).toString());
                }
                   }

//            if (listconvocation.get(c).getNom().equals(listconvocation.get(c+1).getNom())) {
//                System.out.println(listconvocation.get(c).getNom());
//            }
//                listconvocation.get(c).setHeur(listconvocation.get(c + 1).getHeur().get(c).toString());
//                listconvocation.get(c).setDate(listconvocation.get(c + 1).getDate().get(c).toString());
//            }

//            for (int i=0;i<listconvocation.get(c).getDate().size();i++){
//                System.out.println(listconvocation.get(i).getNom() + " " + listconvocation.get(i).getDate().toString()
//                    + " " + listconvocation.get(i).getHeur().toString() + " " + listconvocation.get(i).getSall());
//
//            }
        }



    public ArrayList<convocation> alea(int i, ArrayList<convocation> con, Epreuve ep,
                                       ArrayList<Prof> listprof) {
        convocation convocation = new convocation(listprof.get(i).getNom(), ep.getDateEp(),
                ep.getHeurEp(), ep.getSal(), listprof.get(i).getHeur_Surveillance());
        con.add(convocation);
        return con;
    }

    public int getNbEnseignant(int capacite) {
        if (capacite <= 25)
            return 2;
        if (capacite > 25 && capacite <= 50)
            return 4;
        if (capacite > 50 && capacite <= 75)
            return 6;
        if (capacite > 75 && capacite <= 90)
            return 8;
        if (capacite > 90 && capacite <= 115)
            return 10;
        if (capacite > 115 && capacite <= 135)
            return 12;
        if (capacite > 135 && capacite <= 200)
            return 14;
        if (capacite > 200 && capacite <= 300)
            return 18;

        return 0;

    }
}
