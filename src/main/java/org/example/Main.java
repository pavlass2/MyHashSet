package org.example;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        String name = "James Gosling";
        String evilName = "Anders Hejlsberg";

        MyHashSet myHashSet = new MyHashSet(5477);
        myHashSet.add(name);
        myHashSet.add(evilName);

        System.out.println(myHashSet.contains(name));
        System.out.println(myHashSet.contains(evilName));
        System.out.println(myHashSet.contains(""));

        int nullCounter = 0;
        for (Iterator i = myHashSet.iterator(); i.hasNext();) {
            Object value = i.next();
            if (value == null) {
                nullCounter++;
            } else {
                System.out.println(value);
            }
        }
        System.out.println("Null counter: " + nullCounter);
    }
}