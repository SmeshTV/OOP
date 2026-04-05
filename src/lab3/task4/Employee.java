package lab3.task4;

import java.time.LocalDateTime;

public class Employee extends Person implements Comparable<Employee>, Cloneable {

    protected double salary;
    protected LocalDateTime hireDate;
    protected String insuranceNumber;

    public Employee() {}

    public Employee(String name, double salary, LocalDateTime hireDate, String insuranceNumber) {
        super(name);
        this.salary = salary;
        this.hireDate = hireDate;
        this.insuranceNumber = insuranceNumber;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary +
                ", hireDate=" + hireDate +
                ", insuranceNumber='" + insuranceNumber + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof Employee)) return false;

        Employee e = (Employee) o;

        return salary == e.salary &&
                hireDate.equals(e.hireDate) &&
                insuranceNumber.equals(e.insuranceNumber);
    }

    // Sort by salary (ascending)
    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary, other.salary);
    }

    // Clone (safe because LocalDateTime is immutable)
    @Override
    public Employee clone() {
        try {
            return (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}