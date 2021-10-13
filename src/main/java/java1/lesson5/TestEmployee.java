package java1.lesson5;

public class TestEmployee {
    public static void main(String[] args) {
        Employee[] employee=new Employee[5];
        employee[0]=new Employee("Employee1", "1","1@mail.ru", "1",10, 28);
        employee[1]=new Employee("Employee2", "2","2@mail.ru", "2",20, 28);
        employee[2]=new Employee("Employee3", "3","3@mail.ru", "3",30, 28);
        employee[3]=new Employee("Employee4", "4","4@mail.ru", "4",40, 28);
        employee[4]=new Employee("Employee5", "5","5@mail.ru", "5",50, 28);
        for (Employee em:employee){
            em.setAge((int)(Math.random()*100));
            em.employeeInfo();
        }
        System.out.println("Тем кому за 40:");
        for (Employee em:employee){
            if(em.getAge()>40) em.employeeInfo();
        }


    }
}
