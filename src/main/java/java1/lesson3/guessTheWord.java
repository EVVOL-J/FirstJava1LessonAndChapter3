package java1.lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class guessTheWord {


    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi",
                "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};
        Scanner scanner = new Scanner(System.in);
        String randomWord;
        StringBuilder passwordWord = new StringBuilder();
        passwordWord.append("###############");
        String ourWord;
        int size;
        do {
            randomWord = words[(int) (Math.random() * words.length)];
            System.out.println("Угадай слово из этого списка:");
            System.out.println(Arrays.toString(words));
            ourWord = scanner.next();
            ourWord.trim();
            while (!randomWord.equals(ourWord)) {
                size = Math.min(randomWord.length(), ourWord.length());
                for (int i = 0; i < size; i++) {
                    if(randomWord.charAt(i)==ourWord.charAt(i))
                    { passwordWord.deleteCharAt(i);
                        passwordWord.insert(i, ourWord.charAt(i));
                    }


                }
                System.out.println("Вы не угадали, попробуйте ещё раз");
                System.out.println(passwordWord);
                passwordWord.replace(0,14,"###############");
                ourWord = scanner.next();
            }
            System.out.println("Вы угадали!!! " + randomWord);
            System.out.println("Для того чтобы начать сначала введите ДА, иначе нажмите любую клавишу");



        }
        while (scanner.next().equalsIgnoreCase("Да"));
    }
}
