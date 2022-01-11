package Java3.lesson1;

public class Fruit {
    private final String name;
    private final double weight;

    public Fruit(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
}
