package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static class Student{
        int age;
        String lastname;
        int group;
        public Student(int age, String lastname, int group){
            this.age = age;
            this.lastname = lastname;
            this.group = group;
        }

        @Override
        public String toString() {
            return "Student " +
                    "age=" + age +
                    ", lastname='" + lastname + '\'' +
                    ", group=" + group;
        }
    }

    //Вибір методу сортвування
    static public void task_36_input(Student [] students){
        int x;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose sort: 1-by age, 2-by lastname, 3-by group.");
        x = sc.nextInt();
        while (x<1 || x>3) {System.out.println("Choose sort: 1-by age, 2-by lastname, 3-by group.");
            x = sc.nextInt();}

        task_36_sort(students, x);
    }

    //Безпосереднє сортування відповідно до обраного способу
    static public void task_36_sort (Student [] students, int x) {
        switch (x) {
            case 1 -> Arrays.sort(students, (st1, st2) -> st1.age - st2.age);
            case 2 -> Arrays.sort(students, new Comparator<>() {
                @Override
                public int compare(Student st1, Student st2) {
                    return st1.lastname.compareTo(st2.lastname);
                }
            });
            case 3 -> Arrays.sort(students, (st1, st2) -> st1.group - st2.group);
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    static public void task_38() {
        Scanner sc = new Scanner(System.in);
        int z;
        do {
            System.out.println("Input 2 numbers: ");
            int y = sc.nextInt();
            int x = sc.nextInt();
            try {
                z = x / y;
                } catch (ArithmeticException arithmeticException) {
                System.out.println(arithmeticException);
                System.out.println("Error, y = 0");
                z = -1; }
            System.out.println("Z = " + z);}
            while (z == -1);
    }

    //Show the difference between abstract class and interface
    public abstract static class Bird{
        private String species;
        private int age;

        public abstract void fly();
    }

    public static class Parrot extends Bird implements Flyable{
        @Override
        public void fly(){
            System.out.println("It is bird! And it can fly!");
        }
    }

    public interface Flyable{
        void fly();
    }

    public static class Plane implements Flyable{
        public void fly(){
            System.out.println("It is plane, but it can fly too");
        }
    }

    // Task 43 Show class inheritance
    public static class User{
        String login;
        String password;
        String email;
        int phone;

        public User(){
            this.login="login";
            this.password="password";
            this.email="email";
            this.phone=0;
            System.out.println("It is constructor in User!");
        }

        public User(String login, String password, String email, int phone){
            this.login=login;
            this.password=password;
            this.email=email;
            this.phone=phone;
            System.out.println("It is constructor in User!");
            }
            public void show_registration(){
            System.out.println("You are User! Your login: " + login + " Your password: " + password);
            }

            public void show_registration(int userNumb){
                System.out.println("You are User! Your login: " + login + " Your password: " + password);
                System.out.println("Your user number: " + userNumb);
            }
        }

        public static class Buyer extends User{
            long bill;
            String address;
            public Buyer(){
                super();
                this.bill=0;
                this.address="";
                System.out.println("It is constructor in Buyer!");
            }
            public Buyer(String login, String password, String email, int phone, long bill, String address){
                super(login, password, email, phone);
                this.bill=bill;
                this.address=address;
                System.out.println("It is constructor in Buyer!");
            }

            @Override
            public void show_registration(){
                super.show_registration();
                System.out.println("You are Buyer!");
            }

        }

        public static class Seller extends User{
            int number;
            String date;
            int bonus;
            public Seller(){
                super();
                this.number=0;
                this.date="";
                this.bonus=0;
                System.out.println("It is constructor in Seller!");
            }
            public Seller(String login, String password, String email, int phone, int number, String date, int bonus){
                super(login, password, email, phone);
                this.number=number;
                this.date=date;
                this.bonus=bonus;
                System.out.println("It is constructor in Seller!");
            }
        }

    // Task 47 Show class inheritance

    public static class Plant{
        String name;
        String area;
        int age;

        public Plant(){
            this.name="name";
            this.area="area";
            this.age=0;
            System.out.println("It is constructor in Plant");
        }
        public Plant(String name, String area, int age){
            this.name=name;
            this.area=area;
            this.age=age;
            System.out.println("It is constructor in Plant");
        }
    }

    public static class Tree extends Plant{
        int height;
        public Tree(){
            super();
            this.height=0;
            System.out.println("It is constructor in Tree");
        }
        public Tree(String name, String area, int age, int height){
            super(name, area, age);
            this.height= height;
            System.out.println("It is constructor in Tree");
        }
    }

    public static class Flower extends Plant{
        String color;
        public Flower(){
            super();
            this.color="color";
            System.out.println("It is constructor in Flower");
        }
        public Flower(String name, String area, int age, String color){
            super(name, area, age);
            this.color= color;
            System.out.println("It is constructor in Flower");
        }
    }

    public static void main(String[] args) {

        Student[] students = new Student[3];
        students[0]= new Student(19, "C", 208);
        students[1]= new Student(20, "B", 309);
        students[2]= new Student(18, "A", 102);

        task_36_input(students);
        task_36_input(students);
        task_36_input(students);

        task_38();

        // Task 43
        Parrot parrot = new Parrot();
        parrot.fly();

        Plane plane = new Plane();
        plane.fly();

        // Task 46
        User user= new User();
        Buyer buyer = new Buyer();
        Seller seller = new Seller();

        // Task 47
        Plant plant= new Plant();
        Tree tree = new Tree();
        Flower flower = new Flower();

    }

}
