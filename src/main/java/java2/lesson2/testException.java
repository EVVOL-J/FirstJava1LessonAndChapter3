package java2.lesson2;

public class testException {
    private final static int SIZE_ARRAY=4;
    public static void main(String[] args) {
        String[][] numberArray =
                {{"4", "5", "6", "7" },
                        {"4", "5", "6", "7" },
                        {"4", "5", "6", "7" },
                        {"4", "5", "6", "7" },
                };
        try {
            System.out.println("Сумма элементов массива равна " + convertToInt(numberArray));
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива");
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных масиива");
            e.printStackTrace();
        }


    }

    private static int convertToInt(String[][] numberArray) {
        chekSize(numberArray);
        int sum = 0;
        for (int i = 0; i < numberArray.length; i++) {
            for (int j = 0; j < numberArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(numberArray[i][j]);

                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Элемент [" + i + "][" + j + "] не является числом");
                }
            }

        }
        return sum;

    }

    private static void chekSize(String[][] numberArray) {
        if (numberArray.length != SIZE_ARRAY) {
            throw new MyArraySizeException();
        }
        for (String[] strings : numberArray) {
            if (strings.length != SIZE_ARRAY) throw new MyArraySizeException();
        }

    }

}

