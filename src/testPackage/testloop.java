package testPackage;

import entité.Epreuve;
import entité.Salle;

import java.util.ArrayList;


public class testloop {

    public static void main(String[] args)
    {

        int tab[] ={1,3,4,56,54,2,4,55,6,77,8,9,9,9,9};
        for (int i=0;i<tab.length;i++){
            if (tab[i]==9){
                System.out.println(i+" "+tab.length);
                System.out.println(tab[i]);
                break;
            }
        }

//     Salle salle = new Salle(1,"A1","site 1",12);
//       ArrayList<Salle> salleList = new ArrayList<>();
//        salleList.add(salle);
//        Epreuve epreuve = new Epreuve("12-12-2016","8h-10h","arabe",salleList);
//        Epreuve ep1 = new Epreuve("12-12-2016","8h-10h","arabe",salleList);
//        Epreuve ep2 = new Epreuve("12-12-2016","8h-10h","anglais",salleList);
//        Epreuve ep4 = new Epreuve("12-12-2016","8h-10h","francais",salleList);
//        Epreuve ep3 = new Epreuve("12-12-2016","8h-10h","reseau",salleList);
//
//        ArrayList<Epreuve> ep = new ArrayList<>();
//        ep.add(ep1);
//        ep.add(ep2);
//        ep.add(ep3);
//        ep.add(ep4);
//        for (int i=0;i<ep.size();i++){
//        System.out.println(ep.get(i).toString());
//    }
//        ep.clear();

//
//        for (Epreuve ee : ep) {
//          if (ee.getDateEp().equals(epreuve.getDateEp()) && ee.getHeurEp().equals(epreuve.getHeurEp()) && ee.getMatiereEp().equals(epreuve.getMatiereEp()))
//                System.out.println(ee.getMatiereEp()+" "+ee.getHeurEp()+" "+ee.getDateEp());
//            else
//              System.out.println("erreur");
//        }
//
//        ArrayList<String> prof = new ArrayList<>();
//        prof.add(" ");
//        prof.add(" ");
//        prof.add("ali omar");
//        prof.add(" ");
//        ArrayList<String> statut = new ArrayList<>();
//        statut.add("PTP");
//        statut.add("VAC");
//        statut.add("ADM");
//        statut.add("OPtion");
//        for (int i=0;i<prof.size();i++)
//        {
//            System.out.println(prof.get(i)+" "+statut.get(i));
//         //   System.out.println(statut.get(i));
//        }

//        for (int i=0;i<5;i++)
//        {
//            System.out.println("premiere de boucle");
//            for (int j=0;j<4;j++)
//            {
//
//                System.out.println("Deuxieme de boucle");
//            }
//        }
    }
}
