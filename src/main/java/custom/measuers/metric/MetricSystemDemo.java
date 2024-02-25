package custom.measuers.metric;

public class MetricSystemDemo {
    
    public static void main(String[] args) {
        MetricAmount<MetricUnit.METERS> meters = new MetricAmount<>(100, MetricUnit.METERS);
        var o1 = MetricSystem.instance.convert(meters, MetricUnit.MILLI_METERS);
        var o2 = MetricSystem.instance.convert(meters, MetricUnit.METERS.class);
        // todo - kotlin file with MetricUnit interface + implements
    }
}
