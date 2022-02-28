package proyecto;

import java.util.Scanner;

/*Consigna Trabajo Practico para entregar en git:
1. Juego del TaTeTi (X ficha 1 y O ficha 2)
(matriz de 3x3, hay una jugada por turno, se tienen que ubicar tres fichas iguales en linea diagonal o horizonal o
vertical hasta que llene el tablero o alguien gane)
Despues de cada jugada mostrar el tablero con las fichas */

public class Triqui2 {

    static int jugador1Puntaje = 0;  // static para que podamos invocarlo en el metodo
    static int jugador2Puntaje = 0;
    static Scanner input = new Scanner(System.in);
    static String nombrej1;
    static String nombrej2;
    /*
     * Posicion1 = [0][0] Posicion2 =[0][1] , Posicion3 = [0][2]
     * Posicion4 = [1][0] , Posicion5 [1][1] , Posicion6 = [1][2]
     * Posicion7 = [2][0] , Posicion 8 = [2][1] , Posicion9 = [2][2]
     */

    public static void main(String[] args) {

        char[][] tablero = {{'_', '|', '_', '|', '_'}, {'_', '|', '_', '|', '_'}, {' ', '|', ' ', '|', ' '}}; // Para
        // imprimir el tablero
        imprimirTablero(tablero);
        boolean juegoFin = false;
        boolean juegoNuevo = true;  // Jugar

        // INICIO DEL JUEGO + REGLAS

        System.out.println("BIENVENIDO AL TRIQUI");
        System.out.println("Las reglas del juego son: ");
        System.out.println("Jugador1 = Juega primero con la X");
        System.out.println("Jugador2 = Juega segundo con la O");
        System.out.println("Las posiciones se juegan así: \n" + "Posicion 1 = [0][0] Posicion 2 =[0][1] ,Posicion 3 =" +
                " " +
                "[0][2]\n" +
                "Posicion 4 = [1][0] , Posicion 5 [1][1] , Posicion 6 = [1][2]\n" +
                "Posicion 7 = [2][0] , Posicion 8 = [2][1] , Posicion 9 = [2][2]\n");

        System.out.println("Jugador 1 digite su nombre: ");
        nombrej1 = input.nextLine();
        System.out.println("Jugador 2 digite su nombre: ");
        nombrej2 = input.nextLine();


        while (juegoNuevo) {
            while (!juegoFin) {
                System.out.println("Juguemos");
                jugador1Mueve(tablero);
                juegoFin = seAcabo(tablero);
                if (juegoFin) {
                    break;
                }

                jugador2Mueve(tablero);
                juegoFin = seAcabo(tablero);
                if (juegoFin) {
                    break;
                }
            }
            System.out.println("Puntaje de " + nombrej1 + " = " + jugador1Puntaje);
            System.out.println("Puntaje de " + nombrej2 + " = " + jugador2Puntaje);
            System.out.println("TE GUSTARIA JUGAR DE NUEVO ? S/N");
            input.nextLine();
            String resultado = input.nextLine();

            switch (resultado) {
                case "S":
                case "s":
                    juegoNuevo = true;
                    System.out.println("Listo!, juguemos de nuevo...");
                    reseteaTablero(tablero);
                    juegoFin = false;
                    imprimirTablero(tablero);
                    break;

                case "N":
                case "n":
                    juegoNuevo = false;
                    System.out.println("Gracias por jugar\n" + "Nos vemos!!");
                    break;
                default:
                    break;
            }

        }
    }

