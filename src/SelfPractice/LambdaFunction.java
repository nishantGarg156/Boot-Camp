package SelfPractice;

import java.util.concurrent.Flow;

@FunctionalInterface
 interface xyz{
     public void print(String message);
     default void display(){
         System.out.println("Hello World");
     }

     default void display1(){
         System.out.println("Hello World");
     }

    
}
@FunctionalInterface
interface xyz1{
    public void print(String message);
    default void display(){
        System.out.println("Hello World");
    }
}

public class LambdaFunction implements xyz , xyz1 {
    public static void main(String[] args) {

        xyz s = (message)-> System.out.println(message);
        s.print("Hello");

    }

    @Override
    public void print(String message) {

    }

    @Override
    public void display() {
        xyz1.super.display(); // condition to avoid diamond problem (functionalInterface.super.functionName) super refers the parent class.
    }

    @Override
    public void display1() {
        xyz.super.display1();
    }
}
