package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private List<Employer> employers = new ArrayList<>();

    public void run() {
        boolean exitFromPro = false;
        Scanner scanner = new Scanner(System.in); // Scanner moved outside the loop for reuse
        System.out.println("HR");
        System.out.println("---------------------");

        do {
            System.out.println("Список задач:");
            System.out.println("0. Exit");
            System.out.println("1. Добавить работника");
            System.out.println("2. Список всех работников");
            System.out.println("3. Работники по имени и фамилии");
            System.out.print("Выберите задачу: ");

            int task = scanner.nextInt();
            scanner.nextLine(); // Consume newline character after nextInt()

            switch (task) {
                case 0:
                    System.out.println("Выход из программы");
                    exitFromPro = true; // Set flag to true to exit loop
                    break;
                case 1:
                    createEmployee(scanner); // Call createEmployee method
                    break;
                case 2:
                    listAllEmployees(); // Implement listing all employees
                    break;
                case 3:
                    findEmployeeByName(scanner); // Implement employee search by name
                    break;
                default:
                    System.out.println("Error, not that number");
                    break;
            }
        } while (!exitFromPro); // Properly close the do-while loop

        System.out.println("heat aega!");
        scanner.close(); // Close the scanner
    }

    private void createEmployee(Scanner scanner) {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        System.out.println("Введите фамилию:");
        String surname = scanner.nextLine();

        System.out.println("Введите дату рождения (дд мм гггг):");
        int day = scanner.nextInt();
        int month = scanner.nextInt();
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left by nextInt()

        System.out.println("Введите должность:");
        String appointment = scanner.nextLine();

        System.out.println("Введите зарплату:");
        String salary = scanner.nextLine();

        System.out.println("Введите адрес:");
        System.out.println("Город:");
        String city = scanner.nextLine();
        System.out.println("Штат/Область:");
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

        employers.add(employer); // Add the new employer to the list
        System.out.println("Работник добавлен успешно!");
    }

    private void listAllEmployees() {
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

    private void findEmployeeByName(Scanner scanner) {
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
