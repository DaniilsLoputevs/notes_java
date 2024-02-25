package custom.streams;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Stage<E> extends Iterable<E> {
    
    static <E> Stage<E> of(E... elements) {
        return new SourceArrayStage<>(elements);
    }
    static <E> Stage<E> of(Iterable<E> elements) {
        return new SourceIterableStage<>(elements);
    }
    
    Stage<E> filter(Predicate<? super E> predicate);
    
    Stage<E> sort(Comparator<? super E> comparator);
    
    <R> Stage<R> map(Function<? super E,? extends R> mapper);
    
    List<E> toList();
    
    
    abstract class AbstractStage<IN_E, RET_E> implements Stage<RET_E> {
        protected Supplier<Iterator<IN_E>> prevIteratorSupplier;
        
        protected AbstractStage() {}
        
        protected AbstractStage(Supplier<Iterator< IN_E>> prevIteratorSupplier) {
            this.prevIteratorSupplier = prevIteratorSupplier;
        }
        
        @Override public Stage<RET_E> filter(Predicate<? super RET_E> predicate) {
            return new FilterStage<>(this::iterator, predicate);
        }
        
        @Override public Stage<RET_E> sort(Comparator<? super RET_E> comparator) {
            return new SortStage<>(this::iterator, comparator);
        }
        
        @Override public <R> Stage<R> map(Function<? super RET_E,? extends R> mapper) {
            return new MapStage<>(this::iterator, mapper);
        }
        
        @Override public List<RET_E> toList() {
            var list = new ArrayList<RET_E>();
            this.iterator().forEachRemaining(list::add);
            return list;
        }
    }
    
    final class SourceArrayStage<E> extends AbstractStage<E, E> {
        public final E[] elements;
        
        public SourceArrayStage(E[] elements) {
            super();
            super.prevIteratorSupplier = this::iterator;
            this.elements = elements;
        }
        
        @NotNull @Override public Iterator<E> iterator() {
            return new Iterator<E>() {
                private int pos = 0;
                
                public boolean hasNext() {
                    return elements.length > pos;
                }
                
                public E next() {
                    return elements[pos++];
                }
                
            };
        }
    }
    final class SourceIterableStage<E> extends AbstractStage<E, E> {
    
        public SourceIterableStage(Iterable<E> iterable) {
            super();
            super.prevIteratorSupplier = iterable::iterator;
        }
        @NotNull @Override public Iterator<E> iterator() {
            return super.prevIteratorSupplier.get();
        }
    }
    
    final class FilterStage<E> extends AbstractStage<E, E> {
        private final Predicate<? super E> filterPredicate;
        
        public FilterStage(Supplier<Iterator<E>> prevIteratorSupplier, Predicate<? super E> filterPredicate) {
            super(prevIteratorSupplier);
            this.filterPredicate = filterPredicate;
        }
        
        @NotNull @Override public Iterator<E> iterator() {
            
            return new Iterator<E>() {
                private final Iterator<E> parentIterator = prevIteratorSupplier.get();
                private E currentElem = findCurrElem();
                
                @Override public boolean hasNext() {
                    return currentElem != null;
                }
                
                @Override public E next() {
                    E rsl = currentElem;
                    this.currentElem = findCurrElem();
                    return rsl;
                }
                
                private E findCurrElem() {
                    while (parentIterator.hasNext()) {
                        E elem = parentIterator.next();
                        if (filterPredicate.test(elem)) {
                            return elem;
                        }
                    }
                    return null;
                }
                
            };
        }
    }


    final class SortStage<E> extends AbstractStage<E, E> {
        private final Comparator<? super E> sortComparator;
    
        public SortStage(Supplier<Iterator<E>> prevIteratorSupplier,Comparator<? super E> sortComparator) {
            super(prevIteratorSupplier);
            this.sortComparator = sortComparator;
        }
    
        @NotNull @Override public Iterator<E> iterator() {
            List<E> list = new LinkedList<>();
            prevIteratorSupplier.get().forEachRemaining(list::add);
            list.sort(sortComparator);
            return list.iterator();
        }
    }
    
    final class MapStage<IN_E, RET_E> extends AbstractStage<IN_E, RET_E> {
        private final Function<? super IN_E,? extends RET_E> mapper;
    
        public MapStage(Supplier<Iterator<IN_E>> prevIteratorSupplier,Function<? super IN_E,? extends RET_E> mapper) {
            super(prevIteratorSupplier);
            this.mapper = mapper;
        }
    
        @NotNull @Override public Iterator<RET_E> iterator() {
            return new Iterator<RET_E>() {
                private final Iterator<IN_E> prevIterator = prevIteratorSupplier.get();
                
                @Override public boolean hasNext() {
                    return prevIterator.hasNext();
                }
    
                @Override public RET_E next() {
                    return mapper.apply(prevIterator.next());
                }
            };
        }
    }


}
