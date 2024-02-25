package custom.measuers.metric

import java.math.BigDecimal

fun main() {
    val convertModule = MetricConvertModuleDefault()
    val o1: Amount<METER> = Amount(BigDecimal(10), METER)
    val o2: Amount<CENTIMETER> = Amount(BigDecimal(55), CENTIMETER)
    convertModule.convert(o1, CENTIMETER).also { println(it) }  // Meters -> Centi
    convertModule.convert(o2, METER).also { println(it) }       // Centi -> Meters
    convertModule.convert(o1, METER).also { println(it) }       // Meters -> Meters


}

data class Amount<T : MetricMeasureUnit>(val value: BigDecimal, val type: T)

interface MetricConvertModule {
    fun <BASE : MetricMeasureUnit, TARGET : MetricMeasureUnit> convert(
        amount: Amount<BASE>,
        target: TARGET
    ): Amount<TARGET>
}




// =========================
/* MeasureMetricType */
// =========================
interface MetricMeasureUnit {
    val multiplierToMNanoMeters: Int

}

object METER : MetricMeasureUnit {
    override val multiplierToMNanoMeters: Int = 1_000_000_000
    override fun toString(): String = "METER"
}

object CENTIMETER : MetricMeasureUnit {
    override val multiplierToMNanoMeters: Int = 10_000_000
    override fun toString(): String = "CENTIMETER"
}