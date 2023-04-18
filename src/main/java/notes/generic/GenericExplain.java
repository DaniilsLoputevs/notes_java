//package notes;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class GenericExplain {
//
////    class BoxSuperNumber<? super Number> {
//    class BoxExtendsNumber<T extends Number> {
//
//    }
//    public void fun1() {
////        ArrayList<Object> l1 = new ArrayList<String>(); // compile error - unbound generic - инвариантный
////        ArrayList<String> l1 = new ArrayList<Object>(); // compile error - unbound generic - инвариантный
//        BoxExtendsNumber<?> box1 = new BoxExtendsNumber<Object>()
//        BoxExtendsNumber box2 = new BoxExtendsNumber<Integer>();
//
////        List<? super Integer> foo3 = new ArrayList<String>();  // Integer is a "superclass" of Integer (in this context)
////        List<? super Integer> foo3 = new ArrayList<Number>();   // Number is a superclass of Integer
//        List<? super Integer> foo3 = new ArrayList<Object>();
//        var k = foo3.get(0);
//
//        List<? super String> superString = new ArrayList<Object>();
////        List<? super String> superString = new ArrayList<Object>();
//        superString.add("");// Valid
//        superString.add(new Object()); // Not Valid
//
//
//    }
//    public void exceptionSuper() {
//        List<? super IOException> exceptionsSuper = new ArrayList<>();
//        exceptionsSuper.add(null);
//        exceptionsSuper.add(new Object()); // Invalid
//        exceptionsSuper.add(new Exception()); // Invalid
//        exceptionsSuper.add(new IOException());
//        exceptionsSuper.add(new FileNotFoundException());
//
//        Object obj = exceptionsSuper.get(0);
//        Throwable thr = exceptionsSuper.get(0);
//        Exception e1 = exceptionsSuper.get(0);
//        IOException e2 = exceptionsSuper.get(0);
//        FileNotFoundException e3 = exceptionsSuper.get(0);
//
//        List<? super IOException> exceptions1 = new ArrayList<Exception>();
//        List<? super IOException> exceptions2 = new ArrayList<IOException>();
//        List<? super IOException> exceptions3 = new ArrayList<FileNotFoundException>();
//    }
//    public void exceptionExtends() {
//        List<? extends IOException> exceptionsSuper = new ArrayList<>();
//        exceptionsSuper.add(null);
//        exceptionsSuper.add(new Object()); // Error
//        exceptionsSuper.add(new Throwable()); // Error
//        exceptionsSuper.add(new Exception()); // Error
//        exceptionsSuper.add(new IOException()); // Error
//        exceptionsSuper.add(new FileNotFoundException()); // Error
//
//        Throwable e0 = exceptionsSuper.get(0);
//        Exception e1 = exceptionsSuper.get(0);
//        IOException e2 = exceptionsSuper.get(0);
//        FileNotFoundException e3 = exceptionsSuper.get(0); // Error
//
//        List<? extends IOException> exceptions0 = new ArrayList<Object>(); // Error
//        List<? extends IOException> exceptions1 = new ArrayList<Exception>(); // Error
//        List<? extends IOException> exceptions2 = new ArrayList<IOException>();
//        List<? extends IOException> exceptions3 = new ArrayList<FileNotFoundException>();
//        List<> list = new ArrayList<String>();
//    }
//
//    public <T> void  fun(T t) {
////        var o = Integer.valueOf(1).getClass();
////        Class<Integer> o = Integer.valueOf(1).getClass();
//        Class<? extends Integer > o = Integer.valueOf(1).getClass();
//        List<Number> numbers = new ArrayList<Number>();
//        numbers.add(Double.valueOf(100d));
//
//        Object obj = numbers.get(0);
//        Number one = numbers.get(0);
//        Integer two = numbers.get(0);
//        Double the = numbers.get(0);
//
//        List<? super String> superString = new ArrayList<Object>();
//        List<? super String> superString = new ArrayList<CharSequence>();
//
//        List<?> list1 = new ArrayList<Exception>();
//            list1= new ArrayList<IOException>();
//
//        if (new Object() instanceof T) {
//
//        }
//
//    }
//
//    public static void main(String[] args) {
//
//        RuntimeException s = newList(); // runtime error: ClassCastException
//        System.out.println("111" + s);
//    }
//
//    private static <T extends List<Exception>> T newList() {
//        return (T) new ArrayList<Exception>();
//    }
//}
