package com.daspeon;

import com.daspeon.application.CurrencyRequest;
import com.daspeon.models.Currency;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        CurrencyRequest currencyRequest = new CurrencyRequest();

        Currency currency;
        Double rate = 0.00;


        System.out.println("""
                   *******************************
                   *     CONVERSOR DE MOEDAS     *
                   *******************************
                   
                    1 - Dólar para Real
                    2 - Euro para Dólar
                    3 - Real para Iene
                    4 - Real para Libra Esterlina
                    5 - Dólar para Iene
                    6 - Real para Peso Argentino
                   
                   ******************************
                   """);

        System.out.print("Digite uma opção: ");
        int option = scanner.nextInt();

        System.out.println();

        switch (option) {
            case 1:
                currency = currencyRequest.getRates("USD");
                rate = currency.convertRate("BRL");

                System.out.printf("U$ 1.00 corresponde a R$ %.2f", rate);
                break;
            case 2:
                currency = currencyRequest.getRates("EUR");
                rate = currency.convertRate("BRL");

                System.out.printf("€1 corresponde a R$ %.2f", rate);
                break;
            case 3:
                currency = currencyRequest.getRates("BRL");
                rate = currency.convertRate("JPY");

                System.out.printf("R$ 1 corresponde a ¥ %.2f", rate);
                break;
            case 4:
                currency = currencyRequest.getRates("BRL");
                rate = currency.convertRate("GBP");

                System.out.printf("R$ 1 corresponde a £ %.2f", rate);
                break;
            case 5:
                currency = currencyRequest.getRates("USD");
                rate = currency.convertRate("JPY");

                System.out.printf("U$ 1 corresponde a ¥ %.2f", rate);
                break;
            case 6:
                currency = currencyRequest.getRates("BRL");
                rate = currency.convertRate("ARS");

                System.out.printf("R$ 1 corresponde a $ %.2f", rate);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        scanner.close();
    }
}