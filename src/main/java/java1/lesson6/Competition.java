package java1.lesson6;

import java1.lesson6.animal.Cat;
import java1.lesson6.animal.Dog;
import java1.lesson6.obstacles.Obstacles;
import java1.lesson6.obstacles.Pool;
import java1.lesson6.obstacles.Road;
import java1.lesson6.obstacles.Wall;

public class Competition {
    private static final int SIZE_ARRAY=10;
    public static void main(String[] args) {
        Animal[] animal=new Animal[SIZE_ARRAY];

        for (int i=0; i<SIZE_ARRAY; i++){
            animal[i]=new Cat((int)(Math.random()*1000),(int)(Math.random()*15),"Cat"+i);
            animal[i].animalInfo();
            i++;
            animal[i]=new Dog((int)(Math.random()*1000),(int)(Math.random()*100),(int)(Math.random()*100), "Dog"+i);
            animal[i].animalInfo();
        }
        //Создание препятсвий
        Obstacles[] obstacles=new Obstacles[5];
        obstacles[0]=new Road((int)(Math.random()*600));
        obstacles[1]=new Wall((int)(Math.random()*10));
        obstacles[2]=new Road((int)(Math.random()*600));
        obstacles[3]=new Wall((int)(Math.random()*10));
        obstacles[4]=new Pool((int)(Math.random()*10));
        //Создание трассы
        ObstacleCourse obstacleCourse=new ObstacleCourse(obstacles);

        System.out.println("Начало забега");
        StringBuilder winAnimals=new StringBuilder();
        winAnimals.append("Список победителей:\n");
        for (Animal ani:animal){
            if(!obstacleCourse.completeObstacles(ani)) System.out.println("Животное "+ ani.name+ " выболо из состязания");
            else{
                System.out.println("Животное "+ ani.name+ " прошло все препятствия");
                winAnimals.append(ani.name+"\n");
            }
        }
        if(winAnimals.length()>20) System.out.println(winAnimals);
        else System.out.println("Победителей нет");


    }


}
