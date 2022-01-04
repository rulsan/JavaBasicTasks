package SampleOfStreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Animal> animals = getAnimals();

        System.out.println("Old way till Java 8 (Императивный)");
        List<Animal> predators = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getClassification().equals(Classification.PREDATOR)){
                predators.add(animal);
            }
        }
        predators.forEach(System.out::println);

        System.out.println("***************************");
        System.out.println("New approaches since Java 8 (Декларативный)");

        System.out.println("***************************");
        System.out.println("Filter by stream");
        List<Animal> filtered = animals.stream()
                .filter(animal -> animal.getClassification().equals(Classification.PREDATOR))
                .collect(Collectors.toList());
        filtered.forEach(System.out::println);

        System.out.println("***************************");
        System.out.println("Sort by Age then by Classification and reverse by stream");
        List<Animal> sorted = animals.stream()
                .sorted(Comparator.comparing(Animal::getAge)
                        .thenComparing(Animal::getClassification)
                        .reversed())
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);

        System.out.println("***************************");
        System.out.println("All match by stream");
        // Если условие выполняется для всех элементов коллекции то вернется TRUE иначе FALSE
        boolean allMatch = animals.stream()
                .allMatch(animal -> animal.getAge() > 10);
        System.out.println("All the animals are older then 10 yeard - " + allMatch); // false

        System.out.println("***************************");
        System.out.println("Any match by stream");
        // Если условие выполняется хотя бы для одного элемента коллекции то вернется TRUE иначе FALSE
        boolean anyMatch = animals.stream()
                .anyMatch(animal -> animal.getAge() > 10);
        System.out.println("At least one animal is older then 10 yeard - " + anyMatch); // true

        System.out.println("***************************");
        System.out.println("None match by stream");
        // Если нет совпадений то вернется TRUE и наоборот
        boolean noneMatch = animals.stream()
                .noneMatch(animal -> animal.getName().equals("Медведь"));
        System.out.println("There is no 'Медведь' - " + noneMatch); // true
        boolean noneMatch2 = animals.stream()
                .noneMatch(animal -> animal.getName().equals("Слон"));
        System.out.println("There is no 'Слон' - " + noneMatch2);  // false

        System.out.println("***************************");
        System.out.println("Find the max by stream");
        animals.stream()
                .max(Comparator.comparing(Animal::getAge))
                .ifPresent(System.out::println);

        System.out.println("***************************");
        System.out.println("Find the min by stream");
        animals.stream()
                .min(Comparator.comparing(Animal::getAge))
                .ifPresent(System.out::println);

        System.out.println("***************************");
        System.out.println("Group by stream");
        Map<Classification, List<Animal>> classificationListMap = animals.stream()
                .collect(Collectors.groupingBy(Animal::getClassification));

        classificationListMap.forEach((classification, animals1) -> {
            System.out.println(classification);
            animals1.forEach(System.out::println);
            System.out.println();
        });

        System.out.println("***************************");
        // Самый старый хищник
        Optional<String> oldestPredatorAge = animals.stream()
                .filter(animal -> animal.getClassification().equals(Classification.PREDATOR))
                .max(Comparator.comparing(Animal::getAge))
                .map(Animal::getName);

        oldestPredatorAge.ifPresent(System.out::println);

    }

    public static List<Animal>getAnimals(){
        return List.of(
                new Animal("Слон", 20, Classification.HERBIVORE),
                new Animal("Лев", 10, Classification.PREDATOR),
                new Animal("Гиена", 11, Classification.PREDATOR),
                new Animal("Жираф", 7, Classification.HERBIVORE),
                new Animal("Гибон", 35, Classification.OMNIVOROUS),
                new Animal("Лошадь", 36, Classification.HERBIVORE),
                new Animal("Рысь", 2, Classification.PREDATOR),
                new Animal("Динозавр", 200, Classification.PREDATOR)

        );
    }
}
