package dataStructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Create by Amit on 9/5/20
 */
public class GroceryList {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();

        list1.add("Apple");
        list1.add("Milk");
        list1.add("Beer");
        list2.add("Oil");
        list2.add("Bread");
        list2.add("Cheese");

        System.out.println("First list " + list1);
        System.out.println("Second list " + list2);
        list1.addAll(list2);
        System.out.println("Merged list = " + list1);

        // remove Bier from the list
        Iterator iterator = list1.iterator();

        if(list1.contains("Beer")){
            list1.remove("Beer");
        }
        System.out.println(list1);

    }
}
