package custom.measuers.metric;


public interface MetricUnit {
     METERS METERS = new METERS();
     DECI_METERS DECI_METERS = new DECI_METERS();
     SANTI_METERS SANTI_METERS = new SANTI_METERS();
     MILLI_METERS MILLI_METERS = new MILLI_METERS();
    
    class METERS implements MetricUnit {}
}
    class DECI_METERS  implements MetricUnit {}
    class SANTI_METERS  implements MetricUnit {}
    class MILLI_METERS implements MetricUnit  {}


