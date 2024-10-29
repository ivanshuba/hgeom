package hgeom.hmesh.data;

import java.util.function.BinaryOperator;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

/**
 * A container storing a collection of pairs of {@code (key, value)} in which
 * the value is a integer
 *
 * @param <E> type of the key
 * @author Pierre B.
 */
public interface HIData<E> {

  /**
   * Returns the value associated with the specified key in a
   * {@code (key, value)} pair stored in this container
   *
   * @param e the key whose associated value is seeked
   * @return the integer value associated with the specified key
   */
  int get(E e);

  /**
   * Associates the specified key with the specified integer value in a
   * {@code (key, value)} pair stored in this container
   *
   * @param e the key
   * @param v the value
   */
  void set(E e, int v);

  /**
   * Sets to {@code 0} the value in all the {@code (key, value)} pairs stored
   * in this container
   */
  void clear();

  /**
   * Uses the specified function to set the value according to the key in each
   * {@code (key, value)} pairs stored in this container
   *
   * @param generator
   */
  void setAll(ToIntFunction<E> generator);

  /**
   * @return a stream on the values of all the {@code (key, value)} pairs
   * stored in this container
   */
  IntStream stream();

  /**
   * Returns a {@link BinaryOperator} which returns the lesser of two keys
   * according to the comparaison of their associated values in the
   * {@code (key, value)} pairs stored in this container
   *
   * @return
   */
  BinaryOperator<E> minOperator();

  /**
   * Returns a {@link BinaryOperator} which returns the greater of two keys
   * according to the comparaison of their associated values in the
   * {@code (key, value)} pairs stored in this container
   *
   * @return
   */
  BinaryOperator<E> maxOperator();
}
