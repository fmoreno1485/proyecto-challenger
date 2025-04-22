package Servicio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import Modelo.RespuestaApi;

public class ApiExchangeRateService {
    private final String API_KEY = "6a1b5c7497862443790cd21d"; // coloca tu key real
    private final HttpClient client;

    public ApiExchangeRateService() {
        this.client = HttpClient.newHttpClient();
    }

    public void convertirMoneda(int opcion, double monto) {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            RespuestaApi datos = gson.fromJson(response.body(), RespuestaApi.class);

            double tasa = 0.0;
            switch (opcion) {
                case 1 -> tasa = datos.getConversionRates().get("EUR");
                case 2 -> tasa = datos.getConversionRates().get("MXN");
                case 3 -> tasa = datos.getConversionRates().get("JPY");
                case 4 -> tasa = datos.getConversionRates().get("PER");
                default -> System.out.println("Opción inválida");
            }

            if (tasa != 0.0) {
                double resultado = monto * tasa;
                System.out.println("Resultado: " + resultado);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
