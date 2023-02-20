package help.konstantin;

import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private final Map<Integer, Base> memory = new ConcurrentHashMap<>();
    
    public boolean add(Base model) {
        return memory.putIfAbsent(model.getId(), model) == null;
    }
    
    public static void main(String[] args) {
        Cache cache = new Cache();
        boolean rsl;
        Base model = new Base(1, 1);
        rsl = cache.add(model);
        System.out.println(rsl);
        rsl = cache.add(model);
        System.out.println(rsl);
        
        var list = List.of(new Base(1, 1), new Base(2, 2));
        var arr = list.toArray();
        System.out.println(list.get(0) == arr[0]);
        System.out.println(list.get(1) == arr[1]);
    }
    
    public boolean update(Base model) {
        return memory.computeIfPresent(model.getId(), (__, prevVersionModel) -> {
            if (prevVersionModel.getVersion() != model.getVersion()) {
                throw new OptimisticException("Versions are not equal");
            }
            return new Base(
                    model.getId(),
                    model.getVersion() +1,
                    model.getName()
            );
        }) != null;
    }
    
    public void delete(Base model) {
        if (!memory.isEmpty()) {
            memory.remove(model.getId());
        }
    }
    
    private static class OptimisticException extends RuntimeException {
        public OptimisticException(String versions_are_not_equal) {}
    }
}

@RequiredArgsConstructor
@AllArgsConstructor
@Data class Base {
    private final int id;
    private final int version;
    private String name;
}