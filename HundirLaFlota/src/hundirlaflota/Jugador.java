/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

import java.util.ArrayList;
import java.util.Scanner;

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
    private Disparo di = new Disparo();

    Jugador(String nom) {
        Nombre = nom;
        Ubicar();
        UbicarNaves(5, 5, 6, "Ab");
        di.DisparoInt(5, 5, Jug);
        di.DisparoAle(Jug);
        //System.out.println("X-->"+BarcosAuto.get(1).getPosX()+"|| Y-->"+BarcosAuto.get(1).getPosY()+"|| Tam->"+BarcosAuto.get(1).getTamaño());
        //System.out.println("X-->"+BarcosAuto.get(0).getPosX()+"|| Y-->"+BarcosAuto.get(0).getPosY()+"|| Tam->"+BarcosAuto.get(0).getTamaño());
    }

    public void show() {
        System.out.print("*");
        for (int i = 0; i < 10; i++) {
            System.out.print("\t");
            System.out.print(i + 1);
        }
        System.out.print("\t");
        System.out.print("||");
        for (int i = 0; i < 10; i++) {
            System.out.print("\t");
            System.out.print(i + 1);
        }
        System.out.println("\n");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + 1);
            System.out.print("\t");
            for (int j = 0; j < 10; j++) {
                System.out.print(Jug.casillas[i][j]);
                System.out.print("\t");
            }
            System.out.print("||");
            System.out.print("\t");
            for (int j = 0; j < 10; j++) {
                System.out.print(Auto.casillas[i][j]);
                System.out.print("\t");
            }
            System.out.println("\n");
        }
    }

    private boolean UbicarNaves(int tam, int PosX, int PosY, String s) {
        boolean dev = false;
        if ((s == "Ar" && PosY >= (tam - 1) && (PosY - tam) >= 0) || (s == "Ab" && (PosY + tam - 1) <= 10) || (s == "I" && PosX >= (tam - 1)) || (s == "D" && (PosX + tam - 1) <= 10)) {
            if (s == "D") {
                for (int i = PosY - 1; i < PosY; i++) {
                    for (int j = PosX - 1; j < PosX + tam - 1; j++) {
                        Jug.casillas[i][j] = "#";
                    }
                }
                dev = true;
            } else if (s == "I") {
                for (int i = PosY - 1; i < PosY; i++) {
                    for (int j = PosX - tam; j < PosX; j++) {
                        Jug.casillas[i][j] = "#";
                    }
                }
                dev = true;
            } else if (s == "Ar") {
                for (int i = PosY - tam; i < PosY; i++) {
                    for (int j = PosX; j < PosX + 1; j++) {
                        Jug.casillas[i][j] = "#";
                    }
                }
                dev = true;
            } else if (s == "Ab") {
                for (int i = PosY - 1; i < PosY + tam - 1; i++) {
                    for (int j = PosX; j < PosX + 1; j++) {
                        Jug.casillas[i][j] = "#";
                    }
                }
                dev = true;
            }
        } else {
            System.out.println("La posición no está en una posición permitida");
            return dev;
        }
        return dev;
    }

    public void Jugar() {
        int todos = 0;
        while (todos < 1) {
            Barco n = new Barco();
            Scanner t = new Scanner(System.in);
            boolean cor = false;
            while (!cor) {
                System.out.print("Introduzca la dirección del barco(D,I,Ar,Ab)= ");
                String dire = t.next();
                System.out.print("-----"+dire+"\n");
                cor = true;
                int d;
                if (dire.equals("D")) {
                    d = 0;
                } else if (dire.equals("I")) {
                    d = 1;
                } else if (dire.equals("Ar")) {
                    d = 2;
                } else if (dire.equals("Ab")) {
                    d = 3;
                } else {
                    System.out.println("No introdujo un valor permitido, vueva a meter la dirección");
                    System.out.println("");
                    cor = false;
                }
            }
            if (todos == 0) {
                n.setTamaño(5);
            } else if (todos == 1 || todos == 2) {
                n.setTamaño(4);
            } else if (todos > 2 && todos < 6) {
                n.setTamaño(3);
            } else if (todos > 5) {
                n.setTamaño(4);
            }
            boolean pue = false;
        }
    }

    private void Ubicar() {
        int todos = 0;
        while (todos < 10) {
            Barco n = new Barco();
            int d = (int) (Math.random() * 4);
            if (todos == 0) {
                n.setTamaño(5);
            } else if (todos == 1 || todos == 2) {
                n.setTamaño(4);
            } else if (todos > 2 && todos < 6) {
                n.setTamaño(3);
            } else if (todos > 5) {
                n.setTamaño(4);
            }
            boolean pue = false;
            while (!pue) {
                pue = true;
                if (d == 0 && n.getTamaño() == 5) {
                    n.setPosX((int) (Math.random() * 9) + 1);
                    n.setPosY((int) (Math.random() * 5) + 1);
                } else if (d == 0 && n.getTamaño() == 4) {
                    n.setPosX((int) (Math.random() * 9) + 1);
                    n.setPosY((int) (Math.random() * 6) + 1);
                } else if (d == 0 && n.getTamaño() == 3) {
                    n.setPosX((int) (Math.random() * 9) + 1);
                    n.setPosY((int) (Math.random() * 7) + 1);
                } else if (d == 0 && n.getTamaño() == 2) {
                    n.setPosX((int) (Math.random() * 9) + 1);
                    n.setPosY((int) (Math.random() * 8) + 1);
                } else if (d == 1 && n.getTamaño() == 5) {
                    n.setPosX((int) (Math.random() * 9) + 1);
                    n.setPosY((int) (n.getTamaño() + Math.random() * 5) + 1);
                } else if (d == 1 && n.getTamaño() == 4) {
                    n.setPosX((int) (Math.random() * 9) + 1);
                    n.setPosY((int) (n.getTamaño() + Math.random() * 6) + 1);
                } else if (d == 1 && n.getTamaño() == 3) {
                    n.setPosX((int) (Math.random() * 9) + 1);
                    n.setPosY((int) (n.getTamaño() + Math.random() * 7) + 1);
                } else if (d == 1 && n.getTamaño() == 2) {
                    n.setPosX((int) (Math.random() * 9) + 1);
                    n.setPosY((int) (n.getTamaño() + Math.random() * 8) + 1);
                } else if (d == 2 && n.getTamaño() == 5) {
                    n.setPosX((int) (n.getTamaño() + Math.random() * 5) + 1);
                    n.setPosY((int) (Math.random() * 9) + 1);
                } else if (d == 2 && n.getTamaño() == 4) {
                    n.setPosX((int) (n.getTamaño() + Math.random() * 6) + 1);
                    n.setPosY((int) (Math.random() * 9) + 1);
                } else if (d == 2 && n.getTamaño() == 3) {
                    n.setPosX((int) (n.getTamaño() + Math.random() * 7) + 1);
                    n.setPosY((int) (Math.random() * 9) + 1);
                } else if (d == 2 && n.getTamaño() == 2) {
                    n.setPosX((int) (n.getTamaño() + Math.random() * 8) + 1);
                    n.setPosY((int) (Math.random() * 9) + 1);
                } else if (d == 3 && n.getTamaño() == 5) {
                    n.setPosX((int) (Math.random() * 5) + 1);
                    n.setPosY((int) (Math.random() * 9) + 1);
                } else if (d == 3 && n.getTamaño() == 4) {
                    n.setPosX((int) (Math.random() * 6) + 1);
                    n.setPosY((int) (Math.random() * 9) + 1);
                } else if (d == 3 && n.getTamaño() == 3) {
                    n.setPosX((int) (Math.random() * 7) + 1);
                    n.setPosY((int) (Math.random() * 9) + 1);
                } else if (d == 3 && n.getTamaño() == 2) {
                    n.setPosX((int) (Math.random() * 8) + 1);
                    n.setPosY((int) (Math.random() * 9) + 1);
                }
                int di = 0;
                if (d == 0) {
                    while (pue && di < n.getTamaño()) {
                        if (Auto.casillas[n.getPosX() - 1][n.getPosY() + di - 1] == "#") {
                            pue = false;
                        }
                        di++;
                    }
                } else if (d == 1) {
                    while (pue && di < n.getTamaño()) {
                        if (Auto.casillas[n.getPosX() - 1][n.getPosY() - di - 1] == "#") {
                            pue = false;
                        }
                        di++;
                    }
                } else if (d == 2) {
                    while (pue && di < n.getTamaño()) {
                        if (Auto.casillas[n.getPosX() - di - 1][n.getPosY() - 1] == "#") {
                            pue = false;
                        }
                        di++;
                    }
                } else if (d == 3) {
                    while (pue && di < n.getTamaño()) {
                        if (Auto.casillas[n.getPosX() + di - 1][n.getPosY() - 1] == "#") {
                            pue = false;
                        }
                        di++;
                    }
                }
            }
            n.setD(d);
            //System.out.println("X-->" + n.getPosX() + "|| Y-->" + n.getPosY() + "|| Tam->" + n.getTamaño() + "|| Dir-->" + n.getD());

            if (d == 0) {
                for (int i = n.getPosX() - 1; i < n.getPosX(); i++) {
                    for (int j = n.getPosY() - 1; j < n.getPosY() + n.getTamaño() - 1; j++) {
                        Auto.casillas[i][j] = "#";
                    }
                }
            } else if (d == 1) {
                for (int i = n.getPosX() - 1; i < n.getPosX() - 1; i++) {
                    for (int j = n.getPosY() - n.getTamaño(); j < n.getPosY(); j++) {
                        Auto.casillas[i][j] = "#";
                    }
                }
            } else if (d == 2) {
                for (int i = n.getPosX() - n.getTamaño(); i < n.getPosX(); i++) {
                    for (int j = n.getPosY() - 1; j < n.getPosY(); j++) {
                        Auto.casillas[i][j] = "#";
                    }
                }
            } else if (d == 3) {
                for (int i = n.getPosX() - 1; i < n.getPosX() + n.getTamaño() - 1; i++) {
                    for (int j = n.getPosY() - 1; j < n.getPosY(); j++) {
                        Auto.casillas[i][j] = "#";
                    }
                }
            }
            todos++;
            BarcosAuto.add(n);
        }
    }
}
