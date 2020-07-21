package General;

import java.io.*;

public class main {

    public static void main(String[] args) {

        ObjectOutputStream objOut;
        try{
            FileOutputStream filestream = new FileOutputStream("Rectangle.ser");
            objOut = new ObjectOutputStream(filestream);
            objOut.writeObject(new Rectangle(5, 10));
            objOut.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("Handled exception");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            FileInputStream file = new FileInputStream("Rectangle.ser");
            ObjectInputStream objIn = new ObjectInputStream(file);
            Rectangle rect = (Rectangle) objIn.readObject();
            System.out.println("Initial area  = " +  rect.area);
            System.out.println("Calculated area  = " +  rect.getArea());
//            rect.length = 20;
//            rect.breadth = 10;

        }catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Handled exception");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Handled exception");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
