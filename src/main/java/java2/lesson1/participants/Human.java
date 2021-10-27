package java2.lesson1.participants;

import java2.lesson1.obstacles.Distance;
import java2.lesson1.obstacles.Height;
import java2.lesson1.RunningAndJumping;

public class Human implements RunningAndJumping {
    private final String name;
    private final int max_length;
    private final int max_height;

    public Human(String name, int max_length, int max_height) {
        this.name = name;
        this.max_length = max_length;
        this.max_height = max_height;
    }

    @Override
    public boolean run(Distance distance) {
        System.out.println("Человек "+name+" бежит дистанцию:"+distance.getLength());
        if(distance.getLength()>max_length) {
            System.out.println("Человек "+name+" не преодолел дистанцию:"+distance.getLength() +" максимум "+max_length);
            return false;
        }
        else{
            System.out.println("Человек "+name+" пробежал дистанцию:"+distance.getLength());
            return true;
        }
    }

    @Override
    public boolean jump(Height height) {
        System.out.println("Человек "+name+" пытается прыгнуть на высоту:"+height.getHeight());
        if(height.getHeight()>max_height) {
            System.out.println("Человек "+name+" не перепрыгнул высоту:"+height.getHeight() +" максимум "+max_length);
            return false;
        }
        else{
            System.out.println("Человек "+name+" перепрыгнул высоту:"+height.getHeight());
            return true;
        }
    }
}
