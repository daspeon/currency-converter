package com.daspeon;

import com.daspeon.application.CurrencyConverter;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        CurrencyConverter currencyConverter = new CurrencyConverter();

        Double rate = 0.00;

        System.out.println("""
                   *******************************
                   *     CONVERSOR DE MOEDAS     *
                   *******************************
                   
                    1 - Dólar Americano para Real
                    2 - Dólar para Peso Chileno 
                    3 - Real para Peso Chileno
                    4 - Real para Boliviano
                    5 - Dólar para Peso Colombiano
                    6 - Real para Peso Argentino
                   
                   ******************************
                   """);

        System.out.print("Digite uma opção: ");
        int option = scanner.nextInt();

        System.out.println();

        switch (option) {
            case 1:
                rate = currencyConverter.convertCurrency("USD", "BRL");

                System.out.printf("US$ 1 corresponde a R$ %.2f", rate);
                break;
            case 2:
                rate = currencyConverter.convertCurrency("USD", "CLP");

                System.out.printf("US$ 1 corresponde a $ %.2f", rate);
                break;
            case 3:
                rate = currencyConverter.convertCurrency("BRL", "CLP");

                System.out.printf("R$ 1 corresponde a $ %.2f", rate);
                break;
            case 4:
                rate = currencyConverter.convertCurrency("BRL", "BOB");

                System.out.printf("R$ 1 corresponde a $b %.2f", rate);
                break;
            case 5:
                rate = currencyConverter.convertCurrency("USD", "COP");

                System.out.printf("U$ 1 corresponde a $ %.2f", rate);
                break;
            case 6:
                rate = currencyConverter.convertCurrency("BRL", "ARS");

                System.out.printf("R$ 1 corresponde a $ %.2f", rate);
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        scanner.close();
    }
}