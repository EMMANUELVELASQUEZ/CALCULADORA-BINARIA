package juego;

import java.util.Random;
import java.util.Scanner;

public class buscamins {
    private static final int FILAS = 8;
    private static final int COLUMNAS = 8;
    private static final int MINAS = 10;
    private static char[][] tablero = new char[FILAS][COLUMNAS];
    private static boolean[][] minas = new boolean[FILAS][COLUMNAS];
    private static boolean[][] descubierto = new boolean[FILAS][COLUMNAS];

    private static final String RESET = "\u001B[0m";
    private static final String ROJO = "\u001B[31m";
    private static final String VERDE = "\u001B[32m";
    private static final String AMARILLO = "\u001B[33m";
    private static final String AZUL = "\u001B[34m";

    public static void main(String[] args) {
        inicializarTablero();
        colocarMinas();
        jugar();
    }

    private static void inicializarTablero() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = '-';
                descubierto[i][j] = false;
            }
        }
    }

    private static void colocarMinas() {
        Random random = new Random();
        int colocadas = 0;
        while (colocadas < MINAS) {
            int fila = random.nextInt(FILAS);
            int columna = random.nextInt(COLUMNAS);
            if (!minas[fila][columna]) {
                minas[fila][columna] = true;
                colocadas++;
            }
        }
    }

    private static void jugar() {
        Scanner scanner = new Scanner(System.in);
        boolean juegoTerminado = false;
        while (!juegoTerminado) {
            imprimirTableroDecorado();
            System.out.print("Para iniciar el juego ingresa la fila y columna ( 0 - 7 ), separadas por un espacio: ");
            int fila = scanner.nextInt();
            int columna = scanner.nextInt();

            if (minas[fila][columna]) {
                System.out.println(ROJO + "¡Boom! Lastima Pisaste una mina. ¡Fin del juego!." + RESET);
                juegoTerminado = true;
                mostrarMinas();
            } else {
                descubrir(fila, columna);
                if (verificarVictoria()) {
                    System.out.println(VERDE
                            + "¡Felicidades Amigo! Has encontrado todas las minas.  Nuevo nivel logrado"
                            + RESET);
                    juegoTerminado = true;
                }
            }
        }
        scanner.close();
    }

    private static void imprimirTableroDecorado() {
        System.out.print(AZUL + "    ");
        for (int i = 0; i < COLUMNAS; i++) {
            System.out.print(i + " ");
        }
        System.out.println(RESET);
        System.out.println(AZUL + "   +-----------------+" + RESET);
        for (int i = 0; i < FILAS; i++) {
            System.out.print(AZUL + i + " | " + RESET);
            for (int j = 0; j < COLUMNAS; j++) {
                if (descubierto[i][j]) {
                    if (tablero[i][j] == '*') {
                        System.out.print(ROJO + tablero[i][j] + " " + RESET);
                    } else if (tablero[i][j] == ' ') {
                        System.out.print("  ");
                    } else {
                        System.out.print(AMARILLO + tablero[i][j] + " " + RESET);
                    }
                } else {
                    System.out.print(AZUL + "- " + RESET);
                }
            }
            System.out.println(AZUL + "|" + RESET);
        }
        System.out.println(AZUL + "   +-----------------+" + RESET);
    }

    private static void descubrir(int fila, int columna) {
        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS || descubierto[fila][columna]) {
            return;
        }
        descubierto[fila][columna] = true;

        int minasCercanas = contarMinasCercanas(fila, columna);
        if (minasCercanas > 0) {
            tablero[fila][columna] = (char) (minasCercanas + '0');
        } else {
            tablero[fila][columna] = ' ';
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i != 0 || j != 0) {
                        descubrir(fila + i, columna + j);
                    }
                }
            }
        }
    }

    private static int contarMinasCercanas(int fila, int columna) {
        int cuenta = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nuevaFila = fila + i;
                int nuevaColumna = columna + j;
                if (nuevaFila >= 0 && nuevaFila < FILAS && nuevaColumna >= 0 && nuevaColumna < COLUMNAS
                        && minas[nuevaFila][nuevaColumna]) {
                    cuenta++;
                }
            }
        }
        return cuenta;
    }

    private static void mostrarMinas() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (minas[i][j]) {
                    tablero[i][j] = '*';
                }
            }
        }
        imprimirTableroDecorado();
    }

    private static boolean verificarVictoria() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (!minas[i][j] && !descubierto[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
