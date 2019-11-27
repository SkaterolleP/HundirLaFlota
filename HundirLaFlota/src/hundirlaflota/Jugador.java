/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

import java.util.ArrayList;

/**
 *
 * @author alberto
 */
public class Jugador {

    public String Nombre;
    private ArrayList<Barco> Barcos = new ArrayList<Barco>();
    private ArrayList<Barco> BarcosAuto = new ArrayList<Barco>();
    public Tablero Jug = new Tablero(Barcos);
    private Tablero Auto = new Tablero(BarcosAuto);

    Jugador(String nom) {
        Nombre = nom;
        UbicarNaves(5, 4, 5, "D");
    }

    public void show(Tablero p) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(p.casillas[i][j]);
                System.out.print("\t");
            }
            System.out.println("\n");
        }
    }

    private boolean UbicarNaves(int tam, int PosX, int PosY, String s) {
        boolean dev = false;
        if ((s == "Ar" && PosY >= (tam - 1)) || (s == "Ab" && (PosY + tam - 1) <= 9) || (s == "I" && PosX >= (tam - 1)) || (s == "D" && (PosX + tam - 1) <= 9)) {
            if (s == "D") {
                for (int i = PosY -1; i < PosY; i++) {
                    for (int j = PosX-1; j < PosX + tam -1; j++) {
                        Jug.casillas[i][j] = "#";
                    }
                }
            } else if (s == "I") {

            } else if (s == "Ar") {

            } else if (s == "Ab") {

            }
        } else {
            System.out.println("La posición no está en una posición permitida");
            return dev;
        }
        return dev;
    }
}
