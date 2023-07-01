package notes;

import java.util.List;
import java.util.function.Consumer;

public enum EnumDecompile {
    A("a"), B("b"), C("c");
    
    private final String literal;
    
    static {
    
        class InMethodLocal {}
        System.out.println(new InMethodLocal().getClass().getName());
        Consumer<String> lambda = (a) -> {};
        System.out.println(lambda.getClass().getName());
        System.out.println(InClassLocal.class.getName());
        int[] a;
    }
    
    EnumDecompile(String str) {
        literal = str;
    }
    
    class InClassLocal {
    
    }
    
    public static void main(String[] args) {
        List<String>[] a = new List[0];
    }
    
}
