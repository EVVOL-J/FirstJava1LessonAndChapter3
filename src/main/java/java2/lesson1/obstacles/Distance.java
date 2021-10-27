package java2.lesson1.obstacles;

public class Distance implements Obstacles {
    private final int length;

    public int getLength() {
        return length;
    }

    public Distance(int length) {
        this.length = length;
    }
}
