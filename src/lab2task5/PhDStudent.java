package lab2task5;

public class PhDStudent extends Person {
    private String researchField;

    public PhDStudent(String name, int age, String researchField) {
        super(name, age);
        this.researchField = researchField;
    }

    @Override
    public String getOccupation() {
        return "PhD Student (research: " + researchField + ")";
    }

    @Override
    public void assignPet(Animal pet) {
        if (pet instanceof Dog) {
            System.out.println("PhD students cannot have dogs — too much responsibility!");
            return;
        }
        super.assignPet(pet);
    }
}