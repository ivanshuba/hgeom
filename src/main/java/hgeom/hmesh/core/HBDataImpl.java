package hgeom.hmesh.core;

import hgeom.hmesh.data.HBData;
import java.util.BitSet;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

/**
 * @param <E>
 * @author Pierre B.
 */
final class HBDataImpl<E> extends HDataBaseImpl<E> implements HBData<E> {

  /**
   *
   */
  private final BitSet values = new BitSet();

  /**
   * @param toIndex
   * @param elementStreamSupplier
   */
  public HBDataImpl(ToIntFunction<E> toIndex,
                    Supplier<Stream<E>> elementStreamSupplier) {

    super(toIndex, elementStreamSupplier);
  }

  @Override
  public boolean get(E e) {
    return values.get(index(e));
  }

  @Override
  public void set(E e, boolean v) {
    values.set(index(e), v);
  }

  @Override
  public void clear() {
    values.clear();
  }

  @Override
  public void setAll(Predicate<E> generator) {
    elementStream().forEach(v -> set(v, generator.test(v)));
  }

  @Override
  public Stream<Boolean> stream() {
    return super.elementStream().map(this::get);
  }
}
