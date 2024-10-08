package com.daspeon.application;

import com.daspeon.enums.CurrencySymbol;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CommandLineInterface {

    Scanner scanner = new Scanner(System.in);

    private final CurrencyConverter currencyConverter = new CurrencyConverter();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy, HH:mm");

    Double rate = 0.00;

    public void showConvertionOptions() throws IOException, InterruptedException {
        String[] currencyCodes = {"BRL", "USD", "CLP", "BOB", "COP", "ARS"};

            System.out.println("""
                   *******************************
                   *     MOEDAS DISPONÍVEIS      *
                   *******************************
                    1. Real Brasileiro - BRL
                    2. Dólar Americano - USD
                    3. Peso Chileno - CLP
                    4. Boliviano - BOB
                    5. Peso Colombiano - COP
                    6. Peso Argentino - ARS
                   ******************************
                   """);

            int fromCurrencyIndex = isValidOption("Digite a opção que será usada como moeda base: ");
            int toCurrencyIndex = isValidOption("Digite a opção da moeda para qual deseja converter: ");

            String fromCurrency = currencyCodes[fromCurrencyIndex - 1];
            String toCurrency = currencyCodes[toCurrencyIndex - 1];
            rate = currencyConverter.convertCurrency(fromCurrency, toCurrency);
            printConvertion(rate, fromCurrency, toCurrency);

    }

    private void printConvertion(Double rate, String toCurrency, String fromCurrency) {

        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedTime = localDateTime.format(dateTimeFormatter);

        System.out.printf("""
                ------------------------------------------
                - DADOS DA CONVERSÃO - %s -
                ------------------------------------------
                \t%s 1 corresponde a %s %.2f
                ------------------------------------------
                """, formattedTime, CurrencySymbol.getCurrencySymbol(toCurrency), CurrencySymbol.getCurrencySymbol(fromCurrency), rate);

        pressAnyKey();
    }

    private Integer isValidOption(String message) {
        while (true) {
            System.out.print(message);
            int option = scanner.nextInt();

            if (option >= 1 && option <= 6) {
                return option;
            }

            System.out.println("Opção inválida. Tente novamente!");

        }
    }


    private void pressAnyKey() {
        System.out.print("\nPressione qualquer tecla para continuar...");
        scanner.nextLine();
        scanner.nextLine();

        System.out.println(" ");
    }

    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
