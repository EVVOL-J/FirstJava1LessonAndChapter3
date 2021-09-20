package java1.lesson3;

import java.util.Random;
import java.util.Scanner;

public class guessTheNumber {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numberOfCheck=3;

        do{
            System.out.println("Угадайте число от 0 до 10 с трех попыток");
            int numberOfTry=0;
            Integer enterNumber;
           int random=(int)(Math.random()*10);
            while (numberOfTry!=numberOfCheck){
                enterNumber=checkCorrectData(scanner);
                if(enterNumber!=null){
                    if(enterNumber==random){
                        System.out.println("Вы выиграли");
                        break;
                    }
                    else if(enterNumber<random){
                        System.out.println("Введенное число меньше загаданного, осталось попыток "+(numberOfCheck-numberOfTry-1));
                        numberOfTry++;
                    }
                    else {
                        System.out.println("Введенное число больше загаданного, осталось попыток "+(numberOfCheck-numberOfTry-1));
                        numberOfTry++;
                    }
                }

            }
            if (numberOfTry==numberOfCheck){
                System.out.println("Вы проиграли");
            }
            numberOfTry=0;
            System.out.println("Сыграть еще раз?");
        }while (scanner.next().equalsIgnoreCase("Да"));
    }

    private static Integer checkCorrectData(Scanner scanner) {
        if(scanner.hasNextInt())
        {int returnNumber=scanner.nextInt();
            if(returnNumber<=10&&returnNumber>=0){
                return returnNumber;
            }
            else {
                System.out.println("Число находится вне диапазона от 0 до 10");
                return null;
            }

        }else {
            scanner.next();
            System.out.println("Введено не целочисленное число");
            return null;
        }
    }
}
