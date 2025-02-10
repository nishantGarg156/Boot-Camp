public class Main {
    private int a = 30;

    Main(int a) {
        this.a = a;
    }

    void change(int a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Main obj = new Main(40);
        System.out.println(obj.a);
        obj.change(50);
        System.out.println(obj.a);
        obj.change(60);
        System.out.println(obj.a);
    }
}


