package custom.operations;

public interface Operation {
    
    boolean submitSchedule();
    boolean tryNow();
//    boolean reTry();
    boolean reTry(int times, long periodBetweenTriesInMs);
    boolean rollback();
    void cancel();
}
