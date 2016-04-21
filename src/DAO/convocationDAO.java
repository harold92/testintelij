package DAO;


import entité.Epreuve;
import entité.convocation;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class convocationDAO {

public static void main(String[] args) throws SQLException {
    convocation con = new convocation("robleh","12-12-2012","10H-12H","A1",1);
    convocationDAO conn = new convocationDAO();
    ArrayList<convocation> listcon = new ArrayList<>();
    LinkedList list = new LinkedList();
    int A=0;

    for (int i=0;i<conn.getAllEp().size()-1;i++) {
        if (conn.getAllEp().get(i).getNom().equals(conn.getAllEp().get(i+1).getNom())){
           // System.out.println(conn.getAllEp().get(i).getNom()+" "+conn.getAllEp().get(i+1).getNom());
            for (int u=0;u<conn.getAllEp().get(i+1).getHeur().size();u++){
                conn.getAllEp().get(i).setDate(conn.getAllEp().get(i+1).getDate().get(u).toString());
                conn.getAllEp().get(i).setHeur(conn.getAllEp().get(i+1).getHeur().get(u).toString());
                conn.getAllEp().remove(i+1);
            }
//            connn = new convocation(conn.getAllEp().get(i).getNom(),conn.getAllEp().get(i).
//                    getDate().toString(),conn.getAllEp().get(i).getHeur().toString(),
//                    conn.getAllEp().get(i).getSall(),conn.getAllEp().get(i).getHeurS());
//            listcon.add(connn);

        }
    }
    HashSet<convocation> ddcon = new HashSet<>();
    for (convocation cc: conn.getAllEp()) {

      // System.out.println(cc.getNom()+" "+cc.getDate()+" "+cc.getHeur()+" "+cc.getSall());
    }
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
}

