package DAO;

import entité.Matiere;
import entité.Salle;

import java.sql.*;

/**
 * Class Prof
 */
public class SalleDAO {

	public static void main(String[] args) throws SQLException {
	SalleDAO salleDAO = new SalleDAO();
		Salle salle = new Salle("A2");
		//System.out.println(salleDAO.getID(salle.getNom()));
		/*try {
			salleDAO.AddSalle(salle);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

	
	public SalleDAO() {
	};


	/**
	 * @return String
	 * @param mat
	 */
	public String getSalBycapacity(Matiere mat) {
		return null;
	}

	/**
	 * @return String
	 * @param mat
	 * @param
	 */
	public String getsalBySite(Salle mat) {
		return null;
	}

	/**
	 * @return String
	 * @param
	 */
	public String getsalByType(Salle sal) {
		return null;
	}

	/**
	 * @param
	 */
	public void AddSalle(Salle sal) throws SQLException {
		PreparedStatement prepare =  Connexion.getinstance().prepareStatement(
				"insert " +
						"INTO salle(nomsal,site,capacité, typeSalle_IDtypeSalle) " +
						"values('"+sal.getNom()+"'," +
						"'"+sal.getSite()+"'," +
						""+sal.getCapacite()+"," +
						""+sal.getTypesalID()+")");
		prepare.executeUpdate();
	}

	/**
	 * @param
	 */
	public void DeleteSalle(Salle sal) {
	}
	public int getID(String salle) throws SQLException {
		int id=0;
		Statement prepare = Connexion.getinstance()
				.createStatement();
		ResultSet resultSet = prepare.executeQuery("SELECT IDsalle" +
				" FROM salle " +
				"WHERE nomsal= '"+salle+"'");
		while(resultSet.next()) {
			id = resultSet.getInt("IDsalle");
		}
		return id;
	}

	/**
	 * @param
	 */
	public void UpdateSalle(Salle sal) {
	}

}
