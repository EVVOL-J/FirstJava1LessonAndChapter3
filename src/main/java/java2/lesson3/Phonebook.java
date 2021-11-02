package java2.lesson3;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Phonebook {
    private final Map<String, Set<Integer>> data;

    public Phonebook() {
        data = new TreeMap<>();
    }

    public void add(String surname, Integer phoneNumber) {
        //ПЕРВЫЙ ВАРИАНТ
//        data.merge(surname,new TreeSet<>(){{add(phoneNumber);}}, (oldValue, newValue) -> {
//            oldValue.add(phoneNumber);
//            return oldValue;
//        });
        // Втрой вариант
//        if (!data.containsKey(surname)) {
//            data.put(surname, new TreeSet<>());
//        }
//        data.get(surname).add(phoneNumber);
        // Третий вариант
        Set<Integer> numbers = getPhones(surname);
        numbers.add(phoneNumber);
    }

    private Set<Integer> getPhones(String surname) {
        return data.computeIfAbsent(surname, key -> new TreeSet<>());
    }

    public void get(String surname) {
        if (data.containsKey(surname)) {
            System.out.println(surname + " phones: " + data.get(surname));
        } else System.out.println("Surname " + surname + " not found");
    }

    public void printAllPhoneBook() {
        data.forEach((surname, phones) -> System.out.println(surname + ": " + phones));
    }
}
