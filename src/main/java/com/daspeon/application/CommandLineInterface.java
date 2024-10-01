package com.daspeon.application;

import com.daspeon.enums.CurrencySymbol;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CommandLineInterface {

    Scanner scanner = new Scanner(System.in);

    private CurrencyConverter currencyConverter = new CurrencyConverter();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm");

    Double rate = 0.00;

    public void showConvertionOptions() throws IOException, InterruptedException {
        boolean goBackToMainMenu = false;

        while(!goBackToMainMenu) {
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
                    0 - Voltar ao menu inicial
                   
                   ******************************
                   """);

            System.out.print("Digite uma opção: ");
            int option = scanner.nextInt();

            if (option == 0 ) {
                goBackToMainMenu = true;
                return;
            };

            callCurrencyConverter(option);
        }
    }

    private void callCurrencyConverter(int option) throws IOException, InterruptedException {
        switch (option) {
            case 1:
                rate = currencyConverter.convertCurrency("USD", "BRL");
                printConvertion(rate, "USD", "BRL");
                break;
            case 2:
                rate = currencyConverter.convertCurrency("USD", "CLP");
                printConvertion(rate, "USD", "CLP");
                break;
            case 3:
                rate = currencyConverter.convertCurrency("BRL", "CLP");
                printConvertion(rate, "BRL", "CLP");
                break;
            case 4:
                rate = currencyConverter.convertCurrency("BRL", "BOB");
                printConvertion(rate, "BRL", "BOB");
                break;
            case 5:
                rate = currencyConverter.convertCurrency("USD", "COP");
                printConvertion(rate, "USD", "COP");
                break;
            case 6:
                rate = currencyConverter.convertCurrency("BRL", "ARS");
                printConvertion(rate, "BRL", "ARS");
                break;
            default:
                System.out.println("\t\tOpção inválida. Tente novamente!");
                break;
        }
    }

    private void printConvertion(Double rate, String toCurrency, String fromCurrency) {

        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedTime = localDateTime.format(dateTimeFormatter);

        System.out.printf("""
                ------------------------------------------
                - DADOS DA CONVERSÃO - %s -
                ------------------------------------------
                """, formattedTime);

        System.out.printf("\t\t%s 1 corresponde a %s %.2f\n", CurrencySymbol.getCurrencySymbol(toCurrency), CurrencySymbol.getCurrencySymbol(fromCurrency), rate);

        System.out.println("------------------------------------------");
    }

    private void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
