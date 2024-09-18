package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final List<Employer> employers = new ArrayList<>();

    public void run() {
        boolean exitFromPro = false;
        Scanner scanner = new Scanner(System.in); // Scanner moved outside the loop for reuse
        System.out.println("HR");
        System.out.println("---------------------");

        do {
            System.out.println("Список задач:");
            System.out.println("0. Выход");
            System.out.println("1. Добавить работника");
            System.out.println("2. Список всех работников");
            System.out.println("3. Работники по имени и фамилии");
            System.out.println("4. Редактировать работника");
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
                case 4:
                    editEmployee(scanner); // Implement employee editing
                    break;
                default:
                    System.out.println("Error, not that number");
                    break;
            }
        } while (!exitFromPro); // Properly close the do-while loop

        System.out.println("До свидания!");
        scanner.close(); // Close the scanner
    }

    private void findEmployeeByName(Scanner scanner) {
        System.out.println("Введите имя:");
        String searchName = scanner.nextLine().trim();

        System.out.println("Введите фамилию:");
        String searchSurname = scanner.nextLine().trim();

        boolean found = false;
        for (Employer employer : employers) {
            if (employer.getPerson().getName().equalsIgnoreCase(searchName) &&
                    employer.getPerson().getSurname().equalsIgnoreCase(searchSurname)) {
                // Вывод информации о найденном работнике
                System.out.printf(
                        "Имя: %s, Фамилия: %s, Возраст: %d, Должность: %s, Зарплата: %s, Адрес: %s, %s, %s, %s, %s, %s\n",
                        employer.getPerson().getName(),
                        employer.getPerson().getSurname(),
                        employer.getPerson().getAge(),
                        employer.getAppointment(),
                        employer.getSalary(),
                        employer.getPerson().getAddress().getCity(),
                        employer.getPerson().getAddress().getState(),
                        employer.getPerson().getAddress().getZip(),
                        employer.getPerson().getAddress().getStreet(),
                        employer.getPerson().getAddress().getHouse(),
                        employer.getPerson().getAddress().getRoom()
                );
                found = true;
            }
        }

        if (!found) {
            System.out.println("Работник не найден.");
        }
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
        System.out.println("Уезд:");
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

    private void editEmployee(Scanner scanner) {
        System.out.println("Введите имя сотрудника для редактирования:");
        String searchName = scanner.nextLine().trim();

        System.out.println("Введите фамилию сотрудника для редактирования:");
        String searchSurname = scanner.nextLine().trim();

        Employer employeeToEdit = null;
        for (Employer employer : employers) {
            if (employer.getPerson().getName().equalsIgnoreCase(searchName) &&
                    employer.getPerson().getSurname().equalsIgnoreCase(searchSurname)) {
                employeeToEdit = employer;
                break;
            }
        }

        if (employeeToEdit == null) {
            System.out.println("Работник не найден.");
            return;
        }

        // Изменение данных работника
        System.out.println("Редактирование данных сотрудника...");
        System.out.println("Оставьте поле пустым, если не хотите изменять значение.");

        // Редактирование должности
        System.out.printf("Текущая должность (%s): ", employeeToEdit.getAppointment());
        String newAppointment = scanner.nextLine().trim();
        if (!newAppointment.isEmpty()) {
            employeeToEdit.setAppointment(newAppointment);
        }

        // Редактирование зарплаты
        System.out.printf("Текущая зарплата (%s): ", employeeToEdit.getSalary());
        String newSalary = scanner.nextLine().trim();
        if (!newSalary.isEmpty()) {
            employeeToEdit.setSalary(newSalary);
        }

        // Редактирование адреса
        Address address = employeeToEdit.getPerson().getAddress();

        // Редактирование города
        System.out.printf("Текущий город (%s): ", address.getCity());
        String newCity = scanner.nextLine().trim();
        if (!newCity.isEmpty()) {
            address.setCity(newCity);
        }

        // Редактирование уезда (штата)
        System.out.printf("Текущий уезд (%s): ", address.getState());
        String newState = scanner.nextLine().trim();
        if (!newState.isEmpty()) {
            address.setState(newState);
        }

        // Редактирование индекса
        System.out.printf("Текущий индекс (%s): ", address.getZip());
        String newZip = scanner.nextLine().trim();
        if (!newZip.isEmpty()) {
            address.setZip(newZip);
        }

        // Редактирование улицы
        System.out.printf("Текущая улица (%s): ", address.getStreet());
        String newStreet = scanner.nextLine().trim();
        if (!newStreet.isEmpty()) {
            address.setStreet(newStreet);
        }

        // Редактирование дома
        System.out.printf("Текущий дом (%s): ", address.getHouse());
        String newHouse = scanner.nextLine().trim();
        if (!newHouse.isEmpty()) {
            address.setHouse(newHouse);
        }

        // Редактирование квартиры
        System.out.printf("Текущая квартира (%s): ", address.getRoom());
        String newRoom = scanner.nextLine().trim();
        if (!newRoom.isEmpty()) {
            address.setRoom(newRoom);
        }

        System.out.println("Данные сотрудника успешно обновлены!");

        // Вывод обновлённых данных после редактирования
        System.out.printf(
                "Обновлённые данные сотрудника: Имя: %s, Фамилия: %s, Возраст: %d, Должность: %s, Зарплата: %s, Адрес: %s, %s, %s, %s, %s, %s\n",
                employeeToEdit.getPerson().getName(),
                employeeToEdit.getPerson().getSurname(),
                employeeToEdit.getPerson().getAge(),
                employeeToEdit.getAppointment(),
                employeeToEdit.getSalary(),
                employeeToEdit.getPerson().getAddress().getCity(),
                employeeToEdit.getPerson().getAddress().getState(),
                employeeToEdit.getPerson().getAddress().getZip(),
                employeeToEdit.getPerson().getAddress().getStreet(),
                employeeToEdit.getPerson().getAddress().getHouse(),
                employeeToEdit.getPerson().getAddress().getRoom()
        );
    }
}
