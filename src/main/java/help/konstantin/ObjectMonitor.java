package help.konstantin;

import java.util.List;
import java.util.Random;

public class ObjectMonitor {
    private final List<Integer> list;
    
    
    private final Object lock = new Object(); // lock2 lock1
    
    public void upd() {
        synchronized (lock) { // lock1.isLocked = true (Thread 1)
            System.out.println("upd");
        }
        
    }
    
//    public void setLock(Object obj) { // (Thread 2)
//        this.lock = obj;
//    }
    
    public void read() {
        synchronized (lock) {  // lock2.isLocked = true (Thread 3)
            System.out.println("read");
        }
        
    }
    
    public ObjectMonitor(List<Integer> list) {
        this.list = list;
//        Thread.currentThread()
    }
    
    
    public synchronized void add() {
        for (int i = 0; i < 10; i++) {
            int r = new Random().nextInt();
            list.add(r);
            System.out.println(Thread.currentThread().getName() + ":добавляет " + r);
            System.out.println(Thread.currentThread().getState());
            System.out.println(list);
        }
    }
    
    public void delete() {
        synchronized (this) {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + ":удаляет " + list.remove(0));
                System.out.println(Thread.currentThread().getState());
                System.out.println(list);
            }
        }
    }
    
    public void listAct() {
        synchronized (list) { // <-- Thread.currentThread() Захватывает монитора у Объекта list
            for (int i = 0; i < 10; i++) {
                int r = new Random().nextInt();
                list.add(r);
                System.out.println(Thread.currentThread().getName() + ":добавляет по новому " + r);
                System.out.println(Thread.currentThread().getState());
                System.out.println(list);
            }
        } // <-- Thread.currentThread() Отпускает монитора у Объекта list
    }
    
//    public static synchronized void method() {
//        System.out.println(ObjectMonitor.class);
//    }
//    public static void method() {
//        synchronized (ObjectMonitor.class) {
//            System.out.println(ObjectMonitor.class);
//        }
//    }
}
