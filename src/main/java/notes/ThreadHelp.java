package notes;

public class ThreadHelp {

//    public static synchronized void myMethod() {
//        /// ...
//    }
//    public static synchronized void myMethod() {
//        synchronized(ThreadHelp.class) {
//            /// ...
//        }
//    }
    

    public static void main(String[] args) {
//        var cla = ThreadHelp.class;
//        method(cla);
        int a = 1010;
        int b = 1101;
        System.out.println(a & b);
    }
    private static volatile ThreadHelp help;
    
    private static void method(Class<?> other) {
        System.out.println(ThreadHelp.class == other);
        System.out.println(ThreadHelp.class.equals(other));
        synchronized (ThreadHelp.class) {
    
            System.out.println(ThreadHelp.class == other);
            System.out.println(ThreadHelp.class.equals(other));
        }
    }
}
