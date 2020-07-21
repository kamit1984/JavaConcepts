package loops;

public class main {

    public static void main(String[] args) {

        initializers obj = new initializers();
        System.out.println(obj.getA());
        System.out.println(obj.getStr());

        obj.setA(15);
        obj.setStr("Amit");
        System.out.println(obj.getA());
        System.out.println(obj.getStr());

    }
}
