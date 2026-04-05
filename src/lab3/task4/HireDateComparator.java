package lab3.task4;

import java.util.Comparator;

public class HireDateComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        return e2.getHireDate().compareTo(e1.getHireDate());
    }
}