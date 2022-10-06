import java.util.Arrays;
public class EmployeeBook {
    private final Employee[] employees;
    public EmployeeBook(int employeesSize) {
        this.employees = new Employee[employeesSize];
    }
    public void addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                break;
            }
        }
    }
    public void removeEmployee(String surname) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getPerson().getSurname().equals(surname)) {
                System.out.println("Сотрудник: " + employees[i].getPerson() + " - удален!");
                System.arraycopy(employees, i + 1, employees, i, employees.length - i - 1);
                employees[employees.length - 1] = null;
                return;
            }
        }
    }
    public void printAllBook() {
        for (int i = 0; i < employees.length; i++) {
            int minIndex = i;
            for (int j = i; j < employees.length; j++) {
                if (employees[j] != null && employees[j].getDepartment() < employees[minIndex].getDepartment()) {
                    minIndex = j;
                }
            }
            Employee temp = employees[i];
            employees[i] = employees[minIndex];
            employees[minIndex] = temp;
        }
        for (int i = 0; i < employees.length - 1; i++) {
            if (employees[i] != null) {
                employees[i].employeeSeal();
            }
        }
    }
    public void findEmployee(String surname) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getPerson().getSurname().equals(surname)) {
                System.out.println("Сотрудник найден:");
                employees[i].employeeSeal();
                return;
            }
        }
        System.out.println("Сотрудник не найден");
    }
    public void changeEmployee(String surname, int department, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getPerson().getSurname().equals(surname)) {
                employees[i].setDepartment(department);
                employees[i].setSalary(salary);
                System.out.println("Сотрудник найден, изменения внесены:");
                employees[i].employeeSeal();
                return;
            }
        }
        System.out.println("Сотрудник не найден");
    }
    public void salaryIncrease(int percent) {
        double sum = 1 + (double) percent / 100;
        double newSolary;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                newSolary = employees[i].getSalary() * sum;
                employees[i].setSalary(newSolary);
            }
        }
    }
    public void salaryIncreaseDepartment(int department, int percent) {
        double sum = 1 + (double) percent / 100;
        double newSolary;
        boolean search = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                search = true;
            }
        }
        if (search != true) {
            System.out.println("Отдел №" + department + " не найден");
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                newSolary = employees[i].getSalary() * sum;
                employees[i].setSalary(newSolary);
            }
        }
    }
    public void allSalary() {
        double sum = 0;
        int amount = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                amount++;
                sum += employees[i].getSalary();
            }
        }
        System.out.printf("Зарплата всех сотрудников составила: %.2f\n", sum);
        System.out.printf("Средняя зарплата за месяц: %.2f\n", sum / amount);
    }
    public void allSalaryDepartment(int department) {
        boolean search = false;
        double sum = 0;
        int amount = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                search = true;
            }
        }
        if (search != true) {
            System.out.println("Отдел №" + department + " не найден");
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                amount++;
                sum += employees[i].getSalary();
            }
        }
        System.out.printf("Зарплата всех сотрудников отдела №%d: %.2f\n", department, sum);
        System.out.printf("Средняя зарплата отдела №%d: %.2f\n", department, sum / amount);
    }
    public void minSalary() {
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < min) {
                min = employees[i].getSalary();

            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i] != null && employees[i].getSalary() == min) {
                System.out.print("Минимальная зарплата: ");
                employees[i].employeeSeal();

            }
        }
    }
    public void minSalaryDepartment(int department) {
        boolean search = false;
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < min && employees[i].getDepartment() == department) {
                min = employees[i].getSalary();
                search = true;
            }
        }
        if (search != true) {
            System.out.println("Отдел №" + department + " не найден");
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i] != null && employees[i].getSalary() == min && employees[i].getDepartment() == department) {
                System.out.print("Минимальная зарплата в отделе №" + department + " - ");
                System.out.printf((" id сотрудника: " + employees[i].getId() + ", Ф.И.О.: " + employees[i].getPerson() + ", зарплата: " + "%.2f" + "\n"), employees[i].getSalary());
            }
        }
    }
    public void maxSalary() {
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > max) {
                max = employees[i].getSalary();
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() == max) {
                System.out.print("Максимальная зарплата: ");
                employees[i].employeeSeal();
            }
        }
    }
    public void maxSalaryDepartment(int department) {
        double max = Integer.MIN_VALUE;
        boolean search = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > max && employees[i].getDepartment() == department) {
                max = employees[i].getSalary();
                search = true;
            }
        }
        if (search != true) {
            System.out.println("Отдел №" + department + " не найден");
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() == max && employees[i].getDepartment() == department) {
                System.out.print("Максимальная зарплата в отделе №" + department + " - ");
                System.out.printf((" id сотрудника: " + employees[i].getId() + ", Ф.И.О.: " + employees[i].getPerson() + ", зарплата: " +  "%.2f" + "\n"), employees[i].getSalary());
            }
        }
    }
    public void lessSalary(int salary) {
        boolean search = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < salary) {
                search = true;
            }
        }
        if (search == true) {
            System.out.println("Сотрудник(и) с зарплатой меньше " + salary + " найден(ы):");
        } else {
            System.out.println("Сотрудник(и) с зарплатой меньше " + salary + "не найден(ы):");
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < salary) {
                employees[i].employeeSeal();
            }
        }
    }
    public void moreSalary(int salary) {
        boolean search = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > salary) {
                search = true;
            }
        }
        if (search == true) {
            System.out.println("Сотрудник(и) с зарплатой больше " + salary + " найден(ы):");
        } else {
            System.out.println("Сотрудник(и) с зарплатой больше " + salary + " не найден(ы):");
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > salary) {
                employees[i].employeeSeal();
            }
        }
    }
    public String findDepartmentEmployee(int department) {
        boolean search = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                search = true;
            }
        }
        if (search == true) {
            System.out.println("Отдел №" + department + " найден");
        } else {
            System.out.println("Отдел №" + department + " не найден");
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                System.out.printf(("id сотрудника: " + employees[i].getId() + ", Ф.И.О.: " + employees[i].getPerson() + ", зарплата: " + "%.2f" + "\n"), employees[i].getSalary());
            }
        }
        return null;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return Arrays.equals(employees, that.employees);
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(employees);
    }
    @Override
    public String toString() {
        return "EmployeeBook{" +
                "employees=" + Arrays.toString(employees) +
                '}';
    }
}




