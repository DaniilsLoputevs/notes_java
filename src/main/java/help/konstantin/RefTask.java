package help.konstantin;

public class RefTask {
    int value = 1;
    //getters and setters
    public static void main(String[] args) {
        RefTask rt = new RefTask();
//        RefTask rt2 = rt;
//        rt2.value++;
        change(rt);
        System.out.println(rt.value);
        
    }
    
    public static void change(RefTask rt) {
        rt.value++;
    }
    
    
}