public class Main {
    public static void main(String[] args) {
        //Создаем хранилище
        EmployeeBook employeeBook = new EmployeeBook(20);
        //Добавляем сотрудников
        employeeBook.addEmployee(new Employee(new Person("Валиев", "Александр", "Сергеевич"), 2, 46_200));
        employeeBook.addEmployee(new Employee(new Person("Петров", "Виктор", "Анатольевич"), 3, 53_100));
        employeeBook.addEmployee(new Employee(new Person("Громов", "Никита", "Валерьевич"), 1, 43_400));
        employeeBook.addEmployee(new Employee(new Person("Бульдин", "Виталий", "Михайлович"), 3, 51_600));
        employeeBook.addEmployee(new Employee(new Person("Иванов", "Стас", "Вольфович"), 2, 48_700));
        employeeBook.addEmployee(new Employee(new Person("Драгунов", "Артем", "Михайлович"), 5, 57600));
        employeeBook.addEmployee(new Employee(new Person("Васильев", "Игорь", "Анатольевич"), 1, 55200));
        employeeBook.addEmployee(new Employee(new Person("Жукова", "Анна", "Анатольевна"), 4, 70400));
        employeeBook.addEmployee(new Employee(new Person("Дронова", "Мария", "Александровна"), 5, 62300));
        employeeBook.addEmployee(new Employee(new Person("Михаленко", "Антон", "Павлович"), 2, 66700));
        employeeBook.addEmployee(new Employee(new Person("Харитонов", "Владимир", "Виссарионович"), 1, 94500));
        //Смотрим список сотрудников
        System.out.println("Смотрим список сотрудников");
        employeeBook.printAllBook();
        System.out.println();
        //Ищем сотрудника
        System.out.println("Ищем сотрудника");
        employeeBook.findEmployee("Васильев");
        System.out.println();
        //Удаляем сотрудника
        System.out.println("Удаляем сотрудника");
        employeeBook.removeEmployee("Васильев");
        System.out.println();
        //Проверяем
        System.out.println("Проверяем");
        employeeBook.printAllBook();
        System.out.println();
        //Ищем сотрудника и меняем отдел и зарплату
        System.out.println("Ищем сотрудника и меняем отдел и зарплату");
        employeeBook.changeEmployee("Валиев", 4, 58700);
        System.out.println();
        //Проверяем
        System.out.println("Проверяем");
        employeeBook.findEmployee("Валиев");
        System.out.println();
        //Увеличиваем всем зарплату на 10%
        System.out.println("Увеличиваем всем зарплату на 10%");
        employeeBook.salaryIncrease(10);
        System.out.println();
        //Проверяем
        System.out.println("Проверяем");
        employeeBook.printAllBook();
        System.out.println();
        //Ищем отдел
        System.out.println("Ищем отдел");
        employeeBook.findDepartmentEmployee(3);
        System.out.println();
        //Увеличиваем зарплату отделу на 5%
        System.out.println("Увеличиваем зарплату отделу на 5%");
        employeeBook.salaryIncreaseDepartment(3, 5);
        System.out.println();
        //Проверяем
        System.out.println("Проверяем");
        employeeBook.findDepartmentEmployee(2);
        System.out.println();
        //Зарплата всех сотрудников и средняя зарплата
        System.out.println("Зарплата всех сотрудников и средняя зарплата");
        employeeBook.allSalary();
        System.out.println();
        //Зарплата всех сотрудников отдела и средняя зарплата по отделу
        System.out.println("Зарплата всех сотрудников отдела и средняя зарплата по отделу");
        employeeBook.allSalaryDepartment(2);
        System.out.println();
        //Минимальная зарплата среди всех сотрудников
        System.out.println("Минимальная зарплата среди всех сотрудников");
        employeeBook.minSalary();
        System.out.println();
        //Максимальная зарплата среди всех сотрудников
        System.out.println("Максимальная зарплата среди всех сотрудников");
        employeeBook.maxSalary();
        System.out.println();
        //Минимальная зарплата в отделе
        System.out.println("Минимальная зарплата в отделе");
        employeeBook.minSalaryDepartment(2);
        System.out.println();
        //Максимальная зарплата в отделе
        System.out.println("Максимальная зарплата в отделе");
        employeeBook.maxSalaryDepartment(3);
        System.out.println();
        //Сотрудники с зарплатой меньше чем
        System.out.println("Сотрудники с зарплатой меньше чем");
        employeeBook.lessSalary(60_000);
        System.out.println();
        //Сотрудники с зарплатой больше чем
        System.out.println("Сотрудники с зарплатой больше чем");
        employeeBook.moreSalary(160_000);
        System.out.println();

    }
}