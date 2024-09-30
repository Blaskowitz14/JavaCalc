package org.blaskowitz.javacalculator;


import org.blaskowitz.javacalculator.calculator.AppService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        AppService service = new AppService();
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println(service.handleUserInput(input.nextLine()));
        }
    }
}