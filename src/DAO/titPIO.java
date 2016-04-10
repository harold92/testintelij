package DAO;

import entité.*;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class titPIO {


    public static void main(String[] args) throws IOException, SQLException {
        titPIO titPIO = new titPIO();
        titPIO.loadAll();
        //titPIO.salleLoad();
        /*  ArrayList<String> columndata = null;
        ProfDAO profDAO = new ProfDAO();
        try {
            ArrayList<String> prof = new ArrayList<>();
            ArrayList<String> statut = new ArrayList<>();
            ArrayList<String> email = new ArrayList<>();
            ArrayList tel = new ArrayList<>();
            File f = new File("profload.xlsx");
            FileInputStream ios = new FileInputStream(f);
            XSSFWorkbook workbook = new XSSFWorkbook(ios);
            // le classeur de  donnees
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            //columndata = new ArrayList<>();


            while (rowIterator.hasNext()) {
                // une ligne est partage par l'enssemble des colonnes
                Row row = rowIterator.next();
                // ici on accede a une ligne de maniere un plu precise voir determiner son type, son colonne
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    //un row ne peu pas retourner un type et encore moin la colonne dont il s'Agit
                    Cell cell = cellIterator.next();

                    if (row.getLastCellNum() == 5) {
                        if (row.getRowNum() > 0) { //To filter column headings
                            //save cette colonnne dans le champs nom de la table prof
                            if (cell.getColumnIndex() == 0) {// To match column index
                               // System.out.println(row.getLastCellNum());
                                //System.out.println(cell.getStringCellValue());
                                prof.add(cell.getStringCellValue());
                            }
                            //save cette colonnne dans le champs statut  de la table prof
                           if (cell.getColumnIndex() == 1) {// To match column index
                                //System.out.println(row.getLastCellNum());
                                  //System.out.println(cell.getStringCellValue());
                                statut.add(cell.getStringCellValue());
                            }
                            if (cell.getColumnIndex()==2){
                                email.add(cell.getStringCellValue());
                            }
                            if (cell.getColumnIndex()==3){
                                tel.add(cell.getNumericCellValue());
                            }


                        }
                    } else {
                        System.out.println(" le nombre de colonne est superieur ou inferieue");
                    }
               }
            }
            for (int i=0;i<prof.size();i++)
            {
                Prof prof1 = new Prof(prof.get(i),email.get(i),77890056,profDAO.getID(statut.get(i)));
                profDAO.AddProf(prof1);
//                System.out.println(+" ");
//                System.out.println(+" ");
//                System.out.println(+" ");
                System.out.println();

            }
            ios.close();
            //System.out.println(columndata);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    private Sheet init(String file) throws IOException {
        File f = new File(file);
        FileInputStream ios = new FileInputStream(f);
        XSSFWorkbook workbook = new XSSFWorkbook(ios);
        // le classeur de  donnees
        XSSFSheet sheet = workbook.getSheetAt(0);
        return sheet;
    }

    private void salleLoad() throws IOException {
        SalleDAO salleDAO = new SalleDAO();
        Sheet sheet = init(String.valueOf(new File("saload.xlsx")));
        Iterator<Row> rowIterator = sheet.iterator();
        ArrayList salnom = new ArrayList();
        ArrayList site = new ArrayList();
        ArrayList capacite = new ArrayList();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (row.getLastCellNum() == 3) {
                    if (row.getRowNum() > 0) {
                        if (cell.getColumnIndex() == 0) {
                            if (cell.getStringCellValue().equals(" "))
                                salnom.add(" ");
                            else
                                salnom.add(cell.getStringCellValue());
                        }
                        if (cell.getColumnIndex() == 1)

                            capacite.add((int) cell.getNumericCellValue());

                        if (cell.getColumnIndex() == 2) {
                            site.add((int) cell.getNumericCellValue());
                        }
                    }
                }
            }
        }

        for (int i = 0; i < site.size(); i++) {
            Salle salle = new Salle(1, (String) salnom.get(i), "site " + site.get(i), (int) capacite.get(i));
            try {
                salleDAO.AddSalle(salle);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // System.out.println(salnom.get(i)+" "+capacite.get(i)+" "+site.get(i));
        }

    }

    private void testload() throws IOException {
        Sheet sheet = init(String.valueOf(new File("testload.xlsx")));
        Iterator<Row> rowIterator = sheet.iterator();
        ArrayList list1 = new ArrayList();
        ArrayList list = new ArrayList();
        ArrayList list3 = new ArrayList();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                if (row.getLastCellNum() == 3) {
                    //  if (row.getRowNum()>0){
                    if (cell.getColumnIndex() == 0) {
                        System.out.println(cell.getStringCellValue());
                        if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
                            list.add("qli ");
                        } else {
                            list.add(cell.getStringCellValue());
                        }

                    }
                    if (cell.getColumnIndex() == 1) {
                        System.out.println(cell.getStringCellValue());
                        if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
                            System.out.println(cell.CELL_TYPE_BLANK);
                            //list1.add("qli ");
                        } else {
                            list1.add(cell.getStringCellValue());
                        }
                    }
                    if (cell.getColumnIndex() == 2) {
                        System.out.println(cell.getStringCellValue());
                        if (cell.getCellType() == cell.CELL_TYPE_BLANK) {

                            System.out.println(cell.CELL_TYPE_BLANK);
                            //list3.add(" qli");
                            //
                        } else {
                            list3.add(cell.getStringCellValue());
                        }
                    }
                }
            }
        }

//        for (int i=0;i<list1.size();i++)
//        {
//
//           System.out.println(list1.size()+""+list.get(i)+" "+list1.get(i)+" "+list3.get(i));
//        }
    }

    public void loadAll() throws IOException, SQLException {
        Sheet sheet = init("all.xlsx");
        EpreuveDAO epreuveDAO = new EpreuveDAO();
        ProfDAO profDAO = new ProfDAO();
        ArrayList Enseignant = new ArrayList();
        ArrayList matprof = new ArrayList();
        MatiereDOA matDOA = new MatiereDOA();
        Iterator<Row> rowIterator = sheet.iterator();
        HashSet HasMatiere = new HashSet();
        ArrayList MatiereEE = new ArrayList();
        ArrayList<String> dateE = new ArrayList();
        ArrayList heurE = new ArrayList();
        ArrayList MatiereE = new ArrayList();
        ArrayList sal1 = new ArrayList();
        ArrayList sal2 = new ArrayList();
        ArrayList sal3 = new ArrayList();
        ArrayList sal4 = new ArrayList();
        HashSet hasprof = new HashSet();
        ArrayList PROFn = new ArrayList();
        ArrayList PROFStatut = new ArrayList();
        ProfDAO matiereDOA = new ProfDAO();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                if (row.getRowNum() > 0) {
                    if (cell.getColumnIndex() == 4) {

//                        HasMatiere.add(cell.getStringCellValue());
//                        for (int i=0;i<HasMatiere.size();i++){
//                       // Matiere.add(HasMatiere.toString());
//
//                        }
                    }

                    if (cell.getColumnIndex() == 2) {
                        dateE.add(cell.getStringCellValue());
                    }
                    if (cell.getColumnIndex() == 3) {

                        heurE.add(cell.getStringCellValue());
                    }
                    if (cell.getColumnIndex() == 4) {
                        MatiereE.add(cell.getStringCellValue());
                        matprof.add(cell.getStringCellValue());
                    }
                    if (cell.getColumnIndex() == 10) {
//                        if (cell.getStringCellValue().isEmpty())
//                            sal1.add("null");
//                        else
                        sal1.add(cell.getStringCellValue());
                    }
                    if (cell.getColumnIndex() == 11) {
//                        if (cell.getStringCellValue().isEmpty())
//                            sal2.add("null");
//                        else
                        sal2.add(cell.getStringCellValue());
                    }
                    if (cell.getColumnIndex() == 12) {
//                        if (cell.getStringCellValue().isEmpty())
//                            sal3.add("null");
//                        else
                        sal3.add(cell.getStringCellValue());
                    }
                    if (cell.getColumnIndex() == 13) {
//                        if (cell.getStringCellValue().isEmpty())
//                            sal4.add("null");
//                        else
                        sal4.add(cell.getStringCellValue());
                    }
                    if (cell.getColumnIndex() == 8) {
                        hasprof.add(cell.getStringCellValue());
                        Enseignant.add(cell.getStringCellValue());
                    }
                    if (cell.getColumnIndex() == 9) {
                        PROFStatut.add(cell.getStringCellValue());
                    }


                }
            }

        }
        /*
        * ici j'enregistre les epreuve dans la base via des objet de type Epreuve
        * */

        ArrayList<Epreuve> lisss = new ArrayList();
        for (int i = 0; i < dateE.size(); i++) {
            Epreuve epreuve = new Epreuve(dateE.get(i), heurE.get(i).toString(),  matDOA.getID(MatiereE.get(i).toString()),1);
            if (!lisss.contains(epreuve)){
                lisss.add(epreuve);
               // epreuveDAO.AddEpreuve(epreuve);
            }
        }
        /*
        * cette boucle me sert de teste pour voir tout marche comme prevu
        *
        for (Epreuve ep: lisss) {

            Epreuve epreuve = new Epreuve(ep.getDateEp(), ep.getHeurEp().toString(), matiereDOA.getID(String.valueOf(ep.getMatiereEp())), 1);

            epreuveDAO.AddEpreuve(epreuve);
            System.out.println(ep.getMatiereEP()+" "+ep.getDateEp()+" "+ep.getHeurEp());

        } */



/* d'abord je fait un hashset de liste de prof pour eviter les repetition
   ensuite j'enregistre dans un Arraylist,je teste que tout marche
   sur la console et enfin je cree un objet prof puis enregistre ce dernier
   dans la base.

  */
// int y=0;
//        for (Object ob : hasprof){
//            y++;
//            PROFn.add(ob);
//         //   System.out.println(ob +" "+PROFStatut.get(y));
//            Prof prof = new Prof(String.valueOf(ob),"",+25377,(String) PROFStatut.get(y));
//            profDAO.AddProf(prof);
//
//        }
        /*
        * ici j'essaie de teste la vitesse de mysql(si elle repond vite:
        * retourner les donnees enregistre avec la boucle precedente )
        * */
//        for (int i=0;i<profDAO.getAll().size();i++){
//            System.out.println(i+" "+profDAO.getAll().get(i));
//        }
        /*
        * pareil que l'hashset precedent, cette fois il s'agit de matiere
        * puis j'enregistre dans la table matiere de la base
        * */

        for (int i = 0; i < MatiereE.size(); i++) {
            HasMatiere.add(MatiereE.get(i));
        }

        for (Object set : HasMatiere) {
            ///System.out.println(set.toString());
            MatiereEE.add(String.valueOf(set));
        }
        for (int i = 0; i < MatiereEE.size(); i++) {
            Matiere matiere = new Matiere("" + MatiereEE.get(i) + "");
            //matDOA.AddMat((String) matiere.getNomM());
            // System.out.println(MatiereEE.get(i));
        }


/**
 * ici j'essaie de relier les salles et les epreuves
 // */
        // System.out.println(dateE.size());
        ArrayList<moiteste> listD = new ArrayList();
        ArrayList<String> listH = new ArrayList();
        ArrayList listM = new ArrayList();
        ArrayList listS1 = new ArrayList();
        ArrayList listS2 = new ArrayList();
        ArrayList listS3 = new ArrayList();
        ArrayList listS4 = new ArrayList();
        for (int i = 0; i < dateE.size(); i++) {
            // System.out.println(dateE.get(i) + " " + heurE.get(i) + " " + MatiereE.get(i) + " " + sal1.get(i) + " " + sal2.get(i) + " " + sal3.get(i) + " " + sal4.get(i));
            if (!sal1.get(i).toString().isEmpty()) {
                listS1 = new ArrayList();
                listS1.add(sal1.get(i));
                moiteste moiteste = new moiteste(dateE.get(i), (String) heurE.get(i), (String) MatiereE.get(i), listS1);
                listD.add(moiteste);
                listS1 = null;
            }
            if (!sal2.get(i).toString().isEmpty()) {
                listS2 = new ArrayList();
                listS2.add(sal2.get(i));
                moiteste moiteste = new moiteste(dateE.get(i), (String) heurE.get(i), (String) MatiereE.get(i), (listS2));
                listD.add(moiteste);
                listS2 = null;
            }
            if (!sal3.get(i).toString().isEmpty()) {
                listS3 = new ArrayList();
                listS3.add(sal3.get(i));
                moiteste moiteste = new moiteste(dateE.get(i), (String) heurE.get(i), (String) MatiereE.get(i), listS3);
                listD.add(moiteste);
                listS3 = null;
            }
            if (!sal4.get(i).toString().isEmpty()) {
                listS4 = new ArrayList();
                listS4.add(sal4.get(i));
                moiteste moiteste = new moiteste(dateE.get(i), (String) heurE.get(i), (String) MatiereE.get(i), listS4);
                listD.add(moiteste);
                listS4 = null;
            }


        }
//        SalleDAO salleDAO = new SalleDAO();
//        HashSet has = new HashSet();
//        HashSet has2 = new HashSet();
//        HashSet has3 = new HashSet();
//        ArrayList list = new ArrayList();
//        for (int i = 0; i < listD.size(); i++) {
//            // System.out.println(listD.get(i).getMatiere()+" "+listD.get(i).getDate()+" "+listD.get(i).getHeur()+" "+listD.get(i).getSalle());
//            has.add(listD.get(i).getMatiere());
//            has2.add(listD.get(i).getDate());
//            has3.add(listD.get(i).getHeur());
//        }
//        for (Object ob : has) {
//            //System.out.println(ob+" "+has2.toString()+" "+has3.toString());
//        }
        int o = 0;
        for (moiteste nn : listD) {
//o++;
             // System.out.println(matDOA.getID(nn.getMatiere()) + " " + nn.getHeur() + " " + nn.getDate() + " " + nn.getSalle().toString());
//
//
            Epreuve epreuve = new Epreuve(nn.getDate(), nn.getHeur(), matDOA.getID(nn.getMatiere()), 1);
            //  epreuveDAO.AddEpreuve(epreuve);
            for (int i = 0; i < nn.getSalle().size(); i++) {

              //  System.out.println(nn.getMatiere() + " " + nn.getHeur() + " " + nn.getDate() + " " + nn.getSalle().get(i).toString());
                    Epreuve  ep = new Epreuve(nn.getHeur(),nn.getDate(),matDOA.getID((nn.getMatiere())));
                    Salle salles = new Salle(nn.getSalle().get(i).toString());
               // System.out.println(epreuveDAO.getID(ep)+" "+salleDAO.getID(salles.getNom()));
               // epreuveDAO.Epreuve_has_salle(salleDAO.getID(salles.getNom()),epreuveDAO.getID(ep));
            }
        }
        //le tour est jouer

        /*
        * ici je relie les prof avec leur matiere pour leur convoquer lorqu'on pqssera cet matiere
        * */
        HashSet in = new HashSet<>();
        for (int i =0; i<Enseignant.size();i++){
           // in.add(profDAO.getIDE((String) Enseignant.get(i))+" "+matDOA.getID((String) MatiereE.get(i)));
            System.out.println(profDAO.getIDE((String) Enseignant.get(i))+" "+matDOA.getID((String) matprof.get(i)));
            matDOA.Prof_has_matiere(matDOA.getID((String) matprof.get(i)),profDAO.getIDE((String) Enseignant.get(i)));
        }


    }


}
