package loops;

public class initializers {

    private static int a;
    private int b;
    private static String str;

    public initializers() {
    }

    {
        a = 20;
        str = "Due to Instance initializer block ";
    }
    static {
        a = 10;
        str = "Initial value";
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
