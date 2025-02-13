package Collections;

import java.util.*;

public class AllSets {
    public static void SetSample(HashSet<Integer> hs) {

        hs.add(10);
        hs.add(14);
        hs.add(35);
        hs.add(7);
        hs.add(21);
        hs.add(100);
        hs.add(78);
        System.out.println("\nHashSet Size: " + hs.size());
        System.out.println("Elements in HashSet: " + hs);
        System.out.println("After removing one element");
        hs.remove(78);
        System.out.println("Elements in HashSet: " + hs);
        System.out.print("Using iterator : ");
        for (Integer i : hs) {
            if (i % 7 == 0) {
                System.out.print(i + " ");

            }

        }
    }

    public static void SetSample(LinkedHashSet<String> hs) {

        hs.add("AAAAAA");
        hs.add("BBB");
        hs.add("CCCCCC");
        hs.add("DDDDDD");
        hs.add("EEE");
        hs.add("FFFF");
        hs.add("GGGGGG");
        System.out.println("\nLinkedHashSet Size: " + hs.size());
        System.out.println("Elements in LinkedHashSet: " + hs);
        System.out.println("After removing one element");
        hs.remove("FFFF");
        System.out.println("Elements in LinkedHashSet: " + hs);
        System.out.print("Using iterator : ");
        for (String i : hs) {
            if (i.length() > 5) {
                System.out.print(i + " ");

            }
        }
    }
    public static void SetSample(TreeSet<Float> hs) {

        hs.add(100.2f);
        hs.add(20.0f);
        hs.add(77.5f);
        hs.add(193.565f);
        hs.add(0.25f);
        hs.add(79.2546f);
        hs.add(25.1549f);
        System.out.println("\nTreeSet Size: " + hs.size());
        System.out.println("Elements in TreeSet: " + hs);
        System.out.println("After removing one element");
        hs.remove(0.25f);
        System.out.println("Elements in TreeSet: " + hs);
        System.out.print("Using iterator : ");
        for (Float i : hs) {
            if (i > 20) {
                System.out.print(i + " ");

            }
        }
    }
public static void main(String[] args){
            HashSet<Integer> hashSet=new HashSet<>();
            SetSample(hashSet);

            LinkedHashSet<String> linkedHashSet=new LinkedHashSet<>();
            SetSample(linkedHashSet);

            TreeSet<Float> treeSet=new TreeSet<>();
            SetSample(treeSet);
        }
}