package metier;

import DAO.EpreuveDAO;
import entité.convocation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class Teste {

    public  static void main(String[] args){
        ArrayList<convocation> list = new ArrayList();
        ArrayList<convocation> list2 = new ArrayList();
        ArrayList listH;
        ArrayList listD;
        ArrayList listS;
        String data="";

        convocation con = new convocation("ABDI","00-00-2012","10H-12H","D12",1);
        convocation con2 = new convocation("robleh","10-2-2015","8H-10H","A2",1);
        convocation con3 = new convocation("robleh","12-8-2012","15H-17H","F1",1);
        convocation con4 = new convocation("robleh","12-8-2012","17H-19H","F3",1);
        list.add(con);
        list.add(con2);
        list.add(con3);
        list.add(con4);

        String[] tab ={"robleh","ABDI"};

        for (String aTab : tab){

            listD= new ArrayList();
            listS=new ArrayList();
            listH=new ArrayList();

            for (convocation cc : list) {
                if (cc.getNom().equals(aTab)) {

                    for (int o = 0; o < cc.getDate().size(); o++) {
                        listD.add(cc.getDate().get(o));
                        listH.add(cc.getHeur().get(o));
                        listS.add(cc.getSall());
                    }
                    convocation cv = new convocation(cc.getNom(), listH, listD, listS);
                            list2.add(cv);
                }
            }}

        for ( convocation cc: list2) {
            System.out.println(cc.getNom());
            for (int i=0;i<cc.getHeur().size();i++){
                System.out.println(cc.getDate().get(i)+" "+cc.getHeur().get(i)+" "+" "+cc.getSal().get(i));
            }
        }


    }
}