package SelfPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public  class AbstractionConcept {
    public AbstractionConcept(){

    }
    static void display(){

    }


    public static void main(String[] args){


    }

}
class B extends AbstractionConcept{
    String reverse (String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1 ; i>=0 ; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

   public static void main (String[] args){
            B b = new B();
            String st = "MY NAME IS NISHANT";
            Map<Character,Integer> fre = new HashMap<>();
            for(int i=0 ; i<st.length() ; i++){
                if(fre.containsKey(st.charAt(i))){
                    fre.put(st.charAt(i),fre.get(st.charAt(i))+1);
                }else{
                    fre.put(st.charAt(i),1);
                }
            }
       System.out.println(fre.toString());


   }

}

