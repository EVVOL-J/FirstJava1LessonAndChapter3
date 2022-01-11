package Java3.lesson1;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[] strArray={"0","1","2","3","4","5"};
        Integer[] intArray={0,1,2,3,4,5};
        swap(strArray, 1, 4);
        swap(intArray, 1, 2);
        System.out.println(Arrays.toString(strArray));
        System.out.println(Arrays.toString(intArray));
        //_______________________________
        System.out.println(convert(intArray));
        System.out.println(convert(strArray));
        //--------------------------------
        Box<Apple> appleBox=new Box<>();
        for (int i=6;i>0; i--){
            appleBox.addFruit(new Apple());
        }
        Box<Orange> orangeBox=new Box<>();
        for (int i=4;i>0; i--){
           orangeBox.addFruit(new Orange());
        }
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());

        System.out.println(appleBox.compare(orangeBox));

        Box<Apple> appleBox1=new Box<>();

        appleBox.poulOver(appleBox1);
        System.out.println(appleBox.getWeight());
        System.out.println(appleBox1.getWeight());


    }

    private static <T> void swap(T[] array, int first, int second){
        if(first>=array.length|| second>=array.length){
            System.out.println("Значения находятся вне диапазона массива");
            return;
        }
        T memory=array[second];
        array[second]=array[first];
        array[first]=memory;


    }

    private static <T> ArrayList<T> convert(T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }
}
