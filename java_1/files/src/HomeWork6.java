/*Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);

 Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.

Написать программу, которая проверяет присутствует ли указанное пользователем слово (или словосочетание, или предложение) в файле.
 (Работаем только с латиницей)

** Написать метод, проверяющий, есть ли указанное слово в файлах папки
 */

import java.io.*;
import java.util.Random;

public class HomeWork6 {
    public static void main(String[] args) {
        String check = "check";
        String file1 = "file1.txt";
        String file2 = "file2.txt";
        String file3 = "file3.txt";
        String pathdir = "./";


        newFileRandomStr(file1);
        newFileRandomStr(file2);
        addFile(file1, textFromFile(file2));
        //addFile(file3,textFromFile(file1)+textFromFile(file2)); //если надо вообще  в другой файл
        addFile(file1, check);//для проверки слова мы его туда добавляем
        System.out.printf("файл %s " + (entrySubStrToFile(file1, check) ? "" : "НЕ") + "содержит \"%s\" \n", file1, check);

        if (fileFromDir(pathdir,check)) {
            System.out.println("есть файл");
        }


    }

    private static boolean entrySubStrToFile(String name, String substr) {
        try {
            FileInputStream fin = new FileInputStream(name);
            StringBuilder str = new StringBuilder("");
            int i;
            while ((i = fin.read()) != -1) {
                str.append((char) i);
            }
            fin.close();
            return str.toString().contains(substr);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private static String textFromFile(String name) {
        try {
            FileInputStream fin = new FileInputStream(name);
            StringBuilder str = new StringBuilder();
            int i;
            while ((i = fin.read()) != -1) {
                str.append((char) i);
            }
            fin.close();
            return str.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static void addFile(String name, String str) {
        try {
            FileOutputStream fout = new FileOutputStream(name, true);
            fout.write(str.getBytes());
            fout.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private static void newFileRandomStr(String name) {
        try (FileOutputStream fout = new FileOutputStream(name))
        //я так понял, что так тоже можно, несмотря даже на то, что блок finaly мы не пишем
        //более того, я прочитал, что так даже правильнее
        //сделал так, чтоб узнать ваше мнение по этому поводу)))
        {
            fout.write(randomStr(100).toString().getBytes());
            fout.close();//и тогда не нужен
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static StringBuilder randomStr(int n) {
        Random rand = new Random();
        StringBuilder str = new StringBuilder();
        String symbols = " QWERTYUIOPASDFGHJKLMNBVCXZ qwertyuioplkjhgfdsazxcvbnm ";
        for (int i = 0; i < n; i++) {
            str.append(symbols.charAt(rand.nextInt(symbols.length())));
        }
        return str;
    }

    /*для пятого задания придется использовать класс File*/
    private static boolean fileFromDir(String name,String substring) {
        File pathdir = null;
        String[] arrayoffiles;

        try {
            pathdir = new File(name);
            if (pathdir.canRead() && pathdir.isDirectory()) {

                arrayoffiles = pathdir.list();
                for (String fileordir : arrayoffiles) {
                    File temp = new File(fileordir);
                    if (temp.isFile()) {
                        if (entrySubStrToFile(fileordir, substring))  return true;}//находит только в файлах .txt
                    else fileFromDir(name + "/" + temp.getPath(),substring); //проверяем подпапки- уходим в рекурсию
                }
            }
            return false;
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("exceptions DIR");
        }
        return false;
    }


}
