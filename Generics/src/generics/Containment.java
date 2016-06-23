package generics;
/**
 * Generic interface example
 * @author glen
 *This interface implies that implementing class
 *contains one or more value
 * @param <T> generic value
 */
public interface Containment<T extends Number> {
	boolean contains(T o);
}