    public static void imprimirTablero(char[][] elTablero) {   // Imprimir tablero

        for (char[] fila : elTablero) {
            for (char c : fila) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void actualizaTablero(int posicion, int jugador, char[][] elTablero) {  // Posiciones

        char character;

        if (jugador == 1) {
            character = 'X';
        } else {
            character = 'O';
        }

        switch (posicion) {

            case 1:
                elTablero[0][0] = character;
                imprimirTablero(elTablero);
                break;
            case 2:
                elTablero[0][2] = character;
                imprimirTablero(elTablero);
                break;
            case 3:
                elTablero[0][4] = character;
                imprimirTablero(elTablero);
                break;
            case 4:
                elTablero[1][0] = character;
                imprimirTablero(elTablero);
                break;
            case 5:
                elTablero[1][2] = character;
                imprimirTablero(elTablero);
                break;
            case 6:
                elTablero[1][4] = character;
                imprimirTablero(elTablero);
                break;
            case 7:
                elTablero[2][0] = character;
                imprimirTablero(elTablero);
                break;
            case 8:
                elTablero[2][2] = character;
                imprimirTablero(elTablero);
                break;
            case 9:
                elTablero[2][4] = character;
                imprimirTablero(elTablero);
                break;
            default:
                break;

        }

    }

    public static void jugador1Mueve(char[][] elTablero) {  // Movimientos jugador #1

        System.out.println(nombrej1 + " es tu turno: "); // AGREGAR UN SCANNER PARA NOMBRE DE JUGADORES
        System.out.println("Porfavor realiza un movimiento del 1-9");

        int movimiento = input.nextInt();

        boolean resultado = movimientoInvalido(movimiento, elTablero);

        while (!resultado) {
            System.out.println("Movimiento invalido!, Prueba de nuevo");
            movimiento = input.nextInt();
            resultado = movimientoInvalido(movimiento, elTablero);
        }

        System.out.println(nombrej1 + " jugó " + movimiento);
        actualizaTablero(movimiento, 1, elTablero);

    }

    public static boolean movimientoInvalido(int movimiento, char[][] elTablero) {  // Movimientos con marcas

        switch (movimiento) {
            case 1:
                if (elTablero[0][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (elTablero[0][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (elTablero[0][4] == '_') {
                    return true;
                } else {
                    return false;
                }

            case 4:
                if (elTablero[1][0] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (elTablero[1][2] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 6:
                if (elTablero[1][4] == '_') {
                    return true;
                } else {
                    return false;
                }
            case 7:
                if (elTablero[2][0] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 8:
                if (elTablero[2][2] == ' ') {
                    return true;
                } else {
                    return false;
                }
            case 9:
                if (elTablero[2][4] == ' ') {
                    return true;
                } else {
                    return false;
                }

            default:
                return false;
        }

    }

    public static void jugador2Mueve(char[][] elTablero) {  // Movimientos jugador #2

        System.out.println(nombrej2 + " es tu turno: ");
        System.out.println("Porfavor realiza un movimiento del 1-9");

        int movimiento = input.nextInt();

        boolean resultado = movimientoInvalido(movimiento, elTablero);

        while (!resultado) {
            System.out.println("Movimiento invalido!, Prueba de nuevo");
            movimiento = input.nextInt();
            resultado = movimientoInvalido(movimiento, elTablero);
        }

        System.out.println(nombrej2 + " jugó: " + movimiento);
        actualizaTablero(movimiento, 2, elTablero);

    }

    public static boolean seAcabo(char[][] elTablero) {  // Victorias

        // Victoria horizontal
        if (elTablero[0][0] == 'X' && elTablero[0][2] == 'X' && elTablero[0][4] == 'X') {
            System.out.println(nombrej1 + " GANA!!");
            jugador1Puntaje++;
            return true;
        }
        if (elTablero[0][0] == 'O' && elTablero[0][2] == 'O' && elTablero[0][4] == 'O') {
            System.out.println(nombrej2 + " GANA!!");
            jugador2Puntaje++;
            return true;
        }
        if (elTablero[1][0] == 'X' && elTablero[1][2] == 'X' && elTablero[1][4] == 'X') {
            System.out.println(nombrej1 + " GANA!!");
            jugador1Puntaje++;
            return true;
        }
        if (elTablero[1][0] == 'O' && elTablero[1][2] == 'O' && elTablero[1][4] == 'O') {
            System.out.println(nombrej2 + " GANA!!");
            jugador2Puntaje++;
            return true;
        }
        if (elTablero[2][0] == 'X' && elTablero[2][2] == 'X' && elTablero[2][4] == 'X') {
            System.out.println(nombrej1 + " GANA!!");
            jugador1Puntaje++;
            return true;
        }
        if (elTablero[2][0] == 'O' && elTablero[2][2] == 'O' && elTablero[2][4] == 'O') {
            System.out.println(nombrej2 + " GANA!!");
            jugador2Puntaje++;
            return true;
        }

        // Victorias verticales

        if (elTablero[0][0] == 'X' && elTablero[1][0] == 'X' && elTablero[2][0] == 'X') {
            System.out.println(nombrej1 + " GANA!!");
            jugador1Puntaje++;
            return true;
        }
        if (elTablero[0][0] == 'O' && elTablero[1][0] == 'O' && elTablero[2][0] == 'O') {
            System.out.println(nombrej2 + " GANA!!");
            jugador2Puntaje++;
            return true;
        }

        if (elTablero[0][2] == 'X' && elTablero[1][2] == 'X' && elTablero[2][2] == 'X') {
            System.out.println(nombrej1 + " GANA!!");
            jugador1Puntaje++;
            return true;
        }
        if (elTablero[0][2] == 'O' && elTablero[1][2] == 'O' && elTablero[2][2] == 'O') {
            System.out.println(nombrej2 + " GANA!!");
            jugador2Puntaje++;
            return true;
        }

        if (elTablero[0][4] == 'X' && elTablero[1][4] == 'X' && elTablero[2][4] == 'X') {
            System.out.println(nombrej1 + " GANA!!");
            jugador1Puntaje++;
            return true;
        }
        if (elTablero[0][4] == 'O' && elTablero[1][4] == 'O' && elTablero[2][4] == 'O') {
            System.out.println(nombrej2 + " GANA!!");
            jugador2Puntaje++;
            return true;
        }

        // Victorias Diagonales
        if (elTablero[0][0] == 'X' && elTablero[1][2] == 'X' && elTablero[2][4] == 'X') {
            System.out.println(nombrej1 + " GANA!!");
            jugador1Puntaje++;
            return true;
        }
        if (elTablero[0][0] == 'O' && elTablero[1][2] == 'O' && elTablero[2][4] == 'O') {
            System.out.println(nombrej2 + " GANA!!");
            jugador2Puntaje++;
            return true;
        }

        if (elTablero[2][0] == 'X' && elTablero[1][2] == 'X' && elTablero[0][4] == 'X') {
            System.out.println(nombrej1 + " GANA!!");
            jugador1Puntaje++;
            return true;
        }
        if (elTablero[2][0] == 'O' && elTablero[1][2] == 'O' && elTablero[0][4] == 'O') {
            System.out.println(nombrej2 + " GANA!!");
            jugador2Puntaje++;
            return true;
        }

        if (elTablero[0][0] != '_' && elTablero[0][2] != '_' && elTablero[0][4] != '_' && elTablero[1][0] != '_'
                && elTablero[1][2] != '_' && elTablero[1][4] != '_' && elTablero[2][0] != ' ' && elTablero[2][2] != ' '
                && elTablero[2][4] != ' ') {
            System.out.println("EMPATE!!");
            return true;
        }

        return false;
    }

    public static void reseteaTablero(char[][] elTablero) {
        elTablero[0][0] = '_';
        elTablero[0][2] = '_';
        elTablero[0][4] = '_';
        elTablero[1][0] = '_';
        elTablero[1][2] = '_';
        elTablero[1][4] = '_';
        elTablero[2][0] = ' ';
        elTablero[2][2] = ' ';
        elTablero[2][4] = ' ';

    }
}