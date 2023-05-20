package leetcode;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.function.Supplier;

public class Temp2 {
    private static final DTO
            one = new DTO(1, "1"),
            two = new DTO(2, "2"),
            the = new DTO(3, "3"),
            fro = new DTO(4, "4");
    
    @FunctionalInterface
    interface MyThrowSupplier<T> {
        public T get() throws Throwable;
    }
    
    static class Action {
        public String executeThrowError() throws Error {
            throw new Error();
        }
        
        public String executeThrowException() throws Exception {
            throw new Exception();
        }
        
        public String executeThrowRuntime() throws RuntimeException {
            throw new RuntimeException();
        }
        
        public String execute() {
            throw new RuntimeException();
        }
        
        public String mapWithException() throws Exception {
            throw new Exception();
        }
    }
    
    public static <T> T map(MyThrowSupplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Throwable e) {
            throw new RuntimeException();
        }
    }
    
    public static void main(String[] args) {
        var obj = new Action();
//        var list = Stream.of("1", "2")
//                .map(elem -> obj.mapWithException())
//                .collect(Collectors.toList());
        map(obj::mapWithException);
        
        MyThrowSupplier<String> met0 = () -> obj.execute();
        MyThrowSupplier<String> met1 = () -> obj.executeThrowError();
        MyThrowSupplier<String> met2 = () -> obj.executeThrowException();
        MyThrowSupplier<String> met3 = () -> obj.executeThrowRuntime();
        Supplier<String> met4 = () -> obj.execute();
        Supplier<String> met5 = () -> obj.executeThrowError();
//        Supplier<String> met6 = () -> obj.executeThrowException();
        Supplier<String> met7 = () -> obj.executeThrowRuntime();
        System.out.println(met0);
        System.out.println(met1);
        System.out.println(met2);
        System.out.println(met3);
        System.out.println(met4);
        System.out.println(met5);
//        System.out.println(met6);
        System.out.println(met7);
    }
    
    public void main() {
//        DTO dto = new DTO(4, "4");
//        Supplier<String> met1 = dto::toString;
//        Supplier<String> met2 = dto::toString;
////        System.out.println(dto == met1);
//        System.out.println(met1 == met2);
//        Supplier<String> met3 = Temp2::staticToString;
//        Supplier<String> met4 = Temp2::staticToString;
//        System.out.println(met3 == met4);

//        System.out.println(dto.getClass().getName());
//        System.out.println(met1.getClass().getName());
//        System.out.println(met2.getClass().getName());
        
        
        var list = List.of(one, two, the, fro);
//        var arr = list.toArray();
        var arr = new DTO[]{one, two, the, fro};
//        var two = list.subList(0, list.size() -1);
        
        var arr2 = new DTO[4];
        System.arraycopy(arr, 0, arr2, 0, 4);

//        System.out.println(arr[1] == two.get(1));
//        System.out.println(arr[1] == arr2[1]);
//        System.out.println(arr == arr2);
//        System.out.println(arr.equals(arr2));
//        System.out.println(Arrays.equals(arr, arr2));
//        var arr = new DTO[]{};
    }
    
    public static String staticToString() {
        return "toString";
    }
    
    @AllArgsConstructor
    @Data static class DTO {
        private long id;
        private String name;
    }
}
