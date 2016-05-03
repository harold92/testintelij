package DAO;


import entité.Epreuve;
import entité.convocation;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class convocationDAO {

public static void main(String[] args) throws SQLException {
    convocation con = new convocation("robleh","12-12-2012","10H-12H","A1",1);
    convocationDAO conn = new convocationDAO();
//
//    for (int i=0;i<conn.listNp().length;i++){
//        System.out.println(conn.listNp()[i]);
//    }



}
    public void AddEpreuve(convocation con) throws SQLException {
        PreparedStatement prepare = Connexion.getinstance().prepareStatement(
                "insert " +
                        "INTO convocation(heur,dat,nomprof,sal) " +
                        "values('" + con.getHeur() + "'," +
                        "'" + con.getDate() + "'," +
                        "'" + con.getNom() + "'," +
                        "'" + con.getSall() + "')");
        prepare.executeUpdate();
    }

    public ArrayList<convocation> getAllEp() {
        int i=0;
        ArrayList<convocation> list = new ArrayList<>();

        try {
            Statement prepare = Connexion.getinstance()
                    .createStatement();
            ResultSet resultSet = prepare.executeQuery("SELECT * from convocation ORDER by nomprof");

            while (resultSet.next()) {
                convocation con = new convocation(resultSet.getString("nomprof"), resultSet.getString("dat")
                        , resultSet.getString("heur"), resultSet.getString("sal"), 1);
//                for ( convocation cc:list ) {
//                    i++;
//                    if (i<=list.size())
//                        i=0;
//                    if (cc.getNom().equals(con.getNom())){
//                        cc.setDate(con.getDate().get(i).toString());
//                        cc.setHeur(con.getHeur().get(i).toString());
//                       // System.out.println(cc.getNom()+" "+cc.getDate()+" "+cc.getHeur());
//                    }
//                }
                list.add(con);
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return list;
    }

    public ArrayList listNp() throws SQLException {
        ArrayList list = new ArrayList<>();
        Set<String> HasN = new HashSet<>();

            Statement prepare = Connexion.getinstance()
                    .createStatement();
            ResultSet resultSet = prepare.executeQuery("SELECT  nomprof from convocation");

            while (resultSet.next()) {
                HasN.add(resultSet.getString("nomprof"));
            }
        list.addAll(HasN);
   return list;
    }
}

