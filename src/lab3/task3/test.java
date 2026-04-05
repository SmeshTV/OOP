package lab3.task3;

public class test {
    public static void main(String[] args) {
        // 1. Create a new collection of Strings
        MyCollection<String> languages = new SimpleCollection<>();

        System.out.println("--- Testing Add & Size ---");
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        System.out.println("Current size: " + languages.size()); // Should be 3

        System.out.println("\n--- Testing Contains ---");
        System.out.println("Contains 'Java'? " + languages.contains("Java"));   // true
        System.out.println("Contains 'Ruby'? " + languages.contains("Ruby"));   // false

        System.out.println("\n--- Testing Remove ---");
        languages.remove("Python");
        System.out.println("Size after removing Python: " + languages.size()); // 2

        System.out.println("\n--- Testing Iterable (For-Each Loop) ---");
        // This works only because our interface extends Iterable!
        for (String lang : languages) {
            System.out.println("Found item: " + lang);
        }

        System.out.println("\n--- Bro copied from Miras ---");
        languages.clear();
        System.out.println("Is collection empty now? " + languages.isEmpty()); // true
    }
}
