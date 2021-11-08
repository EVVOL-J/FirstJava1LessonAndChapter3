package java2.lesson4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class CollectionsPerson {
    private ObservableList<Person> personList;

    public CollectionsPerson() {
        this.personList = FXCollections.observableArrayList();
        personList.add(new Person("Voloshin", "Evgeniy", 25));
        personList.add(new Person("Torshin", "Roman", 25));
        personList.add(new Person("Vaskin", "Roman", 24));

    }

    public ObservableList getPersonList() {
        return personList;
    }
}

