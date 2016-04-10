package DAO;


import entité.Matiere;
import entité.Prof;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MatiereDOA {

    public static void main(String[] args) throws SQLException {
       MatiereDOA matiereDOA = new MatiereDOA();
       for (int i=0;i<matiereDOA.getAll().size();i++){
        System.out.println(matiereDOA.getID(matiereDOA.getAll().get(i).toString()));

       }//System.out.println(matiereDOA.getID("Base de telecommunication"));
       // Matiere matiere = new Matiere("Anglais");
        //matiereDOA.AddMat(matiere.getNomM());
        // ProfDAO profDAO = new ProfDAO();
        //Prof prof = new Prof("robleh","robleh@gmail.com",profDAO.getID("PTP"),77879867);
        //profDAO.AddProf(prof);
//        try {
//            System.out.println(profDAO.getID("ADM"));
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }


    /**
     * @param mat
     * @return String
     */
    public String getProfByHour(Matiere mat) {
        return null;
    }

    /**
     * @param mat
     * @param prof
     * @return String
     */
    public String getProfByMatiere(Matiere mat, Prof prof) {
        return null;
    }

    /**
     * @param //mat
     * @return String
     */
    public int getID(String type) throws SQLException {
        int id = 0;
        PreparedStatement prepare = Connexion.getinstance()
                .prepareStatement("SELECT IDMatiere FROM  Matiere WHERE libelleMat ='" + type + "'");
        ResultSet resultSet = prepare.executeQuery();
        while (resultSet.next()) {
            id = resultSet.getInt("IDMatiere");
        }
        return id;

    }

    public ArrayList getAll() throws SQLException {
        int id = 0;
        ArrayList listMat = new ArrayList();
        PreparedStatement prepare = Connexion.getinstance()
                .prepareStatement("SELECT libelleMat FROM  Matiere ");
        ResultSet resultSet = prepare.executeQuery();
        while (resultSet.next()) {
           listMat.add(resultSet.getString("libelleMat"));
        }
        return listMat;

    }

    public String getProfBystauts(Matiere mat) {
        return null;
    }


    public void AddMat(String matiere) throws SQLException {
        PreparedStatement prepare =  Connexion.getinstance().prepareStatement(
                "insert " +
                        "INTO Matiere(libelleMat) " +
                        "values('"+matiere+"')");
        prepare.executeUpdate();

    }
    public void Prof_has_matiere(int matiere , int prof) throws SQLException {
        PreparedStatement prepare =  Connexion.getinstance().prepareStatement(
                "insert " +
                        "INTO Enseigneant_has_Matiere(Enseigneant_codeEnseigneant,Matiere_IDMatiere) " +
                        "values("+prof+","+ matiere+")");
        prepare.executeUpdate();

    }

    public void DeleteProf(Prof prof) {
    }


    public void UpdateProf(Prof prof) {
    }

}
