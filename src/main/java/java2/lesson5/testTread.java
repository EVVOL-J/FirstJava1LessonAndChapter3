package java2.lesson5;

import java.util.Arrays;

public class testTread {
    static final int size = 10000000;
    static final int h = size / 2;
    public static void main(String[] args) {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);

        long a=System.currentTimeMillis();
        float[] arrayWithoutTread=withoutTread(arr,0);
        System.out.println("Без потоков время равно "+ (System.currentTimeMillis()-a));

        a=System.currentTimeMillis();
        float[] arrayWithTread=withTread(arr);
        System.out.println("С потоками время равно "+ (System.currentTimeMillis()-a));

        for (int i=0; i<arr.length;i++){
            if(arrayWithoutTread[i]!=arrayWithTread[i]){
                System.out.println("Массивы не равны");
                break;
            }
        }


    }

    private static float[] withTread(float[] arr) {
        final float[] arr1=new float[h];
        final float[] arr2=new float[h];

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        try {
            Thread tread1=new Thread(()-> System.arraycopy(withoutTread(arr1,0),0,arr,0, h));
            Thread tread2=new Thread(()-> System.arraycopy(withoutTread(arr2, h),0,arr,h, h));
            tread1.start();
            tread2.start();
            tread1.join();
            tread2.join();
        } catch (Exception e){
            e.printStackTrace();
        }
        return arr;
    }

    private static float[] withoutTread(float[] arr, int smech) {


        for (int i=0; i<arr.length; i++){
            arr[i]=(float)(arr[i] * Math.sin(0.2f + (i+smech) / 5) * Math.cos(0.2f + (i+smech) / 5) * Math.cos(0.4f + (i+smech) / 2));
        }

        return arr;
    }
}
