package leetcode.design;

import java.util.*;

class RandomizedSet {
    public static void main(String[] args) {
        int val = 10;
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(val);
        boolean param_4 = obj.insert(20);
        boolean param_5 = obj.insert(30);
        int param_7 = obj.getRandom();
        boolean param_2 = obj.remove(20);
        boolean param_6 = obj.remove(val);
        int param_3 = obj.getRandom();
        System.out.println("hello");
    }
    
    private final Map<Integer, Integer> keys;
    private final List<Integer> values;
    private final Random random = new Random();
    
    public RandomizedSet() {
        keys = new HashMap<>();
        values = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (keys.containsKey(val)) return false;
        keys.put(val, values.size());
        values.add(val);
        return true;
    }
    
    public boolean remove(int val) { // val = 20
        if (!keys.containsKey(val)) return false;
        int candidateIndex = keys.get(val); // candidateIndex = 1
        int lastIndex = values.size() - 1; // lastIndex = 2
        values.set(candidateIndex, values.get(lastIndex)); // values.set(1, 30)
        keys.put(values.get(candidateIndex), candidateIndex); // keys.put(30, 1)
        keys.remove(val); // keys.remove(20)
        values.remove(lastIndex); // values.remove(2)
        return true;
    }
    
    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}
