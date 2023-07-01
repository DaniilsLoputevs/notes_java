package notes.generic;


import java.util.Arrays;
import java.util.List;

public class GenericArray {
    public static void main(String[] args) {
        List<Parent> list1 = Arrays.asList(new Parent());
        List<Son>  list2 = Arrays.asList(new Son());
        List<Parent>  list3 = Arrays.asList(new Parent(), new Son());
        List<Parent>  list4 = Arrays.asList(new Son(), new Parent());
//        List<Son>  list5 = Arrays.asList(new Son(), new Parent()); // not compile
        
//        var list1 = Arrays.asList(
//                new Parent()
//        );
    }
    static class Parent {}
    static class Son extends Parent {}
}
