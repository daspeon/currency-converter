package com.daspeon.application;

import com.daspeon.dto.CurrencyDTO;
import com.daspeon.models.Currency;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyConverter {

    private String baseURL = "https://v6.exchangerate-api.com/v6/02efdaa27a877cca8389fe73/latest/";


    public double convertCurrency(String fromCurrency, String toCurrency) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseURL + fromCurrency))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        CurrencyDTO currencyDTO = gson.fromJson(response.body(), CurrencyDTO.class);
        Currency currency = new Currency(currencyDTO);

        return currency.convertRate(toCurrency);
    }
}
