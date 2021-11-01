package java2.lesson3;

import java.util.*;

public class Phonebook {
    private final Map<String, Set<Integer>> data;

    public Phonebook() {
        data=new HashMap<>();
    }

    public void add(String surname, Integer phoneNumber){
        if (!data.containsKey(surname)) {
            data.put(surname, new TreeSet<>());
        }
        data.get(surname).add(phoneNumber);
    }

    public void get(String surname){
        if (data.containsKey(surname)){
            System.out.println(surname+" phones: "+data.get(surname));
        }
        else System.out.println("Surname "+surname+" not found");
    }

    public Map<String, Set<Integer>> getData() {
        return data;
    }
}
