package custom.measuers;

/**
 * TODO - конвертация всех во всех?
 *          как расширять новыми тепами вне своей либы?
 * TODO - serialize ← →
 * inner context
 * LinkedUnits
 */

/**
 * TODO - immutable (как примитив)
 * TODO - ? constant pool (как примитив/String)
 */
//interface MeasureUnit {} // DTO Pair<Amount, Type>
interface MeasureType {}
interface MeasureAmount {}
/**
 * in fact know how to all correct execute all operations
 */
interface MeasureSystem {}

interface MeasureSystem_SerializeModule {}
interface MeasureSystem_ConvertModule {}



public class MeasureSystemDemo {
}




//// Impl measuers.MeasureSystem
//class MetricSystem {
//
//}





//public interface MetricUnit {
//
//    public static void main(String[] args) {
//        var units = new Amount<METERS>(1);
//    }
//
//    class Amount<U extends MetricUnit> {
//        BigDecimal amountValue = new BigDecimal(0);
//
//        public Amount(Number amountValue) {
//            this.amountValue = BigDecimal.valueOf(amountValue.doubleValue());
//        }
//
//        public <U_O extends MetricUnit> Amount<U> add(Amount<U_O> amount) {
//            return null;
//        }
//    }
//
//    public static class METERS implements MetricUnit {}
//    public static class DECI_METERS  implements MetricUnit {}
//    public static class SANTI_METERS  implements MetricUnit {}
//    public static class MILLI_METERS implements MetricUnit  {}
//}