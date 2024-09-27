package com.daspeon.models;

import com.daspeon.dto.CurrencyDTO;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Currency {

    @SerializedName("base_code")
    private String currencyCode;

    @SerializedName("conversion_rates")
    private Map<String, Double> conversionRates;

    public Currency(CurrencyDTO currencyDTO) {
        this.currencyCode = currencyDTO.code();
        this.conversionRates = currencyDTO.conversionRates();
    }

    public Double convertRate(String toCurrency) {
        return conversionRates.get(toCurrency.toUpperCase());
    }

}
