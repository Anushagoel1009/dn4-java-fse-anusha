package task2;
public class FactoryMethodDemo {

    // Product interface
    interface Animal {
        void speak();
    }

    // Concrete Product: Dog
    static class Dog implements Animal {
        public void speak() {
            System.out.println("Woof!");
        }
    }

    // Concrete Product: Cat
    static class Cat implements Animal {
        public void speak() {
            System.out.println("Meow!");
        }
    }

    // Factory class
    static class AnimalFactory {
        public Animal createAnimal(String type) {
            if (type.equalsIgnoreCase("dog")) {
                return new Dog();
            } else if (type.equalsIgnoreCase("cat")) {
                return new Cat();
            } else {
                return null;
            }
        }
    }

    // Main method (Client Code)
    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();

        Animal a1 = factory.createAnimal("dog");
        if (a1 != null) a1.speak();  // Output: Woof!

        Animal a2 = factory.createAnimal("cat");
        if (a2 != null) a2.speak();  // Output: Meow!

        Animal a3 = factory.createAnimal("horse");
        if (a3 != null)
            a3.speak();
        else
            System.out.println("Unknown animal type.");  // Optional error handling
    }
}


