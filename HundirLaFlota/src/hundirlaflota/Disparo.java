/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hundirlaflota;

/**
 *
 * @author alberto
 */
public class Disparo {

    private boolean tocado = false;
    private int to[] = new int[4];
    private int PosX;
    private int PosY;
    private int intento = 0;
    private String dir;

    Disparo() {
        for (int i = 0; i < 4; i++) {
            to[i] = 0;
        }
    }

    public int DisparoAle(Tablero P) {
        //if (!tocado) {
        boolean toc = true;
        int posx;
        int posy;
        while (toc) {
            posx = (int) (Math.random() * 10);
            posy = (int) (Math.random() * 10);
            if (P.casillas[posx][posy] == "~" || P.casillas[posx][posy] == "#") {
                toc = false;
                if (P.casillas[posx][posy] == "~") {
                    P.casillas[posx][posy] = "*";
                } else {
                    P.casillas[posx][posy] = "@";
                    P.setBarcosRes();
                    P.setTirosReal();
                    tocado = true;
                    PosX = posx;
                    PosY = posy;
                }
            }
        }
        // } else {
        //     DisparoToc(P);
        // }
        return P.getBarcosRes();

    }

    public void DisparoToc(Tablero P) {
        if (intento == 3) {
            if (to[0] == 0) {
                if (P.casillas[PosX + 1][PosY] == "~") {
                    P.casillas[PosX + 1][PosY] = "*";
                    to[0] = 1;
                } else if (P.casillas[PosX + 1][PosY] == "#") {
                    P.casillas[PosX + 1][PosY] = "@";
                    tocado = true;
                    intento = 0;
                }
            } else if (to[1] == 0) {

            } else if (to[2] == 0) {

            } else if (to[3] == 0) {

            }
        }
    }

    public int DisparoInt(int Posx, int Posy, Tablero P) {
        if (P.casillas[Posx][Posy] == "~") {
            P.casillas[Posx][Posy] = "*";
        } else if (P.casillas[Posx][Posy] == "#") {
            P.casillas[Posx][Posy] = "@";
            P.setBarcosRes();
            P.setTirosReal();
        } else {
            System.out.println("Ya habias disparado en esta posición");
        }
        return P.getBarcosRes();
    }
}
