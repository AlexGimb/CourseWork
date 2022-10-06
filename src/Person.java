import java.util.Objects;
public class Person {
    private String surname;
    private String name;
    private String lastName;
    public Person (String surname, String name, String lastName) {
        this.surname = surname;
        this.name = name;
        this.lastName = lastName;
    }
    public String getSurname() {
        return surname;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return surname.equals(person.surname) && name.equals(person.name) && lastName.equals(person.lastName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(surname, name, lastName);
    }
    @Override
    public String toString() {
        return surname + " " + name + " " + lastName;
    }
}
