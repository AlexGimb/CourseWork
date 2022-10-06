import java.util.Objects;
public class Employee {
    private Person person;
    private int department;
    private double salary;

    private static int numberCreation = 0;
    private final int id;
    public Employee(Person person, int department, double salary) {
        this.person = person;
        this.department = department;
        this.salary = salary;
        this.id = ++numberCreation;
    }
    public int getNumberCreation() {
        return numberCreation;
    }
    public Person getPerson() {
        return person;
    }
    public int getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }
    public int getId() {
        return id;
    }
    public void setDepartment(int department) {
        this.department = department;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(employee.salary, salary) == 0 && id == employee.id && person.equals(employee.person);
    }
    @Override
    public int hashCode() {
        return Objects.hash(person, department, salary, id);
    }
    @Override
    public String toString() {
        return String.format("Отдел №" + department +  ", Ф.И.О.: " + person + ", id сотрудника: " + id + " , зарплата: " + "%.2f",salary);
    }
    String employeeSeal() {
        System.out.println(toString());
        return null;
    }
}
