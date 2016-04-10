package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connexion {

    public  static  void main(String[] qrgs){
        Connexion con = new Connexion();
    }

    private static Connection con = null;
    private String url = "jdbc:mysql://localhost:3306/tuto_DB";
    private String user = "root";
    private String passwd = "";
    private volatile static   Connexion connexion;

  private Connexion(){
        try
        {
            con = DriverManager.getConnection(url,user,passwd);
            System.out.println("connexion reussi");
        }
        catch (SQLException e)
        {
        e.printStackTrace();
        }
}
    public static  Connection getinstance(){
        if (con==null){
            synchronized (Connexion.class){
                if(con==null)
                new Connexion();
            }
        }
        return con;
    }

}
