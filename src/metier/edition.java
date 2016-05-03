package metier;


import entité.convocation;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class edition {



    public edition(ArrayList<convocation> list) throws IOException {
        String nom ="", tab ="";
       for(convocation cc : list){
           nom = cc.getNom();
           for (int i=0;i<cc.getDate().size();i++){
               tab = tab+"<tr><td>"+cc.getHeur().get(i)+"</td> <td>"+cc.getDate().get(i)+"</td> " +
                       "<td>"+cc.getSal()+"</td></tr>";
           }
           charger(null,nom,tab);
           tab="";
           nom="";
       }
    }

    public void charger(String Doyen,String nom,String tab) throws IOException {
        File file = new File("\"edition/"+nom.trim()+".html");
        DataOutputStream dataIn = new DataOutputStream(new FileOutputStream(file));
        dataIn.writeUTF(confipage(Doyen,nom,tab));
    }

//    public  String surveillance() throws IOException {
//        String table ="";
//        for (convocation cc : ListC){
//            for (int i=0;i<cc.getDate().size();i++){
//             table = table+"<tr><td>"+cc.getDate().get(i)+"</td> <td>"+cc.getHeur().get(i)+"</td> " +
//                     "<td>"+cc.getSall()+"</td></tr>";
//            }
//        }
//        return table;
//    }

    private String confipage(String Doyen,String nom,String tab){
        String page="<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                " <meta charset=\"utf-8\" />\n" +
                "    <title>convocation des enseignants</title>\n" +
                "</head>\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"materialize/css/materialize.min.css\"/>\n" +
                "<body class=\"container\">\n" +
                "<p>\n" +
                "<div class=\"row\">\n" +
                "<span class=\" col s4 m4\">\n" +
                "\t\tREPUBLIQUE DE DJIBOUTI <br/>\n" +
                "\t\tMinistere de l'Enseignement Superieur <br/>\n" +
                "\t\tet de la Rechercher <br/>\n" +
                "\t\t<strong class=\"ud z-depth-3\">UNIVERSITE DE DJIBOUTI</strong>\n" +
                "\t</span>\n" +
                "\t<span class=\" col s4 m4\">\n" +
                "\t<img src=\"udd.jpg\" class=\"responsive-img\" width=\"100px\"/>\n" +
                "\t</span>\n" +
                "\n" +
                "\t<span class=\" col s4 m4\">\n" +
                "\tجمهورية جيبوتي <br/>\n" +
                "وزارة التعليم العالي والبحث العلمي <br/>\n" +
                "جامعة جيبوتي<br/>\n" +
                "\t</span>\n" +
                "</div>\n" +
                "</p>\n" +
                "\n" +
                "<hr/>\n" +
                "<div class=\"title\">\n" +
                "    <strong>\n" +
                "        INSTITUT UNIVERSITAIRE DE TECHNOLOGIE INDUSTRIELLE (IUT-i) <br/>\n" +
                "    </strong>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"row\">\n" +
                "    <p>\n" +
                "        <strong class=\" col s8 m8\">Le Doyen,</strong>\n" +
                "        <strong class=\"col s4 m4\">Le Djibouti, "+ new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()) +"</strong>\n" +
                "    </p>\n" +
                "    <br/> <br/>\n" +
                "    <strong class=\"col s6 offset-s6\"> A </strong> <br/>\n" +
                "    <strong class=\"col s6 offset-s5\">"+nom+"</strong>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"row\">\n" +
                "    <h3 class=\"col s12 offset-s4\"><strong>CONVOCATION</strong></h3>  <br/>\n" +
                "    <p>\n" +
                "        <strong>Examen final du 1ere semestre - Année universitaire 2015/2016</strong>\n" +
                "    </p>\n" +
                "<span>\n" +
                "vous ete convoquée au surveillances des epreuves des examen finaux du premiere semestre\n" +
                "de l'année universitaire 2015/2016,qui aura lieu du 11 au 21 janvier 2016, comment suivant:\n" +
                "\n" +
                "<table class=\"highlight responsive-table\">\n" +
                "    <thead>\n" +
                "    <tr>\n" +
                "        <th data-field=\"id\">Date</th>\n" +
                "        <th data-field=\"name\">Horaire</th>\n" +
                "        <th data-field=\"price\">site</th>\n" +
                "    </tr>\n" +
                "    </thead>\n" +
                "    <tbody>\n" +tab+
                "    </tbody>\n" +
                "</table>\n" +
                "</span>\n" +
                "    \n" +
                "    <br/>\n" +
                "    Par ailleures, vous ete priee de vous presenter 15minute avant le debut de l'epreuve,\n" +
                "    au secretariat des examens de l'iut-i. <br/>\n" +
                "    votre presence est indisponsable.\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
        return page;
    }

}
