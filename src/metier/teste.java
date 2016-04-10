package metier;

import DAO.EpreuveDAO;

import java.util.ArrayList;


public class teste {
    private String name;
    private String location;
    public void setName(String kk){
        name = kk;
    }
    public  static void main(String[] args){
//        EpreuveDAO epreuveDAO = new EpreuveDAO();
//        for(int i=0;i<epreuveDAO.getAllEp().size();i++)
//        {
//            System.out.println(epreuveDAO.getAllEp().get(0));
//            System.out.println(epreuveDAO.getAllEp().get(1));
//           // System.out.println(epreuveDAO.getAllEp().get(2));
//        }
//    }

//    public static class MyObject {
//        public static void main(String[] args){
            ArrayList<teste> collection = new ArrayList<>();
        teste object = new teste();
            object.setName("foo");
        System.out.println(collection.contains(object));
//        }

        //getters and setters
    }
}