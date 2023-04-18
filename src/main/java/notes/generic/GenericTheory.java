//package notes;
//
//public class GenericTheory {
//    9. How many lines fail to compile?
//
//    class Roller<E extends Wheel> {
//        public void roll(E e) { }
//    } // <--- close Roller
//
//
//    class Wheel {}
//    class CartWheel extends Wheel { }
//
//    Wheel <- CartWheel
//
//    public class RollingContest {
//        Roller<CartWheel> wheel1 = new Roller<CartWheel>();            // OK
//        Roller<Wheel> wheel2 = new Roller<CartWheel>();                // NOT COMPILE
//        Roller<? extends Wheel> wheel3 = new Roller<CartWheel>();      // OK
//        Roller<? extends Wheel> wheel4 = new Roller<Wheel>();          // OK
//        Roller<? super Wheel> wheel5 = new Roller<CartWheel>();        // NOT COMPILE
//        Roller<? super Wheel> wheel6 = new Roller<Wheel>();            // OK
//    }
//
//    A. One
//    B. Two
//    C. Three
//    D. Four
//    E. Five
//    F. Six
//
//
//
//
//
//    class Main {
//        main() {
//            Function<? super Exception, ? super Exception> func = Main::funcExample;
//        }
//
//        public ... funcExample(...) {
//
//        }
//    }
//
//    class Main {
//
//        public static void main(String[] args) {
//            Function<? super Exception, ? extends Exception> func1 = Main::funcExample1;
//
//            Function<? super Exception, ? extends Exception> func2 = Main::funcExample2;
//            Function<? super Exception, ? extends Exception> func2 = Main::funcExample3;
//
//            Function<? super Exception, ? extends Exception> func2 = Main::funcExample4;
//            Function<? super Exception, ? extends Exception> func2 = Main::funcExample5;
//
//            Function<? super Exception, ? extends Exception> func2 = Main::funcExample6;
//            Function<? super Exception, ? extends Exception> func2 = Main::funcExample7;
//        }
//
//        public static Exception funcExample1(Exception exception) {}
//
//        public static IOException funcExample2(Exception exception) {}
//        public static FileNotFoundException funcExample3(Exception exception) {}
//
//        public static Exception funcExample4(IOException exception) {}
//        public static Exception funcExample5(FileNotFoundException exception) {}
//
//        public static IOException funcExample6(IOException exception) {}
//        public static FileNotFoundException funcExample7(FileNotFoundException exception) {}
//    }
//
//
//
//    public class TestGeneric {
//
//
//        // 1 - wildcard - это к
//        public static void main(String[] args) {
//
//            List<? super B> listSuperB = new ArrayList<B>(); //+
//            // listSuperB.add(new A());
//            listSuperB.add(new B()); //+
//            listSuperB.add(new C()); //+
//            System.out.println(listSuperB.get(0)); // class B  ru.edu.common.generics.B@7cc355be    toHexStrign(87698768976987676)
//            System.out.println(listSuperB.get(1)); // class C
//            // System.out.println(listSuperB.get(2));
//            testSuper(listSuperB);
//
//            // List<? super B> listSuperB = new ArrayList<C>()
//            testSuper(new ArrayList<A>());
//            testSuper(new ArrayList<B>());
//            // test(new ArrayList<C>());
//
//
//            // List<? super C> listSuperC = new ArrayList<? super C>();
//            List<? super C> listSuperC = new ArrayList<>();
//            // listSuperC.add(new B());
//
//
//            // testExtends(new ArrayList<A>());
//            testExtends(new ArrayList<B>());
//            testExtends(new ArrayList<C>());
//        }
//
//        static void testSuper(List<? super B> listSuperB) {
//        }
//
//        static void testExtends(List<? extends B> listSuperB) {
//        }
//
//
//    }
//
//    // C extends B exnteds A
//    class A {
//    }
//
//    class B extends A {
//    }
//
//    class C extends B {
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//|             | init collection   | get/read(safe cast) | put/write(avoid mismatch assign) |
//            |-------------|-------------------|---------------------|----------------------------------|
//            | T           | this(only)        | this & super type   | this & sub type                  |
//            | ? super T   | this & super type | Object(only)        | this & sub type                  |
//            | ? extends T | this & sub type   | this & super type   | null(only)                       |
//
//// Array - ArrayStoreException
//// Collection - MismatchAssign
//// null - можно писать ВСЕГДА
//// Object - можно читать ВСЕГДА
//
//    Запрещение чтения (extends) они уворачиваются от рантайм класс каст экпешн.
//    Запрещение записи (super) они уворачиваются от ArrayStoreException в время компиляции (от эррора добавления разных типов в объект с одним конкретным типом)
//
//
//// - Object
//// -- Throwable
//// --- Exception <----------------------
//// ---- IOException
//// ----- FileNotFoundException
//// ----  IndexOutOfBoundsException
//// --- Error
//// ---- OutOfMemoryError
//// ---- AssertionError
//
//    // todo -         доказательство
//    List<? extends Exception> list2 = new ArrayList<Exception>();//+
//    List<? extends Exception> list3 = new ArrayList<IOException>();//+
//    List<? extends Exception> list4 = new ArrayList<IndexOutOfBoundsException>();//+
//
//    P - producer
//    E - extends
//    C - consumer
//    S - super
//
//    Запрещение чтения (extends) они уворачиваются от рантайм класс каст экпешн.
//    Запрещение записи (super) они уворачиваются от ArrayStoreException в время компиляции (от эррора добавления разных типов в объект с одним конкретным типом)
//
//    // ===========================================================================================
//// про UPPER BOUND WILDCARD (? extends Exception)
//// по ссылки созданной с UPW мы может присвоить (передать) объект с типом джненерика ТАКИМ ЖЕ и НИЖЕ в иерархии
//// ДОБАВИТЬ в объект мы может добавить только null
//// потому что ТЕОРЕТИЧЕСКИ можно было бы разрешить добавление САМОГО НИЖНЕГО класса в иерархии
//// НО в будующем МОЖЕТ появиться наследние и этого САМОГО НИЖНЕГО класса
//// и тогда при наличии возможности такого добавления (и проверки корректности на этапе компилляции) рухнет старый код
//// (нарушится принцип обратной совместимости)
//    public void readGenericVariable_extends() {
//        // прочитать сможем только в Excetion и его супертипы, потому что только в эти типы
//        // мы сможем записать все возможные варианты типов объектов (Exception и ниже)
//        List<? extends Exception> list = new ArrayList<>();
//        Object obj = list.get(0); //+
//        Throwable thr = list.get(0);//+
//        Exception e1 = list.get(0);//+
//        IOException e2 = list.get(0);//-
//        IndexOutOfBoundsException e3 = list.get(0);//-
//        Error e4 = list.get(0);//-
//        OutOfMemoryError e5 = list.get(0);//-
//        AssertionError e6 = list.get(0);//-
//    }
//    public void assignGenericVariable_extends() {
//        IOException var = new Exception()
//        List<? extends Exception> list = new ArrayList<IOException>();
//        // TYPE ARGUMENT
//        list.add(null);//+														// Exc     IOExc       FileNotFoundException    <-Наследник
//        list.add(new Object());                       // -        -             -
//        list.add(new Throwable());                    // -        -             -
//        list.add(new Exception());                    // +        -             -
//        list.add(new IOException());                  // +        +             -
//        list.add(new FileNotFoundException());        // +        +             +                        -
//        list.add(new IndexOutOfBoundsException());    // +        -             -
//        list.add(new Error());
//        list.add(new OutOfMemoryError());
//        list.add(new AssertionError());
//    }
//    public void assignVariableWithGeneric_extends() {
//        List<? extends Exception> list0 = new ArrayList<Object>();
//        List<? extends Exception> list1 = new ArrayList<Throwable>();
//        List<? extends Exception> list2 = new ArrayList<Exception>();//+
//        List<? extends Exception> list3 = new ArrayList<IOException>();//+
//        List<? extends Exception> list3 = new ArrayList<FileNotFoundException>();//+
//        List<? extends Exception> list4 = new ArrayList<IndexOutOfBoundsException>();//+
//        List<? extends Exception> list5 = new ArrayList<Error>();
//        List<? extends Exception> list6 = new ArrayList<OutOfMemoryError>();
//        List<? extends Exception> list7 = new ArrayList<AssertionError>();
//    }
//// ===============================================
//// про LOWER BOUND WILDCARD (? super X)
//// в объекты по ссылке LOWER BOUND WILDCARD (? super X) мы может присваивать объеты в типом дженерика таким же и его СУПЕРТИПА
//// при работе с самим объектом (по ссылке созданной с LBW) мы может получать значения ТОЛЬКО в Object
//// потому что теоретически по этой ссылке может находится объект с любым типом дженерика ОТ указанного (и вверх) ДО Object
//// в том числе С ТИПОМ НИЖЕ типа ссылки, куда мы может попытаться присвоить получаемый из объект элемент
//// (мы тончо не знаем какой тип объекта будет будет в рантайме)
//// следовательно ЕДИНСТВЕННОЕ ГАРАНТИРОВАННОЕ (получение и последующее) присвоение может быть в ссылку типа Object
//
//    public void readGenericVariable_super() {
//        List<? super Exception> list = new ArrayList<>();
//        Object obj = list.get(0);//+
//        Throwable thr = list.get(0);
//        Exception e1 = list.get(0);
//        IOException e2 = list.get(0);
//        IndexOutOfBoundsException e3 = list.get(0);
//        Error e4 = list.get(0);
//        OutOfMemoryError e5 = list.get(0);
//        AssertionError e6 = list.get(0);
//    }
//
//    public void assignGenericVariable_super() {
//        List<? super Exception> list = new ArrayList<>();
//        list.add(null);//+
//        // list.add(new Object());
//        // list.add(new Throwable());
//        list.add(new Exception());//+
//        list.add(new IOException());//+
//        list.add(new IndexOutOfBoundsException());//+
//        // list.add(new Error());
//        // list.add(new OutOfMemoryError());
//        // list.add(new AssertionError());
//        Object || Throwable || Exception var = new Throwable()
//    }
//
//    public void assignVariableWithGeneric_super() {
//        List<? super Exception> list0 = new ArrayList<Object>();//+
//        List<? super Exception> list1 = new ArrayList<Throwable>();//+
//        List<? super Exception> list2 = new ArrayList<Exception>();//++
//        List<? super Exception> list3 = new ArrayList<IOException>();
//        List<? super Exception> list4 = new ArrayList<IndexOutOfBoundsException>();
//        List<? super Exception> list5 = new ArrayList<Error>();
//        List<? super Exception> list6 = new ArrayList<OutOfMemoryError>();
//        List<? super Exception> list7 = new ArrayList<AssertionError>();
//    }
//// ===============================================
//// ОСОБЕННОСТИ РАБОТЫ UNBOUNDED WILDCARD (?) И обычного дженерика
//// при использовании ? и T java позволяет добавлять в объект объекты такого же типа и ПОДТИПА
//// но при чтении java позволит прочитать значения из этого объект В ОБЪЕКТ такого же типа и СУПЕРТИПА
//// таким образом обеспечивается безопастность при работе с таким объектом
//// если просто: кладем такого же типа и ниже, достаем В такой же тип или выше
//
//    public void readGenericVariable_default() {
//        Exception exception = new Exception();
//        Object obj = exception;
//
//        List<Exception> list = new ArrayList<>();
//        Object obj = list.get(0);//+
//        Throwable thr = list.get(0);//+
//        Exception e1 = list.get(0);//+
//        IOException e2 = list.get(0);
//        IndexOutOfBoundsException e3 = list.get(0);
//        Error e4 = list.get(0);
//        OutOfMemoryError e5 = list.get(0);
//        AssertionError e6 = list.get(0);
//    }
//
//    public void assignGenericVariable_default(Exception[] arr) {
//        List<Exception> list = new ArrayList<>(); //+
//        list.add(null); // +
//        list.add(new Object());
//        list.add(new Throwable());
//        list.add(new Exception());//+
//        list.add(new IOException()); //+
//        list.add(new IndexOutOfBoundsException()); //+
//        list.add(new Error());
//        list.add(new OutOfMemoryError());
//        list.add(new AssertionError());
//    }
//
//    public void assignVariableWithGeneric_default() {
//        List<Exception> list0 = new ArrayList<Object>(); // -
//        List<Exception> list1 = new ArrayList<Throwable>();  // -
//        List<Exception> list2 = new ArrayList<Exception>();  // +
//        List<Exception> list3 = new ArrayList<IOException>();  // -
//        List<Exception> list4 = new ArrayList<IndexOutOfBoundsException>();  // -
//        List<Exception> list5 = new ArrayList<Error>();  // -
//        List<Exception> list6 = new ArrayList<OutOfMemoryError>();  // -
//        List<Exception> list7 = new ArrayList<AssertionError>();  // -
//    }
//}
