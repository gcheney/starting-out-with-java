package challenges;

public interface adder<T extends Number> {
    T zero(); // Adding zero items
    T add(T lhs, T rhs); // Adding two items
}
