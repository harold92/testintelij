package DAO;

import entité.Matiere;
import entité.Prof;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProfDAO {

	public static void main(String[] args) throws SQLException {
		ProfDAO profDAO = new ProfDAO();
		//Prof prof = new Prof("elmi","robleh@gmail.com",profDAO.getID("PTP"),"ptp");
		//System.out.println(profDAO.getIDE("ABDOULWAHAB OMAR ELMI"));
		try {
			//for (int i=0;i<profDAO.getProfByMatiere("WARSAMA OMAR ALI").size();i++)
				for ( Prof  pp: profDAO.getProfByMatiere("WARSAMA OMAR ALI")) {
					System.out.println(pp.getMat());
				}
			//System.out.println(profDAO.getProfByMatiere());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ProfDAO() {};

	public String getProfByHour(Matiere mat)  {
		return null;
	}


	public ArrayList<Prof> getProfByMatiere(String profN) throws SQLException {

		ArrayList<Prof> listprof = new ArrayList();
		PreparedStatement prepare =  Connexion.getinstance()
				.prepareStatement("SELECT *" +
						"FROM Enseigneant,Enseigneant_has_Matiere,Matiere " +
						"WHERE Enseigneant.codeEnseigneant =Enseigneant_has_Matiere.Enseigneant_codeEnseigneant AND" +
						" Enseigneant_has_Matiere.Matiere_IDMatiere=Matiere.IDMatiere " +
						"AND Enseigneant.NomEnseignant='"+profN+"'");
		ResultSet resultSet = prepare.executeQuery();
		while (resultSet.next())
		{
			Prof prof = new Prof(resultSet.getString("NomEnseignant"),resultSet.getString("EmailEnseignant")
					,resultSet.getString("typeEnseignant_typeEnseignantlibelle"),resultSet.getString("libelleMat"),
					resultSet.getInt("heurDesurveillance"));
			listprof.add(prof);
		}
		return listprof;
	}


	public int getID(String type) throws SQLException {
		int id=0;
		PreparedStatement prepare =  Connexion.getinstance()
				.prepareStatement("SELECT *" +
						"FROM typeEnseignant " +
						"where typeEnseignantlibelle = '"+type+"'");
		ResultSet resultSet = prepare.executeQuery();
		while (resultSet.next())
		{
			id = resultSet.getInt("codetypeEnseignant");
		}
		return id;

	}
	public ArrayList<Prof>   getAll() throws SQLException {
		ArrayList<Prof> listprof = new ArrayList();
		PreparedStatement prepare =  Connexion.getinstance()
				.prepareStatement("SELECT *" +
						"FROM Enseigneant,Enseigneant_has_Matiere,Matiere " +
						"WHERE Enseigneant.codeEnseigneant =Enseigneant_has_Matiere.Enseigneant_codeEnseigneant AND" +
						" Enseigneant_has_Matiere.Matiere_IDMatiere=Matiere.IDMatiere");
		ResultSet resultSet = prepare.executeQuery();
		while (resultSet.next())
		{
			Prof prof = new Prof(resultSet.getString("NomEnseignant"),resultSet.getString("EmailEnseignant")
			,resultSet.getString("typeEnseignant_typeEnseignantlibelle"),resultSet.getString("libelleMat"),
					resultSet.getInt("heurDesurveillance"));
			listprof.add(prof);
		}
		return listprof;

	}

	public ArrayList<Prof> getAllprof() throws SQLException{
		ArrayList<Prof> listProf = new ArrayList<>();
		PreparedStatement prepare =  Connexion.getinstance()
				.prepareStatement("SELECT *" +
						"FROM Enseigneant");
		ResultSet resultSet = prepare.executeQuery();
		while (resultSet.next())
		{
			Prof prof = new Prof(resultSet.getString("NomEnseignant"),resultSet.getString("EmailEnseignant")
					,resultSet.getString("typeEnseignant_typeEnseignantlibelle"));
			listProf.add(prof);
		}
		return  listProf;
	}
	public String getProfBystauts(Matiere mat) {
		return null;
	}

	/**
	 * @param
	 */
	public void AddProf(Prof prof) throws SQLException {
		PreparedStatement prepare =  Connexion.getinstance().prepareStatement(
				"insert " +
						"INTO Enseigneant(NomEnseignant,EmailEnseignant,typeEnseignant_typeEnseignantlibelle,telEnseignant) " +
						"values('"+prof.getNom()+"'," +
						"'"+prof.getEmail()+"'," +
						"'"+prof.getStatut()+"'," +
						""+prof.getTel()+")");
		prepare.executeUpdate();

	}
	public int getIDE(String type) throws SQLException {
		int id=0;
		PreparedStatement prepare =  Connexion.getinstance()
				.prepareStatement("SELECT codeEnseigneant FROM Enseigneant where NomEnseignant = '"+type+"'");
		ResultSet resultSet = prepare.executeQuery();
		while (resultSet.next())
		{
			id = resultSet.getInt("codeEnseigneant");
		}
		return id;

	}

	/**
	 * @param
	 */
	public void DeleteProf(Prof prof) {
	}

	/**
	 * @param
	 */
	public void UpdateProf(Prof prof) {
	}

}
