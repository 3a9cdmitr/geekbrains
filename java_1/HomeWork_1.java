/*

*РїСЂРѕРіСЂР°РјРјСѓ РїРёСЃР°Р» РЅР° С‚РµР»РµС„РѕРЅРµ(РІ РѕС‚РїСѓСЃРєРµ РЅРµС‚ РЅРѕСѓС‚Р±СѓРєРє), РїРѕСЌС‚РѕРјСѓ СѓСЃР»РѕРІРёСЏ Р·Р°РґР°РЅРёР№ РЅРµ РїРёСЃР°Р»,В 

*Рё РїСЂР°РІРёР»СЊРЅРѕСЃС‚СЊ РїСЂРѕРІРµСЂРёС‚СЊ РЅРµ СЃРјРѕРі:-(В 

*РїСЂРѕС€Сѓ РІ СЌС‚РѕС‚ СЂР°Р· РѕС‚РЅРµСЃС‚РёСЃСЊ СЃ РїРѕРЅРёРјР°РЅРёРµРј, Р° РѕС‚РѕСЂРІР°С‚СЊСЃСЏ РЅР° РјРЅРµ РІ СЃР»РµРґСѓСЋС‰РёРµ СЂР°Р·С‹

**/

Package ru.geekbrains.javaone.lesson_a.homework;

public class HomeWork_1{

В public static void main(string[] args){В 

В В byte b= -120;

В В short sh= 32000;

В В int i= -33000;

В В long =200L;

В В float fl=1.2f;

В В double answ=1.2;

В В char='a';

В В bool checki=false;


В answ=expr(1,2,3,4);

В checki=checkInterval (10,10);

В checkPositive(0);

В printName("Dmitr");

В checkYear(2000);



}


В public static double expr( int a,b,c,d){

В В double temp = (double) c/d;

В В return a*(b+temp);

}

В 

public static boolean checkInterval(int a,b){

В В if (10<=a+b && a+b<=20)В  return true;

В В else return false;

/* return (10<=a+b && a+b<=20) РїРѕ РёРґРµРµ РґРѕР»Р¶РЅР° СЃСЂР°Р±РѕС‚Р°С‚СЊ, РЅРѕ РЅРµ РїСЂРѕРІРµСЂСЋ.

РџСЂРѕС‡РёС‚Р°Р», С‡С‚Рѕ С„РёРіСѓСЂРЅС‹Рµ СЃРєРѕР±РєРё РЅР° РѕРґРЅРѕ РІС‹СЂР°Р¶РµРЅРёРµ РЅРµ РѕР±СЏР·Р°С‚РµР»СЊРЅС‹. */

}


public static void checkPositive(int number){

В String text=number>=0?"РїРѕР»РѕР¶РёС‚РµР»СЊРЅРѕРµ":"РѕС‚СЂРёС†Р°С‚РµР»СЊРЅРѕРµ";

В В System.out.print("Р’С‹ РІРІРµР»Рё " +text+"С‡РёСЃР»Рѕ")

}


public static void printName(string youname){

В System.out.println("<<РџСЂРёРІРµС‚, "+youname+" !>>")

}


public static void checkYear( int year){

В В if ((year%4== 0 && year%100!=0) || year%400==0) System.out.println("Р’С‹ РІРІРµР»Рё РІРёСЃРѕРєРѕСЃРЅС‹Р№ РіРѕРґ");

В else System.out.println("Р’С‹ РІРІРµР»Рё РЅРµРІРёСЃРѕРєРѕСЃРЅС‹Р№ РіРѕРґ");

//Р¤РёРіСѓСЂРЅС‹Рµ СЃРєРѕР±РєРё РѕС‚СЃСѓС‚СЃС‚РІСѓСЋС‚ РїРѕ РїСЂРёС‡РёРЅРµ РІС‹С€Рµ


}

}

