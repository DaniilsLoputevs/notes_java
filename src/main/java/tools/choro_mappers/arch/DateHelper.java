package tools.choro_mappers.arch;

public interface DateHelper {
    
    Object localeDateTime();
    Object calendar();
    
    // todo - later
    Object localeDate();
    Object localeTime();
    Object date();
    Object sqlDate();
    Object sqlTime();
    Object sqlTimestamp();
}
