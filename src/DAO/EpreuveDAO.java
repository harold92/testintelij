package DAO;

import entité.Epreuve;
import entité.Salle;

import java.sql.*;
import java.util.ArrayList;

import static org.apache.poi.hslf.record.RecordTypes.List;

/*import javax.mail.Authenticator;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/
/*
 * Class Prof
 */
public class EpreuveDAO {

    public static void main(String[] args) throws SQLException {
        EpreuveDAO epreuveDAO = new EpreuveDAO();
        // Epreuve epreuve = new Epreuve("Lundi 11 janvier 2016", "08h-10h", 105);
        ArrayList<Epreuve> list = epreuveDAO.getAllEp();
        for (int i = 0; i < list.size(); i++) {

            System.out.println(list.get(i).getMatiereEP() + " " + list.get(i).getDateEp() + " " +
                    list.get(i).getHeurEp() + " " + list.get(i).getSal());
        }

    }

    public EpreuveDAO() {
    }


    public int getID(Epreuve epreuve) throws SQLException {
        int id = 0;
        Statement prepare = Connexion.getinstance()
                .createStatement();
        ResultSet resultSet = prepare.executeQuery("SELECT codeEpreuve" +
                " FROM Epreuve " +
                "WHERE Matiere_IDMatiere = " + epreuve.getMatiereEp() + " AND " +
                "dateEpreuve = '" + epreuve.getDateEp() + "'" +
                "AND heur= '" + epreuve.getHeurEp() + "'");

        while (resultSet.next()) {
            id = resultSet.getInt("codeEpreuve");
        }
        return id;
    }

    public ArrayList<Epreuve> getAllEp() {
        ArrayList<Epreuve> list = new ArrayList<>();


        try {
            Statement prepare = Connexion.getinstance()
                    .createStatement();
            ResultSet resultSet = prepare.executeQuery("SELECT Epreuve.codeEpreuve,Epreuve.dateEpreuve,Epreuve.heur, " +
                    "Matiere.libelleMat, salle.IDsalle, salle.capacité,salle.site,salle.nomsal" +
                    " FROM Epreuve , Matiere,salle,salle_has_Epreuve " +
                    "WHERE Matiere_IDMatiere = Matiere.IDMatiere AND " +
                    "Epreuve.codeEpreuve = salle_has_Epreuve.Epreuve_codeEpreuve " +
                    "AND salle.IDsalle= salle_has_Epreuve.salle_IDsalle");

            ResultSetMetaData data = resultSet.getMetaData();
            while (resultSet.next()) {
                Epreuve epreuve = new Epreuve(resultSet.getString("dateEpreuve"), resultSet.getString("heur"),
                        resultSet.getString("libelleMat"), resultSet.getString("nomsal"), resultSet.getInt("capacité"));
                list.add(epreuve);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    public String getEpreuveByHour(Epreuve mat) {

        return null;
    }


    public String getEpreuveBymat(Epreuve epreuve) {
        return null;
    }


    public String getEpreuveBySalle(Epreuve epreuve) {
        return null;
    }

    public void AddEpreuve(Epreuve epreuve) throws SQLException {
        PreparedStatement prepare = Connexion.getinstance().prepareStatement(
                "insert " +
                        "INTO Epreuve(dateEpreuve,heur,Matiere_IDMatiere,typeEpreuve_IDtypeEpreuve) " +
                        "values('" + epreuve.getDateEp() + "'," +
                        "'" + epreuve.getHeurEp() + "'," +
                        "" + epreuve.getMatiereEp() + "," +
                        "" + epreuve.getTypeE() + ")");
        prepare.executeUpdate();
    }

    public void DeleteEpreuve(Epreuve epreuve) {
    }

    /*
     * @param mat
     */
    public void UpdateEpreuve(Epreuve epreuve) {
    }

    public void Epreuve_has_salle(int idS, int idE) throws SQLException {
        PreparedStatement prepare = Connexion.getinstance().prepareStatement(
                "insert INTO salle_has_Epreuve(salle_IDsalle,Epreuve_codeEpreuve)" +
                        "values(" + idS + "," + idE + ")");
        prepare.executeUpdate();
    }

}
