package Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class AllList {
    public static void main(String[] args) throws InterruptedException{
        try {
            Thread AA1 = new Thread(new ArrList());
            Thread LL1 = new Thread(new LinkList());
            Thread VV1 = new Thread(new Vectt());
            Thread SS1 = new Thread(new Staack());

            // Start the ArrayList thread and wait for it to finish
            AA1.start();
            AA1.join();

            // Start the LinkedList thread and wait for it to finish
            LL1.start();
            LL1.join();

            // Start the Vector thread and wait for it to finish
            VV1.start();
            VV1.join();

            // Start the Stack thread and wait for it to finish
            SS1.start();
            SS1.join();


        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }
}
class ArrList implements Runnable{
    @Override
    public void run() {
        System.out.println("----------ArrayList----------");
        List<Integer> list1 = new ArrayList<>();
        System.out.println("Is list1 empty? "+list1.isEmpty());
        list1.add(35);
        list1.add(23);
        list1.add(67);
        list1.add(82);

        System.out.println("Is list1 empty? "+list1.isEmpty());
        System.out.println("Number of elements in the list: "+list1.size());
        list1.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given list is :"+list1);
        System.out.println("The number of elements in the list: "+list1.size());
//Checking for an element
        System.out.println("Is 566 available in the list:"+list1.contains(566));
        System.out.println("The given list before removing elements is :"+list1);
        list1.remove(3);
        System.out.println("After removing elements:");
        System.out.println("The given list is :"+list1);
        System.out.println("The number of elements in the list: "+list1.size());
        try {
            Thread.sleep(1000); // Simulate processing
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle InterruptedException
        }
    }
}
class LinkList implements Runnable{
    @Override
    public void run() {
        System.out.println("----------LinkedList----------");
        List<Integer> list1 = new LinkedList<>();
        System.out.println("Is list1 empty? " + list1.isEmpty());
        list1.add(35);
        list1.add(23);
        list1.add(67);
        list1.add(82);

        System.out.println("Is list1 empty? "+list1.isEmpty());
        System.out.println("Number of elements in the list: "+list1.size());
        list1.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given list is :"+list1);
        System.out.println("The number of elements in the list: "+list1.size());
//Checking for an element
        System.out.println("Is 566 available in the list:"+list1.contains(566));
        System.out.println("The given list before removing elements is :"+list1);
        list1.remove(3);
        System.out.println("After removing elements:");
        System.out.println("The given list is :"+list1);
        System.out.println("The number of elements in the list: "+list1.size());
        try {
            Thread.sleep(1000); // Simulate processing
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle InterruptedException
        }
    }
}
class Vectt implements Runnable{
    @Override
    public void run() {
        System.out.println("----------Vector----------");
        List<Integer> list1 = new Vector<>();
        //System.out.println("Is list1 empty? "+list1.isEmpty());
        list1.add(35);
        list1.add(23);
        list1.add(67);
        list1.add(82);

        System.out.println("Is list1 empty? "+list1.isEmpty());
        System.out.println("Number of elements in the list: "+list1.size());
        list1.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given list is :"+list1);
        System.out.println("The number of elements in the list: "+list1.size());
//Checking for an element
        System.out.println("Is 566 available in the list:"+list1.contains(566));
        System.out.println("The given list before removing elements is :"+list1);
        list1.remove(3);
        System.out.println("After removing elements:");
        System.out.println("The given list is :"+list1);
        System.out.println("The number of elements in the list: "+list1.size());
        try {
            Thread.sleep(1000); // Simulate processing
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle InterruptedException
        }
    }
}
class Staack implements Runnable{
    @Override
    public void run() {
        System.out.println("----------Stack----------");
        List<Integer> list1 = new java.util.Stack<>();
        System.out.println("Is list1 empty? "+list1.isEmpty());
        list1.add(35);
        list1.add(23);
        list1.add(67);
        list1.add(82);

        System.out.println("Is list1 empty? "+list1.isEmpty());
        System.out.println("Number of elements in the list: "+list1.size());
        list1.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given list is :"+list1);
        System.out.println("The number of elements in the list: "+list1.size());
//Checking for an element
        System.out.println("Is 566 available in the list:"+list1.contains(566));
        System.out.println("The given list before removing elements is :"+list1);
        list1.remove(3);
        System.out.println("After removing elements:");
        System.out.println("The given list is :"+list1);
        System.out.println("The number of elements in the list: "+list1.size());
        try {
            Thread.sleep(1000); // Simulate processing
        } catch (InterruptedException e) {
            e.printStackTrace(); // Handle InterruptedException
        }
    }
}