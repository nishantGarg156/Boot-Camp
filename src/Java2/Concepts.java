package Java2;

public class Concepts {
    final int value = 88;
    Concepts(){
    System.out.println("parrent class Concepts");
    }
    public void display(){
        System.out.println("parrent class method");
    }

}
class B extends Concepts{
    static int instanceVar =0 ;
    B() {
        super();
        System.out.println("B constructor");
        instanceVar++;
    }
    public void display(){
        System.out.println("B method");
    }
    public void displayInstanceCount(){
        System.out.println(" instance count" + instanceVar);
    }
    }
class OOPDemo {
    public static void main(String[] args) {
        B obj1 = new B();
        obj1.display();
        obj1.displayInstanceCount();
    }
}



