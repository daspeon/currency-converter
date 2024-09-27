package com.daspeon.dto;

import java.util.Map;

public record CurrencyDTO(String code, Map<String, Double> conversionRates) {
}
