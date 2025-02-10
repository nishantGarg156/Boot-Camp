package SelfPractice;

import org.w3c.dom.ls.LSOutput;

public class TypeCasting {


    public static void main(String[] args) {
        String number = "2";
        int num = Integer.valueOf(number);
        System.out.println(num);

        int num2 = 2;
        String str = String.valueOf(num2);
        System.out.println(str);
    }
}
