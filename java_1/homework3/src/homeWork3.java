import java.util.Random;
import java.util.Scanner;
/*работает на поле любого размера с любим выигрышным числом*/
public class homeWork3 {
    private static char[][] field;
    private static int fieldSizeX = 9;
    private static int fieldSizeY = 6;
    private static int winNumber = 3;       //выигрышное число
    private static int xStep;
    private static int yStep;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';

    private static void initField() {
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void showField() {
        for (int i = 0; i < fieldSizeY; i++) {
            //           System.out.println("-------------");
            System.out.print('|');
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
                ;
            }
            System.out.println("");
        }
        System.out.println("----------------------");
    }

    private static void humanTurn() {
        int x, y;
        do {
            System.out.print("Enter coord X and Y : ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    private static boolean isDraw() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.print("Enter size X and Y and windNumber:");//можно вводить ручками
//        fieldSizeX=SCANNER.nextInt();
//        fieldSizeY=SCANNER.nextInt();
//        winNumber=SCANNER.nextInt();
        initField();
        showField();
        while (true) {
            humanTurn();
            showField();
            if (checkWin3(DOT_HUMAN, winNumber)) {
                System.out.println("Human win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }

            aiTurn();
            System.out.println("step AI ------");
            showField();
            if (checkWin3(DOT_AI, winNumber)) {
                System.out.println("Computer win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }


        }

    }


    //проверка на выигрыш
    private static boolean checkWin3(char c, int size) {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (chDown(c, i, j, size) || chRight(c, i, j, size) || chFDiag(c, i, j, size) || chSDiag(c, i, j, size))
                    return true;
            }
        }
        return false;
    }

    //  проверка от исх точки на size значений вниз
    /*если координаты удовлетворяют проверке, не выходя за границы, то проверяем по соотв направлению.
    * в счетчик закидываем кол-во клеточек с заданным символом.
    * если символ не совпадает- запоминаем коорд
    * в случае кода колво симовлов совпадает с колвом клеток- выиграли,
    * в случае если не хватате одного символа- проверяем его на пустую клетку и  если тру- запоминаем глобальными
    * приходится проверять каждую сторону по отдельности, поскольку сразу передаем координаты
    * если делаю один цикл прохода от точки в ширину по всем направлениям сразу, то выигрыш определитьь можно,
    * а каким образом вытащить координаты пустой клетки- не догадываюсь((
    * */
    private static boolean chDown(char c, int x, int y, int size) {
        if (x <= fieldSizeY - size) {//проверка на выход за пределы
            int numbchek = 0;//сколько символов
            int t_x = x, t_y = y;//временные переменные для координат
            for (int i = 0; i < size; i++) {
                if (field[x + i][y] == c) {
                    numbchek++;
                } else {//
                    t_x = x + i;
                    t_y = y;
                }
            }
            if (numbchek == size) return true;
            else if ((numbchek == size - 1) && isEmptyCell(t_y, t_x)) {// если не хватает одного хода и его можно сделать
                xStep = t_x;
                yStep = t_y;
            }
        }
        return false;
    }

    //проверка от исх точки на size значений вправо
    private static boolean chRight(char c, int x, int y, int size) {
        if (y <= fieldSizeX - size) {
            int numbchek = 0;
            int t_x = x, t_y = y;
            for (int i = 0; i < size; i++) {
                if (field[x][y + i] == c) {
                    numbchek++;
                } else {
                    t_x = x;
                    t_y = y + i;
                }
            }
            if (numbchek == size) return true;
            else if ((numbchek == size - 1) && isEmptyCell(t_y, t_x)) {
                xStep = t_x;
                yStep = t_y;
            }
        }
        return false;
    }

    //проверка от исх точки на size значений по диагонали вправо-вниз
    private static boolean chFDiag(char c, int x, int y, int size) {
        if ((x <= fieldSizeY - size) && (y <= fieldSizeX - size)) {
            int numbchek = 0;
            int t_x = x, t_y = y;
            for (int i = 0; i < size; i++) {
                if (field[x + i][y + i] == c) {
                    numbchek++;
                } else {
                    t_x = x + i;
                    t_y = y + i;
                }
            }
            if (numbchek == size) return true;
            else if ((numbchek == size - 1) && isEmptyCell(t_y, t_x)) {
                xStep = t_x;
                yStep = t_y;
            }
        }
        return false;
    }

    //проверка  от исх точки на size значений по диагонали вправо-вверх
    private static boolean chSDiag(char c, int x, int y, int size) {
        if ((x >= size - 1) && (y <= fieldSizeX - size)) {
            int numbchek = 0;
            int t_x = x, t_y = y;
            for (int i = 0; i < size; i++) {
                if (field[x - i][y + i] == c) {
                    numbchek++;
                } else {
                    t_x = x - i;
                    t_y = y + i;
                }
            }
            if (numbchek == size) return true;
            else if ((numbchek == size - 1) && isEmptyCell(t_y, t_x)) {
                xStep = t_x;
                yStep = t_y;
            }
        }
        return false;

    }


    private static void aiTurn() {
        int x, y;
        if (!checkWin3(DOT_AI, winNumber)) //ищем таким образом выигрышные координаты
            field[xStep][yStep] = DOT_AI;
        else {

            if (!checkWin3(DOT_HUMAN, winNumber))  //ищем координаты помехи
                field[xStep][yStep] = DOT_AI;
            else {

                do {
                    x = RANDOM.nextInt(fieldSizeX);
                    y = RANDOM.nextInt(fieldSizeY);
                } while (!isEmptyCell(x, y));
                field[y][x] = DOT_AI;
            }
        }
    }


}
