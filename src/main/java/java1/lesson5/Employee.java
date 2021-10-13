package java1.lesson5;

public class Employee {
    private String fio;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;



    public Employee(String fio, String position, String email, String phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public void employeeInfo(){
        System.out.printf("ФИО:%s \n Должность:%s \n Эмэйл:%s \n Телефон:%s \n Зарплата:%d \n Возраст:%s \n _______________\n",
                fio, position, email, phone, salary, age);
    }
    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
