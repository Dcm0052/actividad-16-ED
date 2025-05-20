package Practica_13_2;

import java.util.Scanner;


public class Manejo_excepciones {

	

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int opcion = 0;

	        do {
	            System.out.println("\n===== CALCULADORA SEGURA =====");
	            System.out.println("1. Sumar");
	            System.out.println("2. Restar");
	            System.out.println("3. Multiplicar");
	            System.out.println("4. Dividir");
	            System.out.println("5. Salir");
	            System.out.print("Elige una opción: ");

	            try {
	                opcion = Integer.parseInt(scanner.nextLine());

	                if (opcion < 1 || opcion > 5) {
	                    throw new IllegalArgumentException("[ERROR] La opción elegida no es válida. Elige del 1 al 5.");
	                }

	                if (opcion == 5) {
	                    System.out.println("Saliendo de la calculadora...");
	                    break;
	                }

	                double validarRango;
	               
	                System.out.print("Introduce el primer número: ");
	                double num1 = Double.parseDouble(scanner.nextLine());
	                validarRango(num1);

	                System.out.print("Introduce el segundo número: ");
	                double num2 = Double.parseDouble(scanner.nextLine());
	                validarRango(num2);

	                double resultado = 0;

	                switch (opcion) {
	                    case 1:
	                        resultado = sumar(num1, num2);
	                        break;
	                    case 2:
	                        resultado = restar(num1, num2);
	                        break;
	                    case 3:
	                        resultado = multiplicar(num1, num2);
	                        break;
	                    case 4:
	                        resultado = dividir(num1, num2);
	                        break;
	                }

	                System.out.println("Resultado: " + resultado);

	            } catch (NumberFormatException e) {
	                System.out.println("[ERROR] Entrada no válida. Por favor, introduce un número válido.");
	            } catch (ValorFueraDeRangoException e) {
	                System.out.println("[ERROR] " + e.getMessage());
	            } catch (ArithmeticException e) {
	                System.out.println("[ERROR] División por cero no permitida.");
	            } catch (IllegalArgumentException e) {
	                System.out.println(e.getMessage());
	            } finally {
	                System.out.println("[INFO] Operación finalizada.");
	            }

	        } while (true);

	        scanner.close();
	    }

	    
	    public class ValorFueraDeRangoException extends Exception {
	        public ValorFueraDeRangoException(String mensaje) {
	            super(mensaje);
	        }
	    }

	    // Validación del rango permitido
	    public static void validarRango(double valor) throws ValorFueraDeRangoException {
	        if (valor < -1000 || valor > 1000) {
	            // throw new ValorFueraDeRangoException("El valor debe estar entre -1000 y 1000.");
	        }
	    }

	    // Métodos de operaciones
	    public static double sumar(double a, double b) {
	        return a + b;
	    }

	    public static double restar(double a, double b) {
	        return a - b;
	    }

	    public static double multiplicar(double a, double b) {
	        return a * b;
	    }

	    public static double dividir(double a, double b) {
	        if (b == 0) throw new ArithmeticException("División por cero");
	        return a / b;
	    }
	}


