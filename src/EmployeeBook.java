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
            if (employees[i] != null)
                System.out.println(employees[i]);
        }
    }
    public void findEmployee(String surname) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getPerson().getSurname().equals(surname)) {
                System.out.println("Сотрудник найден:");
                System.out.println(employees[i]);
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
                System.out.println(employees[i]);
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
    public boolean salaryIncreaseDepartment(int department, int percent) {
        double sum = 1 + (double) percent / 100;
        double newSolary;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                newSolary = employees[i].getSalary() * sum;
                employees[i].setSalary(newSolary);
                return true;
            }
        }
        System.out.println("Отдел №" + department + " не найден");
        return false;
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
        if (department < 0 || department > 5) {
            System.out.println("Отдел №" + department + " не найден");
            return;
        }
        double sum = 0;
        int amount = 0;
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
        Employee minEmployee = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                minEmployee = employees[i];
            }
        }
        System.out.print("Минимальная зарплата: ");
        System.out.println(minEmployee);
    }

    public void minSalaryDepartment(int department) {
        if (department < 0 || department > 5) {
            System.out.println("Отдел №" + department + " не найден");
            return;
        }
        double min = Integer.MAX_VALUE;
        Employee minSalaryDepartment = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < min && employees[i].getDepartment() == department) {
                min = employees[i].getSalary();
                minSalaryDepartment = employees[i];
            }
        }
        System.out.print("Минимальная зарплата в отделе №" + department + " - ");
        System.out.printf((" id сотрудника: " + minSalaryDepartment.getId() + ", Ф.И.О.: " + minSalaryDepartment.getPerson() + ", зарплата: " + "%.2f" + "\n"), minSalaryDepartment.getSalary());
    }

    public void maxSalary() {
        double max = Integer.MIN_VALUE;
        Employee maxEmployee = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                maxEmployee = employees[i];
            }
        }
        System.out.print("Максимальная зарплата: ");
        System.out.println(maxEmployee);
    }

    public void maxSalaryDepartment(int department) {
        if (department < 0 || department > 5) {
            System.out.println("Отдел №" + department + " не найден");
            return;
        }
        double max = Integer.MIN_VALUE;
        Employee maxSalaryDepartment = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > max && employees[i].getDepartment() == department) {
                max = employees[i].getSalary();
                maxSalaryDepartment = employees[i];
            }
        }
        System.out.print("Максимальная зарплата в отделе №" + department + " - ");
        System.out.printf((" id сотрудника: " + maxSalaryDepartment.getId() + ", Ф.И.О.: " + maxSalaryDepartment.getPerson() + ", зарплата: " + "%.2f" + "\n"), maxSalaryDepartment.getSalary());
    }
    public void lessSalary(int salary) {
        boolean search = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < salary) {
                search = true;
            }
        }
        if (search != true) {
            System.out.println("Сотрудник(и) с зарплатой меньше " + salary + " не найден(ы):");
            return;
        }
        System.out.println("Сотрудник(и) с зарплатой меньше " + salary + " найден(ы):");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < salary) {
                System.out.println(employees[i]);
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
        if (search != true) {
            System.out.println("Сотрудник(и) с зарплатой больше " + salary + " не найден(ы):");
            return;
        }
        System.out.println("Сотрудник(и) с зарплатой больше " + salary + " найден(ы):");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > salary) {
                System.out.println(employees[i]);
            }
        }
    }
    public void findDepartmentEmployee(int department) {
        if (department < 0 || department > 5) {
            System.out.println("Отдел №" + department + " не найден");
            return;
        }
        System.out.println("Отдел №" + department + " найден");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment() == department) {
                System.out.printf(("id сотрудника: " + employees[i].getId() + ", Ф.И.О.: " + employees[i].getPerson() + ", зарплата: " + "%.2f" + "\n"), employees[i].getSalary());
            }
        }
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




