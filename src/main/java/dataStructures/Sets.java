package dataStructures;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Sets {

    public static void main(String[] args) {

        Set<String> mySet = new TreeSet<String>();

        mySet.add("Sachin");
        mySet.add("Amit");
        mySet.add("Dravid");
        mySet.add("Khan");
        mySet.add("Amit");
        mySet.add("Sachin");

        System.out.println(mySet);

        Iterator itr = mySet.iterator();

        while (itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
