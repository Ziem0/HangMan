package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class tryy {
    public static void main(String[] args) {

        String w = "ziemko";
        ArrayList<String> lista = new ArrayList<>();
        {
            {
                lista.add("Z");
                lista.add("u");
                lista.add("x");
                lista.add("C");
                lista.add("'");
                lista.add("i");
            }
        }

        String used = String.join("", lista);
        Pattern p = Pattern.compile("[^" + used + "]");
//        System.out.println(p.matcher(w).replaceAll("-"));

//        lista.sort(String::compareToIgnoreCase);
        Collections.sort(lista, String.CASE_INSENSITIVE_ORDER);
        System.out.println(String.join(", ", lista));


    }

}