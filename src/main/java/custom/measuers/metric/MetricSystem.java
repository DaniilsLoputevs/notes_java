package custom.measuers.metric;

//import measuers.metric.MetricUnit.*;

/**
 * todo comparator?
 * * math module
 * add()
 * ? addAndConvert()
 * subtract()
 * ? subtractAndConvert()
 * ? range()
 * compare()
 * isMore() // isAfter()
 * isLess() // isBefore()
 * isEqual()
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
 * convert(MeasureUnit<? extends PARENT_GENERIC> target, Class<? extends PARENT_GENERIC>)
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
public class MetricSystem
//        implements MeasureSystem
{
    public static final MetricSystem instance = new MetricSystem();
    
    public <TARGET_METRIC_UNIT extends MetricUnit> MetricAmount<TARGET_METRIC_UNIT> convert(
            MetricAmount<?> amount, TARGET_METRIC_UNIT targetType) {
        return null;
    }
    public <TARGET_METRIC_UNIT extends MetricUnit> MetricAmount<TARGET_METRIC_UNIT> convert(
            MetricAmount<?> amount, Class<TARGET_METRIC_UNIT> targetType) {
        return null;
    }
    
    
}

