package Lambda;

@FunctionalInterface
public interface CheckTrait {
    boolean test(Animal a);
//    "Это тоже самое что и Predicate"
//    Predicate test(Animal a);
}
