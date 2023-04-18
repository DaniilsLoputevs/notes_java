package notes;

import java.util.List;
import java.util.function.Supplier;

public class Help {
    
    // первая лямбда - код аналог для Ленивой загрузки
    // вторая лямбда - реальная лямбда
    private static final LazyInitContainer<Supplier<String>> main_supplierString_1 = new LazyInitContainer<>(() -> () -> "abc");
    private static final LazyInitContainer<Supplier<String>> main_supplierString_2 = new LazyInitContainer<>(() -> () -> "abc");
    private static final LazyInitContainer<Supplier<String>> main_supplierString_3 = new LazyInitContainer<>(() -> () -> "abc");
    
    private static Supplier<String> funcG;
    
    public static void main(String[] args) {
        doWork();
        doWork();
        doWork();
    }
    public static void doWork() {
        Supplier<String> sup1 = () -> "abc";
        System.out.println(sup1.hashCode());
        System.out.println(sup1 == funcG);
        Supplier<String> sup2 = () -> "abc";
        System.out.println(sup2.hashCode());
        funcG = sup2;
        System.out.println(sup2 == funcG);
        Supplier<String> sup3 = () -> "abc";
        System.out.println(sup3.hashCode());
        System.out.println(sup3 == funcG);
    }

//    public static void main(String[] args) {
//        Supplier<String> sup1 = main_supplierString_1.get();
//        System.out.println(sup1.hashCode());
//        System.out.println(sup1 == funcG);
//
//        Supplier<String> sup2 = main_supplierString_2.get();
//        System.out.println(sup2.hashCode());
//        funcG = sup2;
//        System.out.println(sup2 == funcG);
//
//        Supplier<String> sup3 = main_supplierString_3.get();
//        System.out.println(sup3.hashCode());
//        System.out.println(sup3 == funcG);
//    }
    
    static class LazyInitContainer<T> {
        private T t;
        private final Supplier<T> initT;
        
        public LazyInitContainer(Supplier<T> initT) {
            this.initT = initT;
        }
        
        public T get() {return (t == null) ? (t = initT.get()) : t;}
    }
    
    
    private static String stay = "stay";

//    public static void main(String[] args) {
//        var container = new MyContainer();
//        sout(container);
//        stay = "now";
//        sout(container);
////        "".lines()
//    }
    
    
//    private static Supplier<String> funcG;
    
    public static void sout(MyContainer container) {
//        Supplier<String> func = () -> "abc" + container.toString();
        Supplier<String> func = () -> "abc" + stay;
        System.out.println(func.hashCode());
        System.out.println(funcG == func);
        funcG = func;
        System.out.println(func.get());
    }
    
    static class MyContainer {
        private String str;
        
        @Override public String toString() {
            return str;
        }
    }
    
    
    // Does compile?
    class Mammal {
        public List<CharSequence> play() {
            return null;
        }
        
        public CharSequence sleep() {
            return null;
        }
    }
    
    class Goat extends Mammal {
//        public List<String> play() {
//            return null;
//        }
//        public List<List<Stirng>> play() {
//            return null;
//        }
        
        public String sleep() {
            return null;
        }
    }
}
