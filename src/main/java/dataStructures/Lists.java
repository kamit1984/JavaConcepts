package dataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Lists {

    public static void main(String[] args) {


        List<String> numbers = new ArrayList<String>();
        numbers.add("one");
        numbers.add("two");
        numbers.add("three");
        numbers.add("four");
        numbers.add("three");
        numbers.add("two");
        System.out.println(numbers);//[

        Collections.sort(numbers);
        System.out.println(numbers);//[

        Iterator numbersIterator = numbers.iterator();

        while (numbersIterator.hasNext()){
            System.out.println(numbersIterator.next());
        }




    }
}
