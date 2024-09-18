package org.example.manages;

import org.example.Employer;
import org.example.Address;
import org.example.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeManage {
    private final List<Employer> employers = new ArrayList<>(); // Список работников

    // Метод для создания нового работника
    public void createEmployee(Scanner scanner) {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        System.out.println("Введите фамилию:");
        String surname = scanner.nextLine();

        System.out.println("Введите дату рождения (дд мм гггг):");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        scanner.nextLine(); // Поглощаем символ новой строки

        System.out.println("Введите должность:");
        String appointment = scanner.nextLine();

        System.out.println("Введите зарплату:");
        String salary = scanner.nextLine();

        System.out.println("Введите адрес:");
        System.out.println("Город:");
        String city = scanner.nextLine();
        System.out.println("Область:");
        String state = scanner.nextLine();
        System.out.println("Индекс:");
        String zip = scanner.nextLine();
        System.out.println("Улица:");
        String street = scanner.nextLine();
        System.out.println("Дом:");
        String house = scanner.nextLine();
        System.out.println("Квартира:");
        String room = scanner.nextLine();

        Address address = new Address();
        address.setCity(city);
        address.setState(state);
        address.setZip(zip);
        address.setStreet(street);
        address.setHouse(house);
        address.setRoom(room);

        Person person = new Person(name, surname, address, day, month, year);

        Employer employer = new Employer(person, appointment, salary);

        employers.add(employer); // Добавляем нового работника в список
        System.out.println("Работник добавлен успешно!");
    }

    // Метод для отображения списка всех работников
    public void list() {
        if (employers.isEmpty()) {
            System.out.println("Нет работников в списке.");
        } else {
            for (Employer employer : employers) {
                System.out.printf(
                        "Имя: %s, Фамилия: %s, Возраст: %d, Должность: %s, Зарплата: %s, Адрес: %s, %s, %s, %s\n",
                        employer.getPerson().getName(),
                        employer.getPerson().getSurname(),
                        employer.getPerson().getAge(),
                        employer.getAppointment(),
                        employer.getSalary(),
                        employer.getPerson().getAddress().getCity(),
                        employer.getPerson().getAddress().getStreet(),
                        employer.getPerson().getAddress().getHouse(),
                        employer.getPerson().getAddress().getState()
                );
            }
        }
    }

    // Метод для поиска работника по имени и фамилии
    public void findEmployeeByName(Scanner scanner) {
        System.out.println("Введите имя:");
        String searchName = scanner.nextLine();

        System.out.println("Введите фамилию:");
        String searchSurname = scanner.nextLine();

        boolean found = false;
        for (Employer employer : employers) {
            if (employer.getPerson().getName().equalsIgnoreCase(searchName) &&
                    employer.getPerson().getSurname().equalsIgnoreCase(searchSurname)) {
                System.out.printf(
                        "Имя: %s, Фамилия: %s, Возраст: %d, Должность: %s, Зарплата: %s, Адрес: %s, %s, %s, %s\n",
                        employer.getPerson().getName(),
                        employer.getPerson().getSurname(),
                        employer.getPerson().getAge(),
                        employer.getAppointment(),
                        employer.getSalary(),
                        employer.getPerson().getAddress().getCity(),
                        employer.getPerson().getAddress().getStreet(),
                        employer.getPerson().getAddress().getHouse(),
                        employer.getPerson().getAddress().getState()
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("Работник не найден.");
        }
    }
}