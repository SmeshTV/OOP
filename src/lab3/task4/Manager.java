package lab3.task4;

import java.time.LocalDateTime;
import java.util.Vector;

public class Manager extends Employee {

    private Vector<Employee> team;
    private double bonus;

    public Manager(String name, double salary, LocalDateTime hireDate, String insuranceNumber, double bonus) {
        super(name, salary, hireDate, insuranceNumber);
        this.bonus = bonus;
        this.team = new Vector<>();
    }

    public void addEmployee(Employee e) {
        team.add(e);
    }

    public double getBonus() {
        return bonus;
    }

    public Vector<Employee> getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return "Manager{name='" + name +
                "', salary=" + salary +
                ", hireDate=" + hireDate +
                ", insuranceNumber='" + insuranceNumber +
                "', bonus=" + bonus +
                ", teamSize=" + team.size() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof Manager)) return false;

        Manager m = (Manager) o;
        return bonus == m.bonus;
    }

    // If salaries equal → compare by bonus
    @Override
    public int compareTo(Employee other) {
        int res = Double.compare(this.salary, other.salary);

        if (res == 0 && other instanceof Manager) {
            Manager m = (Manager) other;
            return Double.compare(this.bonus, m.bonus);
        }

        return res;
    }

    @Override
    public Manager clone() {
        Manager copy = (Manager) super.clone();
        copy.team = new Vector<>(team); // shallow copy
        return copy;
    }
}