package java1.lesson6.animal;

import java1.lesson6.Animal;

public class Cat extends Animal {
    public Cat(int maxRun, int maxJump, String name) {
        super(maxRun, 0, maxJump, name);
    }

    @Override
    public boolean swim(int length) {
        System.out.println("Коты не умеют плавать");
        return false;
    }
}
