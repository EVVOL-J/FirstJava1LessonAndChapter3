package java1.lesson7;

import java.util.Scanner;

public class TestFeed {
    public static void main(String[] args) {
        Cat[] cats=new Cat[5];
        cats[0]=new Cat("Барсик", 5);
        cats[1]=new Cat("Толя", 3);
        cats[2]=new Cat("Мышь", 7);
        cats[3]=new Cat("Дрю", 3);
        cats[4]=new Cat("Блэк", 8);

        Plate plate=new Plate(25, 15);
        Scanner scanner=new Scanner(System.in);

        while (!allCatsSatiety(cats)){
            for(Cat cat:cats){
                if(cat.isSatiety())continue;
                cat.eat(plate);
                checkPlateAndAddFood(plate, scanner);
            }
        }

        System.out.println("Все коты сытые");

    }

    private static void checkPlateAndAddFood(Plate plate, Scanner scanner) {
        int food;
        if(plate.getFoodInPlate()==0){
            System.out.println("Положите еду в тарелку");
            while (true){
                if(!scanner.hasNextInt()){
                    System.out.println("Введены некорректные данные ");
                    scanner.next();
                }
                else {
                    food=scanner.nextInt();
                    if(food<=0) System.out.println("Введены некорректные данные");
                    else {
                        plate.addFood(food);
                        return;
                    }

                }
            }

        }
    }

    private static boolean allCatsSatiety(Cat[] cats) {
        for (Cat cat: cats){
            if(!cat.isSatiety()) return false;
        }
        return true;
    }
}
