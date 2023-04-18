package tools;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tools.AlignSide.LEFT;
import static tools.AlignSide.RIGHT;
import static tools.Colour.*;
import static tools.DefaultFormatterBuilder.*;


/**
 * TODO : сделать цвет по возможности - проблема line size + formatter ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * TODO : PrintTable.ofStream() && .append() && print() as Terminal operations ^^^^^^^^^^^^^^^^^^^^^
 * TODO : .columnRowCount(String name, String pattern) ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * TODO : append to table name: element count (do it automatically) ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * TODO : formatting for Numbers ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * TODO : formatting for DateTime ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * TODO : formatting for collections - show only size of ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * TODO : output to (Appendable || String || Consumer<String>) ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * TODO : columnOptions.alignSide ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * TODO : columnOptions ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * TODO : more documentation ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * TODO : buildEachLine (append Iterable || Stream) ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * TODO : count row for insert to SB into start with TableName ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * TODO : compile on Java9 (java8 with replace var -> actual variable type) ^^^^^^^^^^^^^^^^^^^^^^^^
 */
public class PrintTableTest {
    private static final String LS = System.lineSeparator();
    private static final Task
            ONE = new Task(10, "aaa", TaskPriority.LOW, LocalDateTime.MIN, 111.14, null, new String[]{"v1"}),
            TWO = new Task(20, "bbb", TaskPriority.MIDDLE, LocalDateTime.parse("2023-04-18T16:46:49.912727800", DateTimeFormatter.ISO_LOCAL_DATE_TIME), 1720.50, null, new String[]{"v2"}),
            THREE = new Task(30, "ccc", TaskPriority.HIGH, LocalDateTime.MAX, 2496.98, null, new String[]{"v1", "v2"});
    
    public static final List<Task> TASKS = List.of(
            ONE, TWO, THREE,
            new Task(40, "ddd", TaskPriority.LOW, null, 2000.50, List.of(ONE, TWO, THREE), null)
    );
    
    
    @Test
    void print_autoFit_name_elemIndex() {
        var oldSysOut = System.out;
        var myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        
        PrintTable.of(TASKS).name("Test data")
                .columnElemIndex()
                .column("ID", Task::id)
                .column("NAME", Task::name)
                .column("PRIORITY", Task::priority)
                .column("DEADLINE", Task::deadline)
                .column("PRICE", Task::price)
                .column("RELATED", Task::relatedTask)
                .column("TAGS", Task::tags)
                .print();
        var expected = """
                Test data (table size: 4)
                +-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
                | # | ID | NAME | PRIORITY | DEADLINE                            | PRICE   | RELATED                                                                                                                                                                                                                                                                                     | TAGS     |
                +-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
                | 0 | 10 | aaa  | LOW      | -999999999-01-01T00:00              | 111.14  | null                                                                                                                                                                                                                                                                                        | [v1]     |
                | 1 | 20 | bbb  | MIDDLE   | 2023-04-18T16:46:49.912727800       | 1720.5  | null                                                                                                                                                                                                                                                                                        | [v2]     |
                | 2 | 30 | ccc  | HIGH     | +999999999-12-31T23:59:59.999999999 | 2496.98 | null                                                                                                                                                                                                                                                                                        | [v1, v2] |
                | 3 | 40 | ddd  | LOW      | null                                | 2000.5  | [Task[id=10, name='aaa', priority=LOW, deadline=-999999999-01-01T00:00, price=111.14], Task[id=20, name='bbb', priority=MIDDLE, deadline=2023-04-18T16:46:49.912727800, price=1720.5], Task[id=30, name='ccc', priority=HIGH, deadline=+999999999-12-31T23:59:59.999999999, price=2496.98]] | null     |
                +-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
                \n""".replace("\n", LS);
        System.setOut(oldSysOut);
        assertEquals(expected, myOut.toString());
    }
    
    @Test
    void toAppender_noName_noElemIndex_align_minWidth() {
        var rsl = new StringBuilder();
        PrintTable.of(TASKS)
                .column("ID", Task::id)
                .column("NAME", Task::name)
                .column("PRIORITY", Task::priority)
                .column("DEADLINE", Task::deadline, null, op -> op.align(LEFT).minWidth(40))
                .column("PRICE", Task::price)
                .column("RELATED", Task::relatedTask, null, op -> op.align(RIGHT))
                .column("TAGS", Task::tags)
                .toAppendable(rsl);
        var expected = """
                
                +-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
                | ID | NAME | PRIORITY | DEADLINE                                 | PRICE   |                                                                                                                                                                                                                                                                                    RELATED | TAGS     |
                +-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
                | 10 | aaa  | LOW      | -999999999-01-01T00:00                   | 111.14  |                                                                                                                                                                                                                                                                                       null | [v1]     |
                | 20 | bbb  | MIDDLE   | 2023-04-18T16:46:49.912727800            | 1720.5  |                                                                                                                                                                                                                                                                                       null | [v2]     |
                | 30 | ccc  | HIGH     | +999999999-12-31T23:59:59.999999999      | 2496.98 |                                                                                                                                                                                                                                                                                       null | [v1, v2] |
                | 40 | ddd  | LOW      | null                                     | 2000.5  | [Task[id=10, name='aaa', priority=LOW, deadline=-999999999-01-01T00:00, price=111.14], Task[id=20, name='bbb', priority=MIDDLE, deadline=2023-04-18T16:46:49.912727800, price=1720.5], Task[id=30, name='ccc', priority=HIGH, deadline=+999999999-12-31T23:59:59.999999999, price=2496.98]] | null     |
                +-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+
                """.replace("\n", "\r\n");
        assertEquals(expected, rsl.toString());
    }
    
