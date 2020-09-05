package dataStructures;

import java.util.*;

public class Lists {

    public static void main(String[] args) {




        // LinkedList example:
        LinkedList<String> states = new LinkedList<String>();
        states.add("Bayern");
        states.add("NSW");
        states.add("Baden");
        states.addFirst("Hessen");
        states.add(2,"Saxony");
        states.addLast("Berlin");

        System.out.println(states);
        //printing LinkedList in reverse direction
        ListIterator<String> iterator = states.listIterator(states.size());

        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }


      // Arraylist example
        List<String> numbers = new ArrayList<String>();
        numbers.add("one");
        numbers.add("two");
        numbers.add("three");
        numbers.add("four");
        numbers.add("three");
        numbers.add("two");
        numbers.add("four");
        System.out.println(numbers);//[

        Collections.sort(numbers);
        System.out.println(numbers);//[

        Iterator numbersIterator = numbers.iterator();

        while (numbersIterator.hasNext()){
            System.out.println(numbersIterator.next());
        }

    }
}
