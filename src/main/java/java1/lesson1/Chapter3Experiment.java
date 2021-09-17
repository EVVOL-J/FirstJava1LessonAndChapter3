package java1.lesson1;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Chapter3Experiment {
    public static void main(String[] args) {
        String s="  Hello     world";
        System.out.println(s);
        System.out.println(s.lastIndexOf("o"));
        System.out.println(s.substring(2,5));
        System.out.println(s.trim());
        System.out.println(s.strip());

        StringBuilder builder=new StringBuilder();

        builder.append(6);
        builder.append("hello ");
        builder.append("world");
        System.out.println(builder.toString());
        builder.setCharAt(5,'5');
        System.out.println(builder);
        System.out.println(builder.toString());
        builder.insert(4," lol ");
        System.out.println(builder.toString());

        double d=-46327.23;
        System.out.printf("%(.1f \n",d);

        System.out.printf("%tc \n", new Date());
        System.out.printf("Date : %tR %<tB %<td \n", new Date());

        try {
            PrintWriter out =new PrintWriter("myfile.txt",StandardCharsets.UTF_8);
            out.write("lol");
            out.println("Check");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("file not found");
        }

        try {
            Scanner in = new Scanner(Path.of("myfile.txt"), StandardCharsets.UTF_8);
            System.out.println(in.next());
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("file not found");
        }


        int[] a=new int[5];
        for (int i=0; i<a.length; i++)
            a[i]=5-i;
        int[] b=new int[5];
        for (int i=0; i<b.length; i++)
        b[i]=i+1;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(Arrays.copyOfRange(a,1,4)));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.binarySearch(a,1));
        System.out.println(a+" "+b);

        System.out.println(Arrays.equals(a,b));


    }
}
