import java.util.Scanner;

/*Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
Конструктор класса должен заполнять эти поля при создании объекта;
Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
Вывести при помощи методов из пункта 3 ФИО и должность.
Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
* Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
*** Продумать конструктор таким образом, чтобы при создании каждому сотруднику присваивался личный уникальный идентификационный порядковый номер*/
public class homeWork4 {
    public static void main(String[] args) {
        Employee[] persona = new Employee[5];
        Employee  pers1,pers2 = new Employee();

        pers1= new Employee("Ivan","Ivanovich","Ivanov","manager", 88001,25000.0,25);

        pers2.name = "Petr";
        pers2.secondName = "Petrovich";
        pers2.lastName = "Petrov";
        pers2.post = "director";
        pers2.numberPhone = 8926;
        pers2.salary = 1000000;
        pers2.age = 50;


        for (int i = 0; i < 5; i++) {
            persona[i]= new Employee("bot" + i,"NOfather","AI",
                    "intern",8800,10000,40+(int)(Math.random()*11));

        }
               System.out.printf("BEFOR\t\t\t\t\t\t\t\tAFTER \n");
        System.out.println("Name\t Age\t Salary \t\t\tName\t Age\t Salary");

        for (int i = 0; i < 5; i++) {
            persona[i].printEmplSalary();//System.out.printf("%s \t %d \t %f \t\t",getName(),getAge(),getSalary());
            persona[i].risePost();
            persona[i].printEmplSalary();
            System.out.println();
        }

    }
}
