package custom.measuers.metric

/**
 * todo comparator?
 * * math module
 * add()
 * subtract()
 * ? addAndConvert()
 * ? subtractAndConvert()
 * compare()
 * isMore() // isAfter()
 * isLess() // isBefore()
 * isEqual()
 * isMoreOrEqual() // isAfterOrEqual()
 * isLessOrEqual() // isBeforeOrEqual()
 *
 * * factory module
 * of(String, formatter)
 * of(amount, type)
 *
 * * serialize | format | visitor module
 * serialize() :
 * deserialize()
 *
 * * convert module - the heart
 * convert(MeasureUnit target, Class)
 *
 * * extend DTO methods
 * ? copy()
 * * * get part of data
 * * set & getDecimalValue()
 * * set & getIntegerValue()
 * * getDecimalSize()
 * * getIntegerSize()
 * * set & getSign() // isPositive() & isNegative()
 * * set & getStringSize()
 *
 * * properties
 * getId(): String
 * get each module // ? set ?
 */
class MetricSystem {
    lateinit var convertModule: MetricConvertModule


    fun <BASE_METRIC_UNIT : MetricMeasureUnit, TARGET_METRIC_UNIT : MetricMeasureUnit> convert(
        amount: Amount<BASE_METRIC_UNIT>,
        targetType: TARGET_METRIC_UNIT
    ): Amount<TARGET_METRIC_UNIT> {
        return convertModule.convert(amount, targetType)
    }

//    fun <TARGET_METRIC_UNIT : MetricMeasureUnit> convert(
//        amount: MetricAmount<*>?, targetType: Class<TARGET_METRIC_UNIT>?
//    ): MetricAmount<TARGET_METRIC_UNIT>? {
//        return null
//    }

    companion object {
        val instance = MetricSystem()
    }
}