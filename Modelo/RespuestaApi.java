package Modelo;

import java.util.Map;

public class RespuestaApi {
    private String result;
    private String base_code;
    private Map<String, Double> conversion_rates;

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }
}