    /**
     * @implNote test have specific, output contains invisible chars.
     * In console, you should see OK table, but in expected value we must include this symbols and so, it's brake pretty view in test case.<br>
     * Normal view present below + colourised some cell value
     *
     * <pre>
     * +--------------------------------------------------------------------------------------------------------------------------------------------------------------+
     * | ID | NAME | DEADLINE(Default)         | DEADLINE(Date)   | DEADLINE(Time) | PRICE     | PRICE(Money) | RELATED    | RELATED(Count) | TAGS                    |
     * +--------------------------------------------------------------------------------------------------------------------------------------------------------------+
     * | 20 | bbb  | 2023-04-18 16:46:49       | 2023-04-18       | 16:46          | 1720,5000 | 1720,50      | ()         | 0              | ****secret is hided**** |
     * | 30 | ccc  | +999999999-12-31 23:59:59 | +999999999-12-31 | 23:59          | 2496,9800 | 2496,98      | ()         | 0              | ****secret is hided**** |
     * | 40 | ddd  | null                      | null             | null           | 2000,5000 | 2000,50      | (10,20,30) | 3              | ****secret is hided**** |
     * +--------------------------------------------------------------------------------------------------------------------------------------------------------------+
     * </pre>
     */
    @Test
    void toAppender_ofAppendDataLater_colours_formatters() {
        var rsl = new StringBuilder();
        var priceColours = List.of(
                new CellColour<Task>(RED, task -> task.price >= 2000),
                new CellColour<Task>(GREEN, task -> task.price <= 2000)
        );
        Function<Collection<Task>, String> relatedTasksJoiningId =
                it -> Optional.ofNullable(it).orElse(Collections.emptyList()).stream()
                        .map(Task::id).map(String::valueOf).collect(Collectors.joining(",", "(", ")"));
        
        var table = PrintTable.<Task>ofAppendDataLater()
                .column("ID", Task::id)
                .column("NAME", Task::name, null, op -> op.cellColours(YELLOW, task -> task.relatedTask == null))
                .column("DEADLINE(Default)", Task::deadline, localDateTime())
                .column("DEADLINE(Date)", Task::deadline, localDateTime("yyyy-MM-dd"))
                .column("DEADLINE(Time)", Task::deadline, localDateTime("HH:mm"))
                .column("PRICE", Task::price, decimal(), op -> op.cellColours(priceColours))
                .column("PRICE(Money)", Task::price, decimal("####.00"))
                .column("RELATED", Task::relatedTask, relatedTasksJoiningId)
                .column("RELATED(Count)", Task::relatedTask, iterableSize())
                .column("TAGS", Task::tags, tags -> "****secret is hided****");
        TASKS.stream().filter(it -> it.id > 10).forEach(table::append);
        table.toAppendable(rsl);
        table.print();
        
        
        var expected = """
                
                +--------------------------------------------------------------------------------------------------------------------------------------------------------------+
                | ID | NAME | DEADLINE(Default)         | DEADLINE(Date)   | DEADLINE(Time) | PRICE     | PRICE(Money) | RELATED    | RELATED(Count) | TAGS                    |
                +--------------------------------------------------------------------------------------------------------------------------------------------------------------+
                | 20 | [33mbbb[0m  | 2023-04-18 16:46:49       | 2023-04-18       | 16:46          | [32m1720,5000[0m | 1720,50      | ()         | 0              | ****secret is hided**** |
                | 30 | [33mccc[0m  | +999999999-12-31 23:59:59 | +999999999-12-31 | 23:59          | [31m2496,9800[0m | 2496,98      | ()         | 0              | ****secret is hided**** |
                | 40 | ddd  | null                      | null             | null           | [31m2000,5000[0m | 2000,50      | (10,20,30) | 3              | ****secret is hided**** |
                +--------------------------------------------------------------------------------------------------------------------------------------------------------------+
                """.replace("\n", "\r\n");
        assertEquals(expected, rsl.toString());
    }
    
    @Test
    void mixOf_of_and_ofAppendDataLater() {
        var rsl = new StringBuilder();
        var table = PrintTable.<Task>of(Collections.emptyList())
                .name("Test data")
                .columnElemIndex()
                .column("ID", Task::id)
                .column("NAME", Task::name);
        TASKS.stream().filter(it -> it.id >= 30).forEach(table::append);
        table.toAppendable(rsl);
        
        var expected = """
                Test data (table size: 2)
                +---------------+
                | # | ID | NAME |
                +---------------+
                | 0 | 30 | ccc  |
                | 1 | 40 | ddd  |
                +---------------+
                """.replace("\n", "\r\n");
        assertEquals(expected, rsl.toString());
    }
    
    
    private record Task(long id, String name, TaskPriority priority, LocalDateTime deadline, double price,
                        Collection<Task> relatedTask, String[] tags) {
        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Task task = (Task) o;
            return id == task.id;
        }
        
        @Override public int hashCode() {
            return Objects.hash(id);
        }
        
        @Override public String toString() {
            return new StringJoiner(", ", Task.class.getSimpleName() + "[", "]")
                    .add("id=" + id)
                    .add("name='" + name + "'")
                    .add("priority=" + priority)
                    .add("deadline=" + deadline)
                    .add("price=" + price)
                    .toString();
        }
    }
    
    private enum TaskPriority {LOW, MIDDLE, HIGH}
}

