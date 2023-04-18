//package notes;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Function;
//
//// - Object
//// -- Throwable
//// --- Exception <----------------------
//// ---- IOException
//// ---- IndexOutOfBoundsException
//// --- Error
//// ---- OutOfMemoryError
//// ---- AssertionError
//public class GenericExample1 {
//
//    // assign generic variable
//
//    /** Можно присваивать Базовый/Исходный тип и его Наследники + null */
//    public void assignGenericVariable_default() {
//        List<Exception> list = new ArrayList<>();
//        list.add(null);
//        list.add(new Object());
//        list.add(new Throwable());
//        list.add(new Exception());
//        list.add(new IOException());
//        list.add(new IndexOutOfBoundsException());
//        list.add(new Error());
//        list.add(new OutOfMemoryError());
//        list.add(new AssertionError());
//    }
//    /** Можно присваивать Базовый/Исходный тип и его Наследники + null */
//    public void assignGenericVariable_super() {
//        List<? super Exception> list = new ArrayList<>();
//        list.add(null);
//        list.add(new Object());
//        list.add(new Throwable());
//        list.add(new Exception());
//        list.add(new IOException());
//        list.add(new IndexOutOfBoundsException());
//        list.add(new Error());
//        list.add(new OutOfMemoryError());
//        list.add(new AssertionError());
//    }
//    /** Можно присваивать null */
//    public void assignGenericVariable_extends() {
//        List<? extends Exception> list = new ArrayList<>();
//        list.add(null);
//        list.add(new Object());
//        list.add(new Throwable());
//        list.add(new Exception());
//        list.add(new IOException());
//        list.add(new IndexOutOfBoundsException());
//        list.add(new Error());
//        list.add(new OutOfMemoryError());
//        list.add(new AssertionError());
//    }
//
//
//    // read generic variable
//    /**  */
//    public void readGenericVariable_default() {
//        List<Exception> list = new ArrayList<>();
//        Object obj = list.get(0);
//        Throwable thr = list.get(0);
//        Exception e1 = list.get(0);
//        IOException e2 = list.get(0);
//        IndexOutOfBoundsException e3 = list.get(0);
//        Error e4 = list.get(0);
//        OutOfMemoryError e5 = list.get(0);
//        AssertionError e6 = list.get(0);
//    }
//    /**  */
//    public void readGenericVariable_super() {
//        List<? super Exception> list = new ArrayList<>();
//        Object obj = list.get(0);
//        Throwable thr = list.get(0);
//        Exception e1 = list.get(0);
//        IOException e2 = list.get(0);
//        IndexOutOfBoundsException e3 = list.get(0);
//        Error e4 = list.get(0);
//        OutOfMemoryError e5 = list.get(0);
//        AssertionError e6 = list.get(0);
//    }
//    /**  */
//    public void readGenericVariable_extends() {
//        List<? extends Exception> list = new ArrayList<>();
//        Object obj = list.get(0);
//        Throwable thr = list.get(0);
//        Exception e1 = list.get(0);
//        IOException e2 = list.get(0);
//        IndexOutOfBoundsException e3 = list.get(0);
//        Error e4 = list.get(0);
//        OutOfMemoryError e5 = list.get(0);
//        AssertionError e6 = list.get(0);
//    }
//
//    // assign variable with generic type
//    /**  */
//    public void assignVariableWithGeneric_default() {
//        List<Exception> list0 = new ArrayList<Object>();
//        List<Exception> list1 = new ArrayList<Throwable>();
//        List<Exception> list2 = new ArrayList<Exception>();
//        List<Exception> list3 = new ArrayList<IOException>();
//        List<Exception> list4 = new ArrayList<IndexOutOfBoundsException>();
//        List<Exception> list5 = new ArrayList<Error>();
//        List<Exception> list6 = new ArrayList<OutOfMemoryError>();
//        List<Exception> list7 = new ArrayList<AssertionError>();
//    }
//    /**  */
//    public void assignVariableWithGeneric_super() {
//        List<? super Exception> list0 = new ArrayList<Object>();
//        List<? super Exception> list1 = new ArrayList<Throwable>();
//        List<? super Exception> list2 = new ArrayList<Exception>();
//        List<? super Exception> list3 = new ArrayList<IOException>();
//        List<? super Exception> list4 = new ArrayList<IndexOutOfBoundsException>();
//        List<? super Exception> list5 = new ArrayList<Error>();
//        List<? super Exception> list6 = new ArrayList<OutOfMemoryError>();
//        List<? super Exception> list7 = new ArrayList<AssertionError>();
//    }
//    /**  */
//    public void assignVariableWithGeneric_extends() {
//        List<? extends Exception> list0 = new ArrayList<Object>();
//        List<? extends Exception> list1 = new ArrayList<Throwable>();
//        List<? extends Exception> list2 = new ArrayList<Exception>();
//        List<? extends Exception> list3 = new ArrayList<IOException>();
//        List<? extends Exception> list4 = new ArrayList<IndexOutOfBoundsException>();
//        List<? extends Exception> list5 = new ArrayList<Error>();
//        List<? extends Exception> list6 = new ArrayList<OutOfMemoryError>();
//        List<? extends Exception> list7 = new ArrayList<AssertionError>();
//    }
//
//    public void assignArray() {
//        Exception[] arr1 = new Object[10];
//        Exception[] arr2 = new Throwable[10];
//        Exception[] arr3 = new Exception[10];
//        Exception[] arr4 = new IOException[10];
//        Exception[] arr5 = new IndexOutOfBoundsException[10];
//        Exception[] arr6 = new Error[10];
//        Exception[] arr7 = new OutOfMemoryError[10];
//        Exception[] arr8 = new AssertionError[10];
//    }
//    public static void readArray() {
//        Exception[] arr1 = new Exception[] {new Exception("Exception.ToStringValue")};
//        Object val1_1 = arr1[0];
//        Throwable val1_2 = arr1[0];
//        Exception val1_3 = arr1[0];
//        IOException val1_4 = arr1[0];
//        Error val1_5 = arr1[0];
//        OutOfMemoryError val1_6 = arr1[0];
//        AssertionError val1_7 = arr1[0];
//        Exception[] arr2 = new IOException[] {new IOException("IOException.ToStringValue")};
//        Object val2_1 = arr2[0];
//        Throwable val2_2 = arr2[0];
//        Exception val2_3 = arr2[0];
//        IOException val2_4 = arr2[0];
//        Error val2_5 = arr2[0];
//        OutOfMemoryError val2_6 = arr2[0];
//        AssertionError val2_7 = arr2[0];
//        Exception[] arr3 = new IndexOutOfBoundsException[] {new IndexOutOfBoundsException("IndexOutOfBoundsException.ToStringValue")};
//        Object val3_1 = arr3[0];
//        Throwable val3_2 = arr3[0];
//        Exception val3_3 = arr3[0];
//        IOException val3_4 = arr3[0];
//        Error val3_5 = arr3[0];
//        OutOfMemoryError val3_6 = arr3[0];
//        AssertionError val3_7 = arr3[0];
//    }
//    public static void writeArray() {
//        Exception[] arr = new Exception[10];
////        arr[0] = new Object();
////        arr[0] = new Throwable("Throwable.ToStringValue");
//        arr[0] = new Exception("Exception.ToStringValue");
//        arr[0] = new IOException("IOException.ToStringValue");
//        arr[0] = new IndexOutOfBoundsException("IndexOutOfBoundsException.ToStringValue");
////        arr[0] = new Error();
////        arr[0] = new OutOfMemoryError();
////        arr[0] = new AssertionError();
//    }
//    public static void assignToSuperType_And_mismatchRead_Array() {
//        Exception[] arr = new IOException[] {new IOException("IOException.ToStringValue")};
////        arr[0] = new Object(); // not compile
////        arr[0] = new Throwable("Throwable.ToStringValue"); // not compile
//        arr[0] = new Exception("Exception.ToStringValue"); // Runtime - ArrayStoreException
//        arr[0] = new IOException("IOException.ToStringValue");
//        arr[0] = new IndexOutOfBoundsException("IndexOutOfBoundsException.ToStringValue"); // Runtime - ArrayStoreException
////        arr[0] = new Error(); // not compile
////        arr[0] = new OutOfMemoryError(); // not compile
////        arr[0] = new AssertionError(); // not compile
//
//
//        Throwable[] arr2 = new Exception[]{new Exception("Exception.ToStringValue")};
//        arr2[0] = new Throwable(); // Runtime - ArrayStoreException
//        arr2[0] = new Exception();
//        arr2[0] = new Error(); // Runtime - ArrayStoreException
//    }
//
////    public static void main(String[] args) {
////        readArray();
////        writeArray();
////    }
//
//
//    class Main {
//
//        public static void main(String[] args) {
//            Function<? super Exception, ? super Exception> func = exception -> funcExample(exception);
//        }
//
//        public static Exception funcExample(Exception exception) {
//
//        }
//    }
//}
