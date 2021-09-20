package java1.lesson2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Homework {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4(5);
        int[] a={1, 2, 3, 4 , 5, 6, 7};
        task5(a);
        System.out.println(task6CheckBalance(a));
        task7ShiftArray(a, -1);


    }




    private static void task1(){
        System.out.println("Task1:");
        byte[] a={ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        System.out.println(Arrays.toString(a));
        for(int i=0; i<a.length; i++){
            a[i]= (byte) ((a[i]==1) ? 0 : 1);
        }
        System.out.println(Arrays.toString(a));
    }

    private static void task2() {
        System.out.println("Task2:");
        int[] a=new int[8];
        for (int i=0; i<a.length;i++){
            a[i]=i*3;
        }
        System.out.println(Arrays.toString(a));
    }

    private static void task3(){
        System.out.println("Task2:");
        int[] a={1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println(Arrays.toString(a));
        for (int i=0; i<a.length;i++){
            if (a[i]<6) a[i]*=2;
        }
        System.out.println(Arrays.toString(a));
    }
    private static void task4(int size){
        int[][] a=new int[size][size];
        for (int i=0; i<a.length;i++){
            a[i][i]=1;
            a[i][a.length-1-i]=1;
                System.out.println(Arrays.toString(a[i]));
            }
    }

    private static void task5(int[] a){
        int maxValue=a[0];
        int minValue=a[0];
        for (int b:a){
            if (maxValue<b) maxValue=b;
            if (minValue>b) minValue=b;
        }

        System.out.printf("Max value is %d and min value is %d \n", maxValue, minValue);
    }

    private static boolean task6CheckBalance(int[] a) {
        if(a.length==0){
            System.out.println("Null array");
            return false;
        }

        int leftSum=a[0];
        int rightSum=a[a.length-1];
        int leftIndex=1;
        int rightIndex=1;
       while (leftIndex+rightIndex<a.length){
           if(leftSum<rightSum){
               leftSum+=a[leftIndex];
               leftIndex++;
           }
           else{
               rightSum+=a[a.length-1-rightIndex];
               rightIndex++;
           }
           System.out.printf("Left sum=%d Right sum=%d \n", leftSum, rightSum);
       }
        return leftSum==rightSum;
    }

    private static int[] task7ShiftArray(int[] a, int n){
        if(a.length==0){
            System.out.println("Null array");
            return null;
        }
        if (a.length<=Math.abs(n))n%=a.length;
        if (n<0) n+=a.length;
        int pos;
        int saveNumber=a[0];
        int saveNumber2;
        for(int i=1; i<=a.length;i++){
            pos=(n*i)%(a.length);
            saveNumber2=a[pos];
            a[pos]=saveNumber;
            saveNumber=saveNumber2;
                    }
        System.out.println(Arrays.toString(a));
        return a;


    }



}
