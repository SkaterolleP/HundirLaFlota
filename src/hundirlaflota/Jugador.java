/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Jugador {
    public String Nombre;
    private ArrayList<Barco> Barcos = new ArrayList<Barco>();
    private ArrayList<Barco> BarcosAuto = new ArrayList<Barco>();
    private Tablero Jug = new Tablero(Barcos);
    private Tablero Auto = new Tablero(BarcosAuto);
}
