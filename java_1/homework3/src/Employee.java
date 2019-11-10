public class Employee {
    String name;
    String secondName;
    String lastName;
    String post;
    int numberPhone;
    double salary;
    int age;
    int ID;          //завел исключительно для просмотра
    static int IDCOUNT=1;

    public Employee() {
        this.ID = IDCOUNT;
        IDCOUNT++;

    }

    public Employee(String name,String secondName,String lastName,String post,int numberPhone,double salary,int age){
        this();
        this.name=name;
        this.secondName=secondName;
        this.lastName=lastName;
        this.post=post;
        this.numberPhone=numberPhone;
        this.salary=salary;
        this.age=age;
        //printAboutEmpl();
    }

    public String getName() {return name;}
    public String getSecondName() {return secondName;}
    public String getLastName() {return lastName;}
    public String getPost() {return post;}
    public int getNumberPhone() {return numberPhone;}
    public double getSalary() {return salary;}
    public int getAge() {return age;}
    public int getID() {return ID;}

    void printAboutEmpl(){
        System.out.printf("lastName: %s, Name: %s, secondname: %s, post: %s, \n",getLastName(),getName(),getSecondName(),getPost());
    }
    public void risePost() {
        if (this.age > 45) this.salary += 5000;
    }
    public void printEmplSalary(){
        System.out.printf("%s \t %d \t %f \t\t",getName(),getAge(),getSalary());
    }


    }





