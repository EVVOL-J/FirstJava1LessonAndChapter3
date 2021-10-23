package java1.lesson8;


public class TicTacToe {
    static final char CHAR_X = '\u2716';
    static final char CHAR_O = '\u25CB';
    static final char CHAR_NULL = '\u2981';
    static final int SIZE_FILED = 5;
    private static final int WIN_NUMBER = 4;
    private final char[][] array = new char[SIZE_FILED][SIZE_FILED];

    TicTacToe() {
        clearArray();
    }


    public boolean checkWin(char charZn) {
        if (charZn == CHAR_X) {

            if (setSymbol(CHAR_X, CHAR_O, true, array)) {
                System.out.println("Вы победили");
                return true;
            }
        } else if (charZn == CHAR_O) {
            if (setSymbol(CHAR_O, CHAR_X, true, array)) {
                System.out.println("Вы проиграли");
                return true;
            }
        }
        return false;
    }

    public boolean chekDraw() {
        for (int x = 0; x < SIZE_FILED; x++) {
            for (int y = 0; y < SIZE_FILED; y++) {
                if (array[x][y] == CHAR_NULL)

                    return false;
            }
        }
        System.out.println("Ничья!!!");
        return true;
    }


    public void computerTry() {
        setSymbol(CHAR_X, CHAR_O, false, array);
    }

    private boolean setSymbol(char charZnNotWhoTry, char charZnWhoTry, boolean checkWin, char[][] array) {
        int numberOfSymbolX;
        int numberOfSymbolY;
        int numberOfSymbolMainDiag;
        int numberOfSymbolDiag;
        //Цикл для проверки максимальной выигрышной комбинации у пользователя
        for (int win = WIN_NUMBER - 1; win > 0; win--) {
            //Цикл разбивки поля на простые подмассивы с величиной поля равной выигрышному числу по оси X
            for (int xArray = 0; xArray <= SIZE_FILED - WIN_NUMBER; xArray++) {
                //Цикл разбивки поля на простые подмассивы с величиной поля равной выигрышному числу по оси У
                for (int yArray = 0; yArray <= SIZE_FILED - WIN_NUMBER; yArray++) {
                    numberOfSymbolMainDiag = 0;
                    numberOfSymbolDiag = 0;

                    for (int x = 0; x < WIN_NUMBER; x++)//цикл внутри массива по х
                    {
                        numberOfSymbolX = 0;
                        numberOfSymbolY = 0;
                        for (int y = 0; y < WIN_NUMBER; y++) {//цикл внутри массива по y
                            //1. проверка строк
                            if (array[xArray + x][yArray + y] == charZnNotWhoTry) numberOfSymbolX++;
                            else if (array[xArray + x][yArray + y] == charZnWhoTry) numberOfSymbolX = 0;
                            //2. Проверка столбцов
                            if (array[yArray + y][xArray + x] == charZnNotWhoTry) numberOfSymbolY++;
                            else if (array[yArray + y][xArray + x] == charZnWhoTry) numberOfSymbolY = 0;

                        }
                        //3. проверка главной диагонали
                        if (array[xArray + x][yArray + x] == charZnNotWhoTry) numberOfSymbolMainDiag++;
                        else if (array[xArray + x][yArray + x] == charZnWhoTry) numberOfSymbolMainDiag = 0;
                        //4. Проверка второстепенной диагонали
                        if (array[xArray + x][yArray + WIN_NUMBER - 1 - x] == charZnNotWhoTry) numberOfSymbolDiag++;
                        else if (array[xArray + x][yArray + WIN_NUMBER - 1 - x] == charZnWhoTry) numberOfSymbolDiag = 0;
                        //Если не проверяем на выигрышь для строк и столбцов
                        if (!checkWin) {
                            if (numberOfSymbolX == win) {
                                if (trySetChar(xArray, yArray, x, 1)) return false;
                            }
                            if (numberOfSymbolY == win) {
                                if (trySetChar(xArray, yArray, x, 2)) return false;
                            }
                        }
                        //Если проверяем на выигрышь(строки и столбцы)
                        if (checkWin && (numberOfSymbolX == WIN_NUMBER || numberOfSymbolY == WIN_NUMBER)) {
                            return true;
                        }

                    }
                    //Если не проверяем на выигрышь для диагоналей
                    if (!checkWin) {
                        if (numberOfSymbolMainDiag == win) {
                            if (trySetChar(xArray, yArray, 0, 3)) return false;
                        }
                        if (numberOfSymbolDiag == win) {
                            if (trySetChar(xArray, yArray, 0, 4)) return false;
                        }
                    }
                    //Если проверяем на выигрышь(диагонали)
                    if (checkWin && (numberOfSymbolMainDiag == WIN_NUMBER || numberOfSymbolDiag == WIN_NUMBER)) {
                        return true;
                    }


                }
            }
        }
        return false;
    }

    private boolean trySetChar(int xArray, int yArray, int x, int i) {
        char[] line = new char[WIN_NUMBER];
        int numberWrite;
        //Цикл копирования столбца, строки или диагонали, предположительно с самым большим числом знаков противника
        for (int y = 0; y < WIN_NUMBER; y++) {
            switch (i) {
                case 1:
                    line[y] = array[xArray + x][yArray + y];
                    break;
                case 2:
                    line[y] = array[yArray + y][xArray + x];
                    break;
                case 3:
                    line[y] = array[xArray + y][xArray + y];
                    break;
                case 4:
                    line[y] = array[xArray + y][yArray - y + WIN_NUMBER - 1];
                    break;
                default:
                    return false;
            }

        }
        //вызов функции проверки, есть ли место для хода, если нет то возвращает -1, если есть то возвращает число в которое можно записать
        numberWrite = changeLine(line);
        if (numberWrite != -1) {
            switch (i) {
                case 1:
                    array[xArray + x][yArray + numberWrite] = CHAR_O;
                    break;
                case 2:
                    array[yArray + numberWrite][xArray + x] = CHAR_O;
                    break;
                case 3:
                    array[xArray + numberWrite][yArray + numberWrite] = CHAR_O;
                    break;
                case 4:
                    array[xArray + numberWrite][yArray - numberWrite + WIN_NUMBER - 1] = CHAR_O;
                    break;
                default:
                    break;
            }
            return true;
        } else return false;
    }

    private int changeLine(char[] line) {
        for (int x = 1; x < line.length - 1; x++) {
            if (line[x] == CHAR_NULL) {
                return x;
            }
        }
        if (line[0] == CHAR_NULL) return 0;
        else if (line[line.length - 1] == CHAR_NULL) return line.length - 1;
        return -1;
    }

    public boolean humanTry(int x, int y) {

        System.out.println(x + " " + y);
        if (!checkAndPrintCell(x, y)) {
            System.out.println("Эта ячейка уже занята");
            return false;
        }
        return true;
    }


    private boolean checkAndPrintCell(int x, int y) {
        if (array[x][y] == CHAR_NULL) {
            array[x][y] = CHAR_X;
            printArray();
            return true;
        } else return false;
    }


    public void clearArray() {
        for (int i = 0; i < SIZE_FILED; i++) {
            for (int j = 0; j < SIZE_FILED; j++) {
                array[i][j] = CHAR_NULL;
            }
        }
    }

    public void printArray() {
        for (int i = 0; i <= SIZE_FILED; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int i = 0; i < SIZE_FILED; i++) {
            System.out.print((i + 1) + "  ");
            for (int j = 0; j < SIZE_FILED; j++) {
                System.out.print(array[j][i] + "  ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");

    }

    public char[][] getArray() {
        return array;
    }
}

