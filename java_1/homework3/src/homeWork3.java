import java.util.Random;
import java.util.Scanner;

public class homeWork3 {
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
    private static boolean isEmptyCell(int x, int y) { return field[y][x] == DOT_EMPTY;    }
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
            if (checkWin2(DOT_HUMAN,winNumber)) {
                System.out.println("Human win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
            if (chekChanse(DOT_HUMAN,winNumber-1)) field[xStep][yStep]=DOT_AI;
            showField();
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
    // идем слева направо по всему полю и проверяем
    private static boolean checkWin2(char c,int size) {
        for (int i = 0; i < fieldSizeY; i++){
            for (int j = 0; j < fieldSizeX; j++) {
                if (j <= (fieldSizeX - size) && chRight(c, i, j, size)) return true;
                if (i <= (fieldSizeY - size) && chDown(c, i, j, winNumber)) return true;
                if ((j <= (fieldSizeX - size)) && (i<=(fieldSizeY-size)) &&
                        (chFDiag(c, i, j, size)||chSDiag(c,i,j,size))) return true;

            }
        }
        return false;
    }
    private static boolean chekrigh(int i, int j,int size, int gran){
        if ((j==0)&&isEmptyCell(size,i)){
            xStep=i;
            yStep=size;
            System.out.printf("step to %d,%d \n",xStep,yStep);
            return true;}
        else if ((j==gran-size)&&isEmptyCell((gran-size-1),i)){
            xStep=i;
            yStep=gran-size-1;
            System.out.printf("step to %d,%d\n",xStep,yStep);
            return true;}
        else {
            if ((j>0)&&(j<gran-size)
                    &&isEmptyCell(j-1,i)){
                xStep=i;yStep=j-1;System.out.printf("step to %d,%d\n",xStep,yStep); return true;}
            if ((j>0)&&(j<gran-size)
                    &&isEmptyCell(j+winNumber-1,i)){
                xStep=i;yStep=j+winNumber-1;System.out.printf("step to %d,%d\n",xStep,yStep); return true;}

        }
        return false;
    }
    private static boolean checkdow(int i,int j,int size,int gran){
        if ((i==0)&&isEmptyCell(j,size)){
            xStep=size;
            yStep=j;
            System.out.printf("step to %d,%d \n",xStep,yStep);
            return true;}
        else if ((i==gran-size)&&isEmptyCell(j,(gran-size-1))){
            xStep=gran-size-1;
            yStep=j;
            System.out.printf("step to %d,%d\n",xStep,yStep);
            return true;}
        else {
            if ((i>0)&&(i<gran-size)
                    &&isEmptyCell(j,i-1)){
                xStep=i-1;yStep=j;System.out.printf("step to %d,%d\n",xStep,yStep); return true;}
            if ((i>0)&&(i<gran-size)
                    &&isEmptyCell(j,i+winNumber-1)){
                xStep=i+winNumber-1;yStep=j;System.out.printf("step to %d,%d\n",xStep,yStep); return true;}

        }
        return false;

    }

    private static boolean chekChanse(char c,int size){
        for (int i = 0; i < fieldSizeY; i++){
            for (int j = 0; j < fieldSizeX; j++) {
                if (j <= (fieldSizeX - size) && chRight(c, i, j, size)) {
                    if (chekrigh(i,j,size,fieldSizeX)) return true;
                }
                if (i<=(fieldSizeY-size)&&chDown(c,i,j,size)){
                    if (checkdow(i,j,size,fieldSizeY)) return true;
                }
               /* if (i <= (fieldSizeY - size) && chDown(c, i, j, winNumber)) return true;
                if ((j <= (fieldSizeX - size)) && (i<=(fieldSizeY-size)) &&
                        (chFDiag(c, i, j, size)||chSDiag(c,i,j,size))) return true;
*/
            }
        }
        return false;

    }




}