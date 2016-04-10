package metier;

import DAO.EpreuveDAO;


public class teste {

    public  static void main(String[] args){
        EpreuveDAO epreuveDAO = new EpreuveDAO();
        for(int i=0;i<epreuveDAO.getAllEp().size();i++)
        {
            System.out.println(epreuveDAO.getAllEp().get(0));
            System.out.println(epreuveDAO.getAllEp().get(1));
           // System.out.println(epreuveDAO.getAllEp().get(2));
        }
    }
}
