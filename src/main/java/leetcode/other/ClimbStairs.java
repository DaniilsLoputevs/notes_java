package leetcode.other;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

@Deprecated
public class ClimbStairs {
    public static void main(String[] args){
        int n0 = 1;
        int n1 = 1;
        int n2;
        System.out.print(n0+" "+n1+" ");
        for(int i = 3; i <= 11; i++){
            n2=n0+n1;
            System.out.print(n2+" ");
            n0=n1;
            n1=n2;
        }
        System.out.println();
//        var temp = new NonCopyArrayList(map.values());
    }
    private class NonCopyArrayList<T> extends AbstractList<T> {
        private final Object[] elements;
    
        private NonCopyArrayList(Collection<T> elements) {this.elements = elements.toArray();}
    
    
        @Override public T get(int index) {
            return (T) this.elements[index];
        }
    
        @Override public void forEach(Consumer<? super T> action) {
            super.forEach(action);
        }
    
        @Override public Spliterator<T> spliterator() {
            return super.spliterator();
        }
    
        @Override public Stream<T> stream() {
            return super.stream();
        }
    
        @Override public Stream<T> parallelStream() {
            return super.parallelStream();
        }
    
        @Override public int size() {
            return elements.length;
        }
    
        @Override public <T1> T1[] toArray(IntFunction<T1[]> generator) {
            return super.toArray(generator);
        }
    
        @Override public boolean removeIf(Predicate<? super T> filter) {
            return super.removeIf(filter);
        }
    
        @Override public void replaceAll(UnaryOperator<T> operator) {
            super.replaceAll(operator);
        }
    
        @Override public void sort(Comparator<? super T> c) {
            super.sort(c);
        }
    }
}
