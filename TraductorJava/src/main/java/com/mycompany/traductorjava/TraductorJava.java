package com.mycompany.traductorjava;

import java.util.Scanner;

public class TraductorJava {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introdusca un numero del 0 a 100 ");
        int num1 = scanner.nextInt();
        
        System.out.print("Introdusca un segundo numero del 0 a 100 ");
        int num2 = scanner.nextInt();
        
        if (num1 < 0 || num1 > 100 || num2 < 0 || num2 > 100) {
            System.out.println("Los numeros deben estar entre 0 y 100.");
            return;
        }
        
        int suma = num1 + num2;
        
        String mensajeEspañol = String.format("La suma de %s más %s es %s",
                numTEspañol(num1), numTEspañol(num2), numTEspañol(suma));
        
        String mensajeIngles = String.format("The sum of %s plus %s is %s",
                numTIngles(num1), numTIngles(num2), numTIngles(suma));
        
        System.out.println(mensajeEspañol);
        System.out.println(mensajeIngles);
    }
    
    private static String numTEspañol(int num) {
        if (num < 0 || num > 100) return "Número fuera de rango";
        
        if (num == 100) return "cien";
        
        String[] unidades = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        String[] decenas = {"", "diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};
        
        if (num < 10) return unidades[num];
        if (num < 20) return num == 10 ? "diez" : "dieci" + unidades[num - 10];
        if (num < 30) return num == 20 ? "veinte" : "veinti" + unidades[num - 20];
        if (num < 100) {
            return num % 10 == 0 ? decenas[num / 10] : decenas[num / 10] + " y " + unidades[num % 10];
        }
        return "";
    }
    
    private static String numTIngles(int num) {
        if (num < 0) return "Number out of range";
        
        if (num == 100) return "one hundred";
        
        String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        
        if (num < 10) return ones[num];
        if (num < 20) return teens[num - 10];
        if (num < 100) {
            return num % 10 == 0 ? tens[num / 10] : tens[num / 10] + "-" + ones[num % 10];
        }
        return "";       
    }
}
