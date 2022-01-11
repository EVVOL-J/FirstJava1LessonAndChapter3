package java2.lesson3;

import java.util.*;


public class Collections {
    private static final String[] stringArray = {"NOP", "NOP1", "NOP2", "NOP3", "NOP", "NOP1", "NOP2", "NOP3", "NOP4", "NOP5" };

    public static void main(String[] args) {
        convertArray();
        Phonebook phonebook = new Phonebook();
        phonebook.add("Voloshin", 123);
        phonebook.add("Torshin", 123);
        phonebook.add("Voloshin", 1234);
        phonebook.add("Voloshin", 1235);
        phonebook.add("Vaskin", 123);
        phonebook.get("Voloshin");
        phonebook.get("Torshin");
        phonebook.get("Tor");
        phonebook.printAllPhoneBook();


    }

    private static void convertArray() {
        Map<String, Integer> sortArray = new TreeMap<>();
        for (String str : stringArray) {
//            if(sortArray.containsKey(str)) sortArray.put(str,sortArray.get(str)+1);
//            else sortArray.put(str,1);
            sortArray.merge(str, 1, Integer::sum);
        }
        sortArray.forEach((str, number) -> {
            System.out.println(str + ": " + number);
        });
        System.out.println(sortArray);

    }

}
