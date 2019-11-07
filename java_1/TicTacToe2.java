import java.util.Random;
import java.util.Scanner;

public class TicTacToe2 {
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
//        System.out.print("Enter size X and Y:");//можно вводить ручками
//        fieldSizeX=SCANNER.nextInt();
//        fieldSizeY=SCANNER.nextInt();

        initField();
        showField();
        while (true) {
            humanTurn();
            showField();
            if (checkWin2(DOT_HUMAN)) {
                System.out.println("Human win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
           // chekStep(DOT_HUMAN);
 /*           aiTurn();                            //отключил для проверки
            System.out.println("step AI ------");
            showField();
            if (checkWin2(DOT_AI)) {
                System.out.println("Computer win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
*/

        }


    }
 /*видимо выбрал не правильную стратегию для хода компьютера(((
 * проверка на выигрышность  выполнил двумя способами( оч похожи)
 * 1- выбираем квадрат размером выигрыша и пробегаем им по полю, проверяя его
 * 2- пробегаем по всем клеточкам слева направо по полю меньшим на выигрыш и от клетки проверяем */


    //  проверка от исх точки на size значений вниз
    private static boolean chDown(char c, int x,int y, int size){
        boolean good=true;
        for (int  i=0; i<size; i++)
            good&=(field[x+i][y]==c);
        return good;
    }
    //проверка от исх точки на size значений вправо
    private static boolean chRight(char c, int x,int y, int size){
        boolean good=true;
        for (int  j=0; j<size; j++)
            good&=(field[x][y+j]==c);
        return good;
    }
    //проверка от исх точки на size значений по диагонали вправо-вниз
    private static boolean chFDiag(char c, int x,int y, int size){
        boolean good=true;
        for (int  i=0; i<size; i++)
            good&=(field[x+i][y+i]==c);
        return good;
    }
    //проверка НЕ от исх точки на size значений по диагонали левыйнижний-правверхний
    private static boolean chSDiag(char c, int x,int y, int size){
        boolean good=true;
        for (int  i=0; i<size; i++)
            good&=(field[x+size-i-1][y+i]==c);
        return good;
    }
    // проверяем от исходной точки вправо, вниз, по диагоналям
    private static boolean checkRound(char c, int x, int y,int size){
        return (chRight(c,x,y,size)||chDown(c,x,y,size)||chFDiag(c,x,y,size)||chSDiag(c,x,y,size));
    }
    // идем слева направо по всему полю, не доходя до краев на winNumber и проверяем chekRound
    //не проверяет все поле(((( НЕ РАБОТАЕТ
    private static boolean checkWin2(char c){
        for (int i=0; i<fieldSizeY;i++)
            for (int j=0; j<fieldSizeX ;j++){
                if (i<(fieldSizeY-winNumber)&&chRight(c,x,y,winNumber)
            }
                if (checkRound(c,i,j,winNumber)) return true;
     return false;
    }
    //в идеале должны пробежать по всему полю и проверить на winNuber-1
    /*проблема в крайних значениях- вылазим за пределы при проверке на свободность ячейки*/
    private static boolean chekStep(char c){
        int size=winNumber-1;
        for (int i=0; i<fieldSizeY;i++)
            for (int j=0; j<fieldSizeX;j++){

                if ((i<(fieldSizeY-size))&&chDown(c,i,j,size)&&isEmptyCell(j,i+size)){
                    xStep=i+size;
                    yStep=j;
                    field[xStep][yStep] = DOT_AI;
                    showField();
                    return true;
                }
               if ((j<(fieldSizeX-size))&&chRight(c,i,j,size)&&isEmptyCell(j+size,i)){
                    xStep=i;
                    yStep=j+size;
                    field[xStep][yStep]=DOT_AI;
                    showField();

                    return true;
                }



            }
    return false;
    }



/*
разбивал поле на квадраты размером выигрышного числа
в квадрате проверял столбцы. колонки и диагонали на выигрыш
квадратом пробегал по всему полю.
для

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
*/
}
