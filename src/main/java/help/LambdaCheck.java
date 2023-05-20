package help;

import lombok.Getter;

import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaCheck {
    String str = "aaa";
    
//    StringCheck fun1 = s -> s.isEmpty();
//    StringCheck fun2 = ""::isEmpty;

//    Predicate<String> fun1 = s -> s.isEmpty();
//    Predicate<String> fun2 = s -> str.isEmpty();
    
    
    Function<String, Boolean> fun1 = String::isEmpty;
    Function<String, Boolean> fun2 = s -> s.isEmpty();
    
//    Function<String, Boolean> fun3 = str::isEmpty;
    Function<String, Boolean> fun4 = s -> str.isEmpty();

//    Function<DTO, String > getter1 = DTO::getName;
//    Supplier<String > getter2 = new DTO()::getName;
    Supplier<String > getter3 = () -> DTO.getStaticValue();
}

@Getter class DTO {
    private String name;
    
    public static String getStaticValue() {
        return "static value";
    }
}

@FunctionalInterface
interface StringCheck {
    
    boolean check(String str);
}
