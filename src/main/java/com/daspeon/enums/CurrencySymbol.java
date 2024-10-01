package com.daspeon.enums;

public enum CurrencySymbol {
    BRL("R$"),
    USD("US$"),
    CLP("$"),
    BOB("$b"),
    COP("COL$"),
    ARG("$");

    private String symbol;

    CurrencySymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static String getCurrencySymbol(String currencyCode) {
        return valueOf(currencyCode).getSymbol();
    }
}
