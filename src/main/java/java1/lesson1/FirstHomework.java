package java1.lesson1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FirstHomework {
    public static void main(String[] args) {
       byte b=10;//task2
       short s=3;
       int i=5;
       long l=56L;
       double d=2.3;
       float f=2.4f;
       boolean bool=true;
       var v = 34;
       char c='a';
       String str="Hello";

        System.out.printf("%.2f \n", operationMath(3,3,4,9));
        System.out.println(comparison(b, i));
        positiveOrNegative(-5);
        positiveOrNegative(4);
        System.out.println(numberIsNegative(-4));
        printToConsole("Djon");
        Scanner scanner=new Scanner(System.in);

       for(int k=0; k<5; k++) {
           System.out.print("Enter year ");
          if (scanner.hasNextInt())
              leapYear(scanner.nextInt());
          else {System.out.println("Enter not number or int");
          scanner.next();}

       }


    }
    

    private static boolean comparison(byte b, int i) {//task 3
        int sum=b+i;
       return  20>= sum && sum>=10 ;
    }


    public static double operationMath(int a, int b, int c, int d){//task 4
        if(d==0){
            System.out.println("cannot be divided by 0");
            return 0;
        }
        return a*(b+(1.0*c/d));
    }

    public static void positiveOrNegative(int a){ //task5
        if(a>=0) System.out.printf("Number %d is positive \n", a);
        else System.out.printf("Number %d is negative \n", a);
    }

    public static boolean numberIsNegative(int a){//task6
        return a<0;
    }

    public static void printToConsole(String name){//task7
        System.out.println("Hello"+ name);
    }

    public static void leapYear(int year){//task 8
        if(year%4==0&&(year%400==0||year%100!=0)) System.out.println("Year is leap");
        else System.out.println("Year is not leap");
    }




    
    
}

