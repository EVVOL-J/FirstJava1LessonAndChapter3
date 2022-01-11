package Java3.lesson1;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {
    private final ArrayList<T> box;
    Box(){
     this.box=new ArrayList<>();
    }

    Box(T...fruit){
        this.box=new ArrayList<>(List.of(fruit));
    }


    public void addFruit(T fruit){
        box.add(fruit);
    }

    public double getWeight(){
        double weight=0;
        for (T t:box){
            weight+=t.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> compareBox){
        return Math.abs(compareBox.getWeight() - this.getWeight()) < 0.0001;
    }

    public void poulOver(Box<T> poulBox){
        for (T t: box )
        { poulBox.addFruit(t);
        }
        box.clear();
    }

}
