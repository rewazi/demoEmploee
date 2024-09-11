package org.example;

public class App {
    public static void run(){
        Addres addres = new Addres();
        addres.setCity("йыхви");
        addres.setState("Ида вирума");
        addres.setZip("41536");
        addres.setStreet("Нарвское шоссе");
        addres.setHouse("80");
        Person person = new Person("ivan","ivanov",2000,11,17, addres);
        Employee employee = new Employee(person,"Директод","3000");


        System.out.printf(
                "Name:%s Family %s, doljnost %s, age %s, salary %s, address %s, %s, %s, %s,",
                employee.getPerson().getName(),
                employee.getPerson().getSurname(),
                employee.getAppointment(),
                employee.getPerson().getAge(),
                employee.getSalary(),
                employee.getPerson().getAddres().getState(),
                employee.getPerson().getAddres().getCity(),
                employee.getPerson().getAddres().getStreet(),
                employee.getPerson().getAddres().getHouse()
        );
    }
}
