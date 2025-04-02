package Collections;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
    public static void main(String[] args){
    Set<String> hs = new TreeSet<>();
        hs.add("A");hs.add("B");hs.add("ABCD");
        hs.add("SP");hs.add("AIA");hs.add("MDA");
        hs.add("B");
        System.out.println("HashSet Size: " + hs.size());
        System.out.println("Elements in HashSet: " + hs);
        System.out.print("Using iterator : ");
    Iterator<String> iterator = hs.iterator();
        while (iterator.hasNext())
                System.out.print(iterator.next() + " ");
System.out.println();
        System.out.print("Using enhanced for loop : ");
        for (String element : hs)
            System.out.print(element + " ");
        hs.remove("B");
        System.out.println("\nHashSet after removing element : " + hs);

}}
