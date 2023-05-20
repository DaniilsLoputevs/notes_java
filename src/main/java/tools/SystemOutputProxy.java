package tools;

import java.io.PrintStream;

/** Simple implementation of pattern Decorator. */
public class SystemOutputProxy extends PrintStream {
    private final PrintStream printStream;
    private final StringBuilder sb;
    
    public SystemOutputProxy(PrintStream printStream, StringBuilder sb) {
        super(printStream);
        this.printStream = printStream;
        this.sb = sb;
    }
    
    @Override public void print(Object obj) {
        sb.append(obj);
        printStream.print(obj);
    }
    
    @Override public void print(String x) {
        sb.append(x);
        printStream.println(x);
    }
    
    
    /* override all others overloading of method: print(...) */
    
    
    @Override public void println(Object x) {
        sb.append(x).append(System.lineSeparator());
        printStream.println(x);
    }
    
    @Override public void println(String x) {
        sb.append(x).append(System.lineSeparator());
        printStream.println(x);
    }
    
    
    /* override all others overloading of method: println(...) */
    
    
    @Override public PrintStream printf(String format, Object... args) {
        sb.append(String.format(format, args));
        return printStream.printf(format, args);
    }
    
    
    /* override all others overloading of method: printf(...) */
    
    
    public PrintStream getPrintStream() {
        return printStream;
    }
    
    
    public static void main(String[] args) {
        StringBuilder out = new StringBuilder();
        StringBuilder err = new StringBuilder();
        SystemOutputProxy proxyOut = new SystemOutputProxy(System.out, out);
        SystemOutputProxy proxyErr = new SystemOutputProxy(System.err, err);
        System.setOut(proxyOut);
        System.setErr(proxyErr);
        
        // do your code here...
        System.out.print("aaa");
        System.out.print("bbb");
        System.out.print("ccc");
        
        System.err.print("111");
        System.err.print("222");
        System.err.print("333");
        // finish your code...
        
        // set back original Output is not necessary
        System.setOut(proxyOut.getPrintStream());
        System.setErr(proxyErr.getPrintStream());
        
        boolean isOurContentEquals = out.toString().equals("aaabbbccc");
        boolean isErrContentEquals = err.toString().equals("111222333");
        
        System.out.println("isOurContentEquals = " + isOurContentEquals); // show true
        System.out.println("isErrContentEquals = " + isErrContentEquals); // show true
    }
}
