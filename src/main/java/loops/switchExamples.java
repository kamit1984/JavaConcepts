package loops;

public class switchExamples {


    public static void main(String[] args) {

//  To use switch on string ... need to use java 8 onwards
        String str = "11";

        switch (str){
            case "11":
                System.out.println("11");
                break;
            case "10":
                System.out.println("10");
                break;
            default:
                System.out.println("Default");
        }


    }
}
