package custom.measuers.metric

import java.math.BigDecimal
import java.math.MathContext

class MetricConvertModuleDefault : MetricConvertModule {
    @Suppress("UNCHECKED_CAST")
    override fun <BASE : MetricMeasureUnit, TARGET : MetricMeasureUnit> convert(
        amount: Amount<BASE>,
        target: TARGET
    ): Amount<TARGET> {
        if (amount.type == target) return amount  as Amount<TARGET> // we know that we do
        val baseAsNano = amount.value.multiply(BigDecimal(amount.type.multiplierToMNanoMeters))
        val baseAsTargetValue = baseAsNano.divide(BigDecimal(target.multiplierToMNanoMeters), MathContext.UNLIMITED)
        return Amount(baseAsTargetValue, target)
    }
}