package tools;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class MathUtil {
    public static final BigDecimal HUNDRED = new BigDecimal(100);
    public static BigDecimal plusPercent(BigDecimal dig, BigDecimal percent) {
        return getPercent(dig, percent).add(dig).setScale(7, RoundingMode.HALF_UP);
    }

    public static BigDecimal minusPercent(BigDecimal dig, BigDecimal percent) {
        return dig.subtract(getPercent(dig, percent)).setScale(7, RoundingMode.HALF_UP);
    }

    /** getPercent(200, 10) >>> 20 */
    public static BigDecimal getPercent(BigDecimal base, BigDecimal percent) {
        return base.divide(HUNDRED, 7, RoundingMode.HALF_UP).multiply(percent);
    }

    /** Is {@param dig} lower {@param compareWith} */
    public static boolean lw(BigDecimal dig, BigDecimal compareWith) {
        return dig.compareTo(compareWith) < 0;
    }

    /** Is {@param dig} greater {@param compareWith} */
    public static boolean gt(BigDecimal dig, BigDecimal compareWith) {
        return dig.compareTo(compareWith) > 0;
    }

    /** Is {@param dig} equals {@param compareWith} */
    public static boolean eq(BigDecimal dig, BigDecimal compareWith) {
        return dig.compareTo(compareWith) == 0;
    }
}
