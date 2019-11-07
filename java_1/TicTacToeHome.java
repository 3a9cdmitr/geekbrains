import java.util.Random;
import java.util.Scanner;

public class TicTacToeHome {
    private static char[][] field;
    private static int fieldSizeX = 8;
    private static int fieldSizeY = 5;
    private static int winNumber =3;
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
//        System.out.print("Enter size X and Y:");
//        fieldSizeX=SCANNER.nextInt();
//        fieldSizeY=SCANNER.nextInt();

        initField();
        showField();
        while (true) {
            humanTurn();
            showField();
            if (checkWin(DOT_HUMAN,winNumber)) {
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
            if (checkWin(DOT_AI,winNumber)) {
                System.out.println("Computer win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }


        }


    }

    /*разбиваем поле на квадраты со стороной выигрыша и проверяем в каждом квадрате поля, столбцы и диагонали
    метод плох тем, что проходим по некоторым строкам\столбцам по несколько раз
    * */
    //pass a small square(size of winsize) over a large rectangle
    private static boolean checkWin(char c,int size) {
        for (int i=0; i<=fieldSizeY-size; i++)
            for (int j=0; j<=fieldSizeX-size;j++)
                if (checkLine(c,size,i,j)||checkDiag(c,size,i,j)) return true;
        return false;
    }
    //check diagonal in sqaresize
    private static boolean checkDiag(char symb, int size,int ystart, int xstart){
        boolean fd=true, sd=true;
        for (int k=0; k<=ystart; k++) {
            for (int l = 0; l <= xstart; l++) {
                fd = true;
                sd = true;
                for (int i = 0; i < size; i++) {
                    fd = fd & (field[i + k][i + l] == symb);
                    sd = sd & (field[i + k][size - i -1 + l] == symb);
                }
                if (fd || sd) {
                    xStep=k;
                    yStep=l;
                    return true;

                }
            }
        }
        return false;
    }

    //check row and col in squaresize
    private static boolean checkLine (char symb, int size,int ystart,int xstart){
        boolean row, col;
        for (int i=0; i<size; i++){
            row=true;
            col=true;
            for (int j=0; j<size; j++){
                row=row&(field[j+ystart][i+xstart]==symb);
                col=col&(field[i+ystart][j+xstart]==symb);
            }
            if (col||row){
                xStep=xstart;
                yStep=ystart;
                return true;
            }
        }
        return false;
    }

    private static void aiTurn() {
        int x, y;
        findStep(DOT_AI);
        findStep(DOT_HUMAN);

        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = DOT_AI;
    }
/* должна быть организована проверка на нехватку одного хода для победы
* не смог
* решил пойти другим путем(во втором файле*/
    private static boolean findStep(char c){
        int x,y;
        if (checkWin(c,winNumber-1)) {
            System.out.printf("%c have chanse \n",c);

            System.out.println(xStep);
            System.out.println(yStep);
            return true;
        }
        return false;
    }


}