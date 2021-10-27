package java2.lesson1;

import java2.lesson1.obstacles.Distance;
import java2.lesson1.obstacles.Height;
import java2.lesson1.obstacles.Obstacles;
import java2.lesson1.participants.Cat;
import java2.lesson1.participants.Human;
import java2.lesson1.participants.Robot;



public class Competition {
    public static void main(String[] args) {
        RunningAndJumping[] participants = new RunningAndJumping[5];
        participants[0] = new Cat("Барсик", 10, 10);
        participants[1] = new Human("Рома", 15, 5);
        participants[2] = new Robot("SI3PIO", 20, 3);
        participants[3] = new Cat("Мурзик", 11, 9);
        participants[4] = new Human("Женя", 14, 6);
        Obstacles[] obstacles = new Obstacles[6];
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i] = new Height((int) (Math.random() * 3));
            i++;
            obstacles[i] = new Distance((int) (Math.random() * 20));
        }


        for (RunningAndJumping participant : participants) {
            if(participantStart(obstacles, participant)) System.out.println("Участник преодолел все препятствия");

        }

    }

    private static boolean participantStart(Obstacles[] obstacles, RunningAndJumping participant) {
        for (Obstacles obstacle : obstacles) {
            if (obstacle instanceof Height) {
                if (!participant.jump((Height) obstacle)) {
                System.out.println("Участник выбыл");
                return false;}
            } else if (obstacle instanceof Distance) {
                if (!participant.run((Distance) obstacle)) {
                System.out.println("Участник выбыл");
                return false;}
            }
        }
        return true;
    }
}
