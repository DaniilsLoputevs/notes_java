//package notes.generic;
//
//import java.io.IOException;
//import java.util.function.Predicate;
//import java.util.stream.Stream;
//
//// - Object
//// -- Throwable
//// --- Exception <----------------------
//// ---- IOException
//// ---- IndexOutOfBoundsException
//// --- Error
//// ---- OutOfMemoryError
//// ---- AssertionError
//public class GenericStreamExplain {
//    private static Stream<Exception> defaultStream = Stream.of(new IOException());
//    private static Stream<? super Exception> superStream;
//    private static Stream<? extends Exception> extendsStream;
//
//    private void filter() {
//        defaultStream.filter(GenericStreamExplain::thrFilter);
//        defaultStream.filter(GenericStreamExplain::excFilter);
//        defaultStream.filter(GenericStreamExplain::ioFilter);
//
//        superStream.filter(GenericStreamExplain::thrFilter);
//        superStream.filter(GenericStreamExplain::excFilter);
//        superStream.filter(GenericStreamExplain::ioFilter);
//
////        extendsStream.filter(GenericStreamExplain::thrFilter);
////        extendsStream.filter(GenericStreamExplain::excFilter);
////        extendsStream.filter(GenericStreamExplain::ioFilter);
//    }
//
//    private static boolean thrFilter(Throwable e) {
//        return true;
//    }
//    private static boolean excFilter(Exception e) {
//        return true;
//    }
//    private static boolean ioFilter(IOException e) {
//        return true;
//    }
//
//    private static <T> boolean filterImpl(Predicate<? super T> predicate) {
//        predicate.test(/* capture of ? super T t */ null); // Что мы можем Безопасно положить сюда?
//    }
//    private static boolean filterImpl_Exception(Predicate<? super Exception> predicate) {
//        predicate.test(/* capture of ? super T t */ null); // Что мы можем Безопасно положить сюда?
//        predicate.test(new Throwable());
//        predicate.test(new Exception());
//        predicate.test(new IOException());
//        predicate.test(new IndexOutOfBoundsException());
//    }
//
//
//    class StreamImplFilter<T extends Exception> {
//        public void filterDefault(Predicate<Exception> predicate) {
//            predicate.test(new Throwable());
//            predicate.test(new Exception());
//            predicate.test(new IOException());
//            predicate.test(new IndexOutOfBoundsException());
//        }
//        public void filterSuper(Predicate<? super Exception> predicate) {
//            predicate.test(new Throwable());
//            predicate.test(new Exception());
//            predicate.test(new IOException());
//            predicate.test(new IndexOutOfBoundsException());
//        }
//        public void filterExtends(Predicate<? extends Exception> predicate) {
//            predicate.test(new Throwable());
//            predicate.test(new Exception());
//            predicate.test(new IOException());
//            predicate.test(new IndexOutOfBoundsException());
//        }
//        private void test() {
//            new StreamImplFilter<Exception>().filterDefault(GenericStreamExplain::thrFilter);
//            new StreamImplFilter<Exception>().filterDefault(GenericStreamExplain::excFilter);
//            new StreamImplFilter<Exception>().filterDefault(GenericStreamExplain::ioFilter);
//
//            new StreamImplFilter<Exception>().filterSuper(GenericStreamExplain::thrFilter);
//            new StreamImplFilter<Exception>().filterSuper(GenericStreamExplain::excFilter);
//            new StreamImplFilter<Exception>().filterSuper(GenericStreamExplain::ioFilter);
//
//            new StreamImplFilter<Exception>().filterExtends(GenericStreamExplain::thrFilter);
//            new StreamImplFilter<Exception>().filterExtends(GenericStreamExplain::excFilter);
//            new StreamImplFilter<Exception>().filterExtends(GenericStreamExplain::ioFilter);
//        }
//    }
//
//}
