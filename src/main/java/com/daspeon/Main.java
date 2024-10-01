package com.daspeon;

import com.daspeon.application.CommandLineInterface;
import com.daspeon.application.CurrencyConverter;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        CommandLineInterface commandLineInterface = new CommandLineInterface();

        boolean exit = false;

        while(!exit) {

            System.out.println("""
                   *******************************
                   *     CONVERSOR DE MOEDAS     *
                   *******************************
                   
                    1 - Converter moedas
                    0 - Sair
                   
                   ******************************
                   """);

            System.out.print("Digite uma opção: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    commandLineInterface.showConvertionOptions();
                    break;
                case 0:
                    System.out.printf("Obrigado por usar nosso conversor de moedas");
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente!");
                    break;
            }
        }

        scanner.close();
    }
}