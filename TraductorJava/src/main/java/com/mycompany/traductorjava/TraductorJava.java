package com.mycompany.traductorjava;

import java.util.Scanner;
import java.util.HashMap;

public class TraductorJava {

    private static final HashMap<Integer, String> numerosEspañol = new HashMap<>();
    private static final HashMap<Integer, String> numerosIngles = new HashMap<>();
    
    public static void main(String[] args) {
        inicializarMapas();
        
        Scanner scanner = new Scanner(System.in);
        

        System.out.print("Introduce el primer número del 0 a 100: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Introduce el segundo número del 0 a 100: ");
        int num2 = scanner.nextInt();
        
        if (num1 < 0 || num1 > 100 || num2 < 0 || num2 > 100) {
            System.out.println("Los números deben estar entre 0 y 100.");
            return;
        }
        
        int suma = num1 + num2;
        
        String mensajeEspañol = String.format("La suma de %s más %s es %s",
                numerosEspañol.getOrDefault(num1, "Número fuera de rango"),
                numerosEspañol.getOrDefault(num2, "Número fuera de rango"),
                numerosEspañol.getOrDefault(suma, "Número fuera de rango"));
        
        String mensajeIngles = String.format("The sum of %s plus %s is %s",
                numerosIngles.getOrDefault(num1, "Number out of range"),
                numerosIngles.getOrDefault(num2, "Number out of range"),
                numerosIngles.getOrDefault(suma, "Number out of range"));

        System.out.println(mensajeEspañol);
        System.out.println(mensajeIngles);
    }
    
    private static void inicializarMapas() {
        String[] unidadesEspañol = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        String[] decenasEspañol = {"diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
        
        for (int i = 0; i < 10; i++) {
            numerosEspañol.put(i, unidadesEspañol[i]);
        }
        for (int i = 10; i < 20; i++) {
            if (i < 20) {
                numerosEspañol.put(i, i == 10 ? "diez" : "dieci" + unidadesEspañol[i - 10]);
            } else {
                numerosEspañol.put(i, "veinti" + unidadesEspañol[i - 20]);
            }
        }
        for (int i = 20; i < 100; i++) {
            numerosEspañol.put(i, (i % 10 == 0 ? decenasEspañol[i / 10 - 1] : decenasEspañol[i / 10 - 1] + " y " + unidadesEspañol[i % 10]));
        }
        numerosEspañol.put(100, "cien");
        
        String[] onesIngles = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] teensIngles = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tensIngles = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        
        for (int i = 0; i < 10; i++) {
            numerosIngles.put(i, onesIngles[i]);
        }
        for (int i = 10; i < 20; i++) {
            numerosIngles.put(i, teensIngles[i - 10]);
        }
        for (int i = 20; i < 100; i++) {
            numerosIngles.put(i, (i % 10 == 0 ? tensIngles[i / 10] : tensIngles[i / 10] + "-" + onesIngles[i % 10]));
        }
        numerosIngles.put(100, "one hundred");
        for (int i = 101; i <= 199; i++) {
            String suffixEspañol = numerosEspañol.get(i % 100);
            String prefixEspañol = i / 100 == 1 ? "ciento" : "doscientos"; 
            numerosEspañol.put(i, prefixEspañol + (suffixEspañol.equals("cero") ? "" : " " + suffixEspañol));

            String suffixIngles = numerosIngles.get(i % 100);
            String prefixIngles = i / 100 == 1 ? "one hundred" : "two hundred";
            numerosIngles.put(i, prefixIngles + (suffixIngles.equals("zero") ? "" : " " + suffixIngles));
        }
        numerosIngles.put(200, "two hundred");
    }

}
