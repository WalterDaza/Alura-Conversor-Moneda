package controlador;

import com.google.gson.Gson;
import modelo.Moneda;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import io.github.cdimascio.dotenv.Dotenv;

public class MonedaControlador {

    public Moneda buscaMoneda (String codigoMoneda) {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey +"/latest/" + codigoMoneda;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Moneda moneda = new Gson().fromJson(response.body(), Moneda.class);

            if (moneda.getConversion_rates() == null) {
                return null;
            }
            return moneda;
        } catch (Exception e) {
            return null;
        }

    }

}
