/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package evaluacionparcialuno;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EvaluacionParcialUno {
    private static Miembro miembro;
    private static final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("============================ \n"
                    + "FitnessPro  \n"
                    + "============================ \n"
                    + "Sistema de Control de Acceso \n"
                    + "============================ \n"
                    + "1. Registrar nuevo miembro \n"
                    + "2. Validar Acceso al Gimnasio \n"
                    + "3. Registrar Entrada \n"
                    + "4. Registrar Salida \n"
                    + "5. Salir \n");

            Short option = null;
            boolean validOption = false;

            // Validar opción del menú
            while (!validOption) {
                try {
                    option = scanner.nextShort();
                    if (option < 1 || option > 5) {
                        System.out.println("Opción inválida. Por favor, ingrese un número entre 1 y 5.");
                    } else {
                        validOption = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número.");
                    scanner.next(); // Limpiar el buffer del scanner
                }
            }

            switch (option) {
                case 1:
                    registrarMiembro(scanner);
                    break;

                case 2:
                    validarAcceso(scanner);
                    break;

                case 3:
                    registrarEntrada(scanner);
                    break;

                case 4:
                    registrarSalida(scanner);
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }

    private static void registrarMiembro(Scanner scanner) {
        System.out.print("================================================ \n");
        System.out.print("Bienvenido al registro de usuarios de FitnessPro \n");
        System.out.print("================================================ \n");
        
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.next();
        
        System.out.print("Ingrese su id: ");
        String id = scanner.next();
        
        miembro = new Miembro(nombre, id);
        
        System.out.println(miembro);
    }

    private static void validarAcceso(Scanner scanner) {
        if (miembro == null) {
            System.out.println("No hay miembros registrados.");
            return;
        }

        System.out.print("Ingrese su id: ");
        String id = scanner.next();

        System.out.print("Ingrese su código de acceso: ");
        String codigoAcceso = scanner.next();

        if (miembro.validaAcceso(id, codigoAcceso)) {
            System.out.println("Acceso válido.");
        } else {
            System.out.println("Acceso inválido.");
        }
    }

    private static void registrarEntrada(Scanner scanner) {
        if (miembro == null) {
            System.out.println("No hay miembros registrados.");
            return;
        }

        miembro.registrarEntrada();
        System.out.println("Entrada registrada: " + miembro.getRegistro());
    }

    private static void registrarSalida(Scanner scanner) {
        if (miembro == null) {
            System.out.println("No hay miembros registrados.");
            return;
        }

        miembro.registrarSalida();
        System.out.println("Salida registrada: " + miembro.getRegistro());
    }
}